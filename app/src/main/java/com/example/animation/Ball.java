package com.example.animation;

import android.view.View;

/**
 * Created by Danni on 2017/9/15.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Danni on 2017/7/6.
 */

public class Ball extends View {
    Paint mCirclePaint,mArcPaint,mTextPaint;
    float x,y,r,length,mShowSize;
    RectF rectF;
    String mShowText=0000+"%";
    public Ball(Context context) {
        this(context, null);
    }
    public Ball(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public Ball(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        mCirclePaint=new Paint();
        mCirclePaint.setColor(Color.RED);
        mCirclePaint.setStyle(Paint.Style.FILL);
    }
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(x,y,r,mCirclePaint);
    }

    @Override
    protected void onSizeChanged(int w,int h,int oldW,int oldH){
        super.onSizeChanged(w,h,oldW,oldH);
        length = w;
        x = length/2;
        y = length/8;
        r = (float) (length*0.5/8);
    }
    /*
    wrap-content时需要重写onMeasure
    */
    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        setMeasuredDimension(
                measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec)
        );
    }

    private int measureWidth(int measureSpec){
        int result=0;
        int Mode= View.MeasureSpec.getMode(measureSpec);
        int Size= View.MeasureSpec.getSize(measureSpec);   //自己考虑后的尺寸，若是wrap_content 那就是全屏
        //Size=1080  是像素

        if (Mode== View.MeasureSpec.EXACTLY){
            result=Size;
        }else {
            result=200;
            if (Mode== View.MeasureSpec.AT_MOST){
                result=Math.min(result,Size);

            }
        }
        Log.d("tag","widthsize is " + result);
        return result;
    }
    private int measureHeight(int measureSpec){
        int result=0;
        int Mode= View.MeasureSpec.getMode(measureSpec);
        int Size= View.MeasureSpec.getSize(measureSpec);


        if (Mode== View.MeasureSpec.EXACTLY){
            result=Size;
            Log.d("tag","size is " + result);
        }else {
            result=200;
            if (Mode== View.MeasureSpec.AT_MOST){
                result=Math.min(result,Size);

            }
        }
        /*Log.d("tag","heightsize is " + result);*/
        return result;
    }
}
