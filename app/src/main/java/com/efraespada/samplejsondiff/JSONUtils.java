package com.efraespada.samplejsondiff;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by efrainespada on 19/01/2018.
 */

public class JSONUtils {

    private JSONUtils() {
        // nothing to do here
    }

    private static String getString(Context context, Type type) {
        InputStream is = null;
        StringBuilder content = null;
        try {
            AssetManager assetManager = context.getResources().getAssets();
            is = assetManager.open(type.getUrl());
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content == null ? null : content.toString();
    }

    public static JSONObject getJSON(Context context, Type type) {
        InputStream is = null;
        JSONObject jsonObject = null;
        try {
            String content = getString(context, type);
            if (content != null) {
                jsonObject = new JSONObject(content);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONArray getJSONArray(Context context, Type type) {
        InputStream is = null;
        JSONArray jsonArray = null;
        try {
            String content = getString(context, type);
            if (content != null) {
                jsonArray = new JSONArray(content);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

}
