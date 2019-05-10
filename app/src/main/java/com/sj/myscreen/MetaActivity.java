package com.sj.myscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.orhanobut.logger.Logger;

import org.json.JSONStringer;


/**
 * @data: 2019/3/8
 * @author: ArJun
 * 描述: 刘海屏适配
 *
 *
 *
 */
public class MetaActivity extends AppCompatActivity {

    private String TAG="result";
    String JSON_CONTENT = "{\"weatherinfo\":{\"city\":\"北京\",\"cityid\":\"101010100\"," +
            "\"temp\":\"-2\",\"WD\":\"西北风\",\"WS\":\"3级\",\"SD\":\"241%\",\"WSE\":\"3\"," +
            "\"time\":\"10:61\",\"isRadar\":\"1\",\"Radar\":\"JC_RADAR_AZ9010_JB\"}}";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta);
        Logger.i(JSON_CONTENT);
        Logger.json(JSON_CONTENT);
        Log.i(TAG, "onCreate: "+ MetaActivity.class.getSimpleName());
        Log.i(TAG, "onCreate: "+ MetaActivity.class.getName());
        Log.i(TAG, "onCreate: "+ MetaActivity.class.getCanonicalName());
    }
}

