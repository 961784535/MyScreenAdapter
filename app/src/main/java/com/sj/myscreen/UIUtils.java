package com.sj.myscreen;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/6/7.
 * 通过ui绘制的基准屏幕尺寸，运行时代码测量机型屏幕尺寸，并计算出起缩放系数，以便对外使用
 */

public class UIUtils {
    // 思路
    // 1.取得实际设备宽高
    // 2.通过实际设备宽高，对参照设备宽高进行比例换算
    //  给出系数

    private Context context;

    //参照宽高
    public final float STANDARD_WIDTH = 720;
    public final float STANDARD_HEIGHT = 1232;

    //当前设备实际宽高
    public float displayMetricsWidth;
    public float displayMetricsHeight;

    private static UIUtils utils;

    private final String DIMEN_CLASS = "com.android.internal.R$dimen";


    private UIUtils(Context context) {
        this.context = context;
        //
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        //加载当前界面信息
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);

        if (displayMetricsWidth == 0.0f || displayMetricsHeight == 0.0f) {
            //获取状态框信息
            int systemBarHeight = getValue(context, "system_bar_height", 48);

            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.displayMetricsWidth = displayMetrics.heightPixels;
                this.displayMetricsHeight = displayMetrics.widthPixels - systemBarHeight;
            } else {
                this.displayMetricsWidth = displayMetrics.widthPixels;
                this.displayMetricsHeight = displayMetrics.heightPixels - systemBarHeight;
            }

        }
    }


    public static UIUtils getInstance(Context context) {
        if (utils == null) {
            utils = new UIUtils(context);
        }
        return utils;
    }


    //对外提供系数
    public float getHorizontalScaleValue() {
        return displayMetricsWidth / STANDARD_WIDTH;
    }

    public float getVerticalScaleValue() {

        Log.i("testbarry", "displayMetricsHeight:" + displayMetricsHeight);
        return displayMetricsHeight / STANDARD_HEIGHT;
    }


    public int getValue(Context context, String systemid, int defValue) {

        try {
            Class<?> clazz = Class.forName(DIMEN_CLASS);
            Object r = clazz.newInstance();
            Field field = clazz.getField(systemid);
            int x = (int) field.get(r);
            return context.getResources().getDimensionPixelOffset(x);

        } catch (Exception e) {
            return defValue;
        }
    }



}
