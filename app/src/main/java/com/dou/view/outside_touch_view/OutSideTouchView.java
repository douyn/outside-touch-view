package com.dou.view.outside_touch_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Author: dou
 * Time: 18-9-15  上午10:57
 * Decription:
 */

public class OutSideTouchView extends View {

    Paint paint = new Paint();

    Context mContext;

    public OutSideTouchView(Context context) {
        super(context);
        init(context);
    }

    public OutSideTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
    }

    public OutSideTouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_OUTSIDE:
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw: ");
        super.onDraw(canvas);

        canvas.drawColor(Color.YELLOW);

        paint.setColor(Color.BLACK);
        paint.setTextSize(24);
        canvas.drawText("Hello World!", 100, 100, paint);
    }

    private static final String TAG = OutSideTouchView.class.getSimpleName();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent: DOWN");
                requestFocus();
                break;

            case MotionEvent.ACTION_OUTSIDE:
                Log.d(TAG, "onTouchEvent: OUTSIDE");
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }
}
