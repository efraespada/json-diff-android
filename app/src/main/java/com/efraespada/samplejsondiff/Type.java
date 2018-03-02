package com.efraespada.samplejsondiff;

/**
 * Created by efrainespada on 19/01/2018.
 */

public enum Type {

    AFTER("after"),
    BEFORE("before");

    private String url;

    Type(String url) {
        this.url = url + ".json";
    }

    public String getUrl() {
        return url;
    }

}
