package com.udacity.gradle.builditbigger;

import com.udacity.gradle.builditbigger.presentation.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.IsNot.not;


/**
 * Created by Sergei Zarochentsev on 27.03.2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class JokeFetchingTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void fetchJoke() {
        onView(withId(R.id.jokeButton)).perform(click());

        onView(withId(R.id.jokeTextView))
                .check(matches(withText(not(isEmptyString()))));
    }
    
}
