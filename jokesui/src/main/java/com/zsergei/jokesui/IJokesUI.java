package com.zsergei.jokesui;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Sergei Zarochentsev on 21.03.2016.
 */
public interface IJokesUI {

    String JOKE_KEY = "JOKE";

    void showJokeInNewActivity(@NonNull Context context, @NonNull String joke);
}
