package com.efraespada.samplejsondiff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.efraespada.jsondiff.JSONDiff;

import org.json.JSONObject;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = JSONDiff.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject after =  JSONUtils.getJSON(this, Type.AFTER);
        JSONObject before = JSONUtils.getJSON(this, Type.BEFORE);

        Map<String, JSONObject> diff = JSONDiff.diff(before, after);

        Log.e(TAG, diff.get("$set").toString());
        Log.e(TAG, diff.get("$unset").toString());
        Log.e(TAG, diff.get("$rename").toString());
    }
}
