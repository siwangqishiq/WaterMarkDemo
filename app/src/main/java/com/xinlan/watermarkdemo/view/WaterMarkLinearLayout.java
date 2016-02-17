package com.xinlan.watermarkdemo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.xinlan.watermarkdemo.WaterMarkProxy;

/**
 * Created by panyi on 2016/2/17.
 */
public class WaterMarkLinearLayout extends LinearLayout {
    private WaterMarkProxy mWaterProxy = new WaterMarkProxy();

    public WaterMarkLinearLayout(Context context) {
        super(context);
        init();
    }

    public WaterMarkLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaterMarkLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WaterMarkLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mWaterProxy.initView(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mWaterProxy.waterMarkDraw(canvas, getWidth(), getHeight());
        super.onDraw(canvas);
    }


    public void setWaterMarkContent(String content) {
        mWaterProxy.setWaterMarkContent(content, this);
    }
}//end class
