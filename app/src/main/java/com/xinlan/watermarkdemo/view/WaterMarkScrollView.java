package com.xinlan.watermarkdemo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.ScrollView;

import com.xinlan.watermarkdemo.WaterMarkProxy;

/**
 * Created by panyi on 2016/2/17.
 */
public class WaterMarkScrollView extends ScrollView {
    private WaterMarkProxy mWaterProxy = new WaterMarkProxy();

    public WaterMarkScrollView(Context context) {
        super(context);
        init();
    }

    public WaterMarkScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaterMarkScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WaterMarkScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mWaterProxy.initView(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mWaterProxy.waterMarkDraw(canvas, getScrollX()+getWidth(), getScrollY()+getHeight());
        super.onDraw(canvas);
    }


    public void setWaterMarkContent(String content) {
        mWaterProxy.setWaterMarkContent(content, this);
    }
}//end class
