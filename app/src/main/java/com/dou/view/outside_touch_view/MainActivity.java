package com.dou.view.outside_touch_view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    OutSideTouchView outSideTouchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        outSideTouchView = findViewById(R.id.outside_touchview);
        OutSideTouchView outSideTouchView = new OutSideTouchView(this);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        lp.flags |= WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        lp.width = 800;
        lp.height = 800;

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.addView(outSideTouchView, lp);
    }

    /*@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Rect rect = new Rect();
        outSideTouchView.getGlobalVisibleRect(rect);

        if (!rect.contains(((int) ev.getRawX()), ((int) ev.getRawY()))) {
            Log.d("MainActivity", "dispatchTouchEvent: 点击外部");
        }

        return super.dispatchTouchEvent(ev);
    }*/
}
