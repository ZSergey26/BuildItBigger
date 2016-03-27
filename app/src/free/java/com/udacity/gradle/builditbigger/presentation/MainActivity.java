package com.udacity.gradle.builditbigger.presentation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import com.redmadrobot.chronos.gui.activity.ChronosAppCompatActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.operations.GetJokeOperation;
import com.zsergei.jokesui.IJokesUI;
import com.zsergei.jokesui.JokesUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
I'm prefer Chronos lib by REDMADROBOT to Async task
Passing context to async task may cause memory leaks
 */
public class MainActivity extends ChronosAppCompatActivity {

    private final IJokesUI mJokesUI = new JokesUI();

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                runOperation(new GetJokeOperation());
            }
        });

        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        final AdRequest  adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        final int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Calls via reflection when operation is completed
    public void onOperationFinished(final GetJokeOperation.Result result) {
        if(result.isSuccessful()) {
            mJokesUI.showJokeInNewActivity(this, result.getOutput());
        } else {
            Toast.makeText(this, R.string.get_joke_loading_error, Toast.LENGTH_LONG).show();
        }
    }

    // On button pressed
    public void tellJoke(final View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            runOperation(new GetJokeOperation());
        }
    }


}
