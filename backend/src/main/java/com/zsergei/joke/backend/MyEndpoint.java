/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.zsergei.joke.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.example.JokeProvider;
import com.example.Joker;


/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.joke.zsergei.com",
    ownerName = "backend.joke.zsergei.com",
    packagePath=""
  )
)
public class MyEndpoint {

    private static final JokeProvider mJokeProvider = new Joker();
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        return new MyBean( mJokeProvider.getJoke() );
    }

}
