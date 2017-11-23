package com.zhangdong.zdbase.view.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.zhangdong.zdbase.R;
import com.zhangdong.zdbase.view.utils.DisplayUtils;

/**
 * use to 用于学习自定义view的操作
 * ------学的操作 HenCoder Android 开发进阶: 自定义 View 1-2 Paint 详解
 * <p>
 * Created by zhangdong on 2017/10/23.
 *
 * @version 1.0
 */

public class TestView extends View {

    private Paint mPaint;

    public TestView(Context context) {
        super(context);
        init();
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(10, 10, 50, 40, mPaint);

        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(DisplayUtils.dp2px(getContext(), 18));
        canvas.drawText("this is my view", 10, 70, mPaint);

        //线性着色器
        @SuppressLint("DrawAllocation") LinearGradient gradient =
                new LinearGradient(10,
                        150,
                        mPaint.measureText("this is my view"),
                        150,
                        Color.BLUE,
                        Color.RED,
                        Shader.TileMode.CLAMP);
        mPaint.setShader(gradient);
        canvas.drawText("this is my view", 10, 150, mPaint);

        //中心点放射渐变
        @SuppressLint("DrawAllocation") RadialGradient radialGradient = new RadialGradient(10 + mPaint.measureText("this is my view") / 2,
                200,
                mPaint.measureText("this is my view") / 2,
                Color.RED,
                Color.BLUE, Shader.TileMode.CLAMP);

        mPaint.setShader(radialGradient);
        canvas.drawText("this is my view", 10, 200, mPaint);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_pic);

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int cR = Math.min(width, height);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        mPaint.setShader(bitmapShader);
        canvas.drawCircle(cR, cR, cR, mPaint);
    }
}
