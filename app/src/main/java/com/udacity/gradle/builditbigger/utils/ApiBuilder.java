package com.udacity.gradle.builditbigger.utils;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import com.zsergei.joke.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Sergei Zarochentsev on 26.03.2016.
 *
 */
public class ApiBuilder {

    private static final String URL = "http://10.0.2.2:8085/_ah/api/";

    public static synchronized MyApi getApi() {
        final MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl(URL)
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(
                            final AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws
                            IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
        return builder.build();
    }
}
