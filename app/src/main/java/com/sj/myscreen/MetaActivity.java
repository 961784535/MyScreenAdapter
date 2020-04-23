package com.sj.myscreen;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.orhanobut.logger.Logger;




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
        /// 刘海屏需要处理的两种清醒，1 ，沉浸式页面  2，全屏页面显示
        // 1.沉浸式页面即，透明状态栏(图片见附件1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
//        方法一 :利用fitsSystemWindows属性
//        当我们给最外层View设置了android:fitsSystemWindows="true"属性后，当设置了透明状态栏或者透明导航栏后，就会自动给View添加paddingTop或paddingBottom属性，这样就在屏幕上预留出了状态栏的高度，我们的布局就不会占用状态栏来显示了。
//        方法二.根据状态栏高度手动设置paddingTop
//        LinearLayout llRoot = findViewById(R.id.ll_root);
//        // 设置根布局的paddingTop
//        llRoot.setPadding(0, getStatusBarHeight(this), 0, 0);
//        方法三.在布局中添加一个和状态栏高度相同的View
//        LinearLayout llRoot = findViewById(R.id.ll_root);
//        View statusBarView = new View(this);
//        statusBarView.setBackgroundColor(Color.TRANSPARENT);
//        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                getStatusBarHeight(this));
//        // 在根布局中添加一个状态栏高度的View
//        llRoot.addView(statusBarView, 0, lp);


        // 2.全屏页面显示
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//    解决方案可参考https://blog.csdn.net/Coo123_/article/details/88822485

        Logger.i(JSON_CONTENT);
        Logger.json(JSON_CONTENT);
        Log.i(TAG, "onCreate: "+ MetaActivity.class.getSimpleName());
        Log.i(TAG, "onCreate: "+ MetaActivity.class.getName());
        Log.i(TAG, "onCreate: "+ MetaActivity.class.getCanonicalName());
    }


    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

}

