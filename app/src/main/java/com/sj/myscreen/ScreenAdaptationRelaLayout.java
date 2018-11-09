package com.sj.myscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/6/7.
 * 自定义控件 适配 测量屏幕宽高 根据获得系数，换算出来本机型对应的宽高，设置到子控件上去
 * 适用个别特殊的地方
 */

public class ScreenAdaptationRelaLayout extends ConstraintLayout {
    public ScreenAdaptationRelaLayout(Context context) {
        super(context);
    }

    public ScreenAdaptationRelaLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScreenAdaptationRelaLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    static boolean isFlag = true;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


        if(isFlag){
            int count = this.getChildCount();
            float scaleX =  UIUtils.getInstance(this.getContext()).getHorizontalScaleValue();
            float scaleY =  UIUtils.getInstance(this.getContext()).getVerticalScaleValue();

            Log.i("testbarry","x系数:"+scaleX);
            Log.i("testbarry","y系数:"+scaleY);
            for (int i = 0;i < count;i++){
                View child = this.getChildAt(i);

                //代表的是当前空间的所有属性列表
                LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
                layoutParams.width = (int) (layoutParams.width * scaleX);
                layoutParams.height = (int) (layoutParams.height * scaleY);
                layoutParams.rightMargin = (int) (layoutParams.rightMargin * scaleX);
                layoutParams.leftMargin = (int) (layoutParams.leftMargin * scaleX);
                layoutParams.topMargin = (int) (layoutParams.topMargin * scaleY);
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * scaleY);
            }
            isFlag = false;
        }



        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
