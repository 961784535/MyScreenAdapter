package com.sj.myscreen;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

/**
 * @data: 2018/7/4
 * @author: ArJun
 * 描述: 屏幕适配，获取基本的屏幕尺寸  以及设置 dimen dp px 效果查看
 */
public class ScreenActivity extends Activity {

    private String TAG = "Screen";
    private TextView textView;
    StringBuilder sb=null;

    /**
     * px = dp * (dpi / 160)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        textView = (TextView) findViewById(R.id.textView);
        sb=new StringBuilder();
        //获取swdp方案
        DisplayMetrics dm = new DisplayMetrics();
        //getMetrics()获取屏幕去除虚拟按键后的宽高
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widthPixels = dm.widthPixels;//  屏幕宽（像素，如：480px）
        int heightPixels = dm.heightPixels;// 屏幕高（像素，如：800px）

        float density = dm.density; //屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        //  density = densityDPI /160
        float densityDPI = dm.densityDpi; // 屏幕密度（每寸像素点：120/160/240/320）
        /**
         * px = dp * (dpi / 160)
         */
        float widthDP = widthPixels / density;//  屏幕宽度dp

        //getRealMetrics  获取屏幕真实的宽高
        DisplayMetrics dm2 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dm2);
        int width = dm2.widthPixels;
        int height = dm2.heightPixels;
        Log.i(TAG, "屏幕宽（像素，如：480px）: widthPx=" + width);
        Log.i(TAG, "屏幕高（像素，如：800px）：heightPx=" + height);
        float heightdp = (height - heightPixels) / density;
        Log.i(TAG, "虚拟键所占用的像素(dp):heightDp=" + heightdp);
        sb.append("--获取屏幕去除虚拟按键后的宽高--").append("\n")
                .append("屏幕宽（像素，如：480px）: widthPixels=" + widthPixels).append("\n")
                .append("屏幕高（像素，如：800px）：heightPixels=" + heightPixels).append("\n")
                .append("屏幕密度(像素比例, 120/160/240/320): densityDPI= " + densityDPI).append("\n")
                .append("屏幕密度(像素比例, 0.75/1.0/1.5/2.0): density=" + density).append("\n")
                .append("屏幕(dp) sw widthDP=" + widthDP).append("\n").append("\n")
                //
                .append("--获取屏幕真实的宽高--").append("\n")
                .append("屏幕宽（像素，如：480px）: widthPx=" + width).append("\n")
                .append("屏幕高（像素，如：800px）：heightPx=" + height).append("\n")
                .append("虚拟键所占用的像素(dp) : heightDp=" + heightdp);
        textView.setText(sb.toString());
        Log.i(TAG, "screenActvity: "+sb.toString());

    }
}