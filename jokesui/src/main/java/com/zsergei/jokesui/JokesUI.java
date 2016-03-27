package com.zsergei.jokesui;

import com.zsergei.jokesui.components.JokeActivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by Sergei Zarochentsev on 21.03.2016.
 */
public class JokesUI implements IJokesUI {


    @Override
    public void showJokeInNewActivity(@NonNull final Context context, @NonNull final String joke) {
        final Intent startJokeActivityIntent = new Intent(context, JokeActivity.class);
        startJokeActivityIntent.putExtra( JOKE_KEY, joke );

        context.startActivity(startJokeActivityIntent);
    }
}
