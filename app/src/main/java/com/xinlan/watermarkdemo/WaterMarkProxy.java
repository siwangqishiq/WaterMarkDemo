package com.xinlan.watermarkdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

/**
 * 水印处理 代理类
 * 用于嵌入ViewGroup中  完成水印处理的任务
 * Created by panyi on 2016/2/17.
 */
public class WaterMarkProxy implements IWaterMark{
    public static int PAD = 300;
    public static int TEXT_PAD = 80;
    private String mMarkContent = "你好 世界";
    private Paint mTextPaint;

    @Override
    public void initView(ViewGroup parentView) {
        parentView.setWillNotDraw(false);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.GRAY);
        mTextPaint.setAlpha(100);
        mTextPaint.setTextSize(45);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void waterMarkDraw(Canvas canvas, int viewWidth, int viewHeight) {
        if(TextUtils.isEmpty(mMarkContent))
            return;

        int w = viewWidth;
        int h = viewHeight;
        float textWidth = mTextPaint.measureText(mMarkContent);
        for (int i = 0; i < h; i += PAD) {
            for (int j = 0; j < w +TEXT_PAD; j += (TEXT_PAD + textWidth)) {
                canvas.save();
                canvas.rotate(30,j,i);
                canvas.drawText(mMarkContent, j, i, mTextPaint);
                canvas.restore();
            }//end for j
        }//end for i
    }

    @Override
    public void setWaterMarkContent(String content,View parentView) {
        this.mMarkContent = content;
        parentView.postInvalidate();
    }
}//end class
