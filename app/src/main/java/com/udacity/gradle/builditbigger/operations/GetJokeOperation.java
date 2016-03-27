package com.udacity.gradle.builditbigger.operations;

import com.redmadrobot.chronos.ChronosOperation;
import com.redmadrobot.chronos.ChronosOperationResult;
import com.udacity.gradle.builditbigger.utils.ApiBuilder;
import com.zsergei.joke.backend.myApi.MyApi;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by Sergei Zarochentsev on 26.03.2016.
 *
 */
public class GetJokeOperation extends ChronosOperation<String> {

    @Nullable
    @Override
    public String run() {
        final MyApi myApiService = ApiBuilder.getApi();
        try {
            return myApiService.getJoke().execute().getData();
        } catch (final IOException e) {
            throw new RuntimeException();
        }
    }

    @NonNull
    @Override
    public Class<? extends ChronosOperationResult<String>> getResultClass() {
        return Result.class;
    }

    public final static class Result extends ChronosOperationResult<String> {
    }
}
