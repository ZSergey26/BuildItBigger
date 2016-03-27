package com.zsergei.joke.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private final String mData;
    public MyBean(final String data) {
        super();
        mData = data;
    }

    public String getData() {
        return mData;
    }
}