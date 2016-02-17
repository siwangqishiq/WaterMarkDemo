package com.xinlan.watermarkdemo;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by panyi on 2016/2/17.
 */
public interface IWaterMark {
    /**
     * 水印控件初始化操作
     * @param parentView
     */
    void initView(ViewGroup parentView);

    /**
     * 绘制水印操作
     * @param canvas
     */
    void waterMarkDraw(Canvas canvas,int viewWidth,int viewHeight);

    /**
     * 设置水印文字内容
     *
     * @param content
     */
    void setWaterMarkContent(String content,View parentView);
}
