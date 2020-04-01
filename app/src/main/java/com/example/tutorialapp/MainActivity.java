package com.example.tutorialapp;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    TextView txt;
    private GestureDetectorCompat compat;
    private VelocityTracker vt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) this.findViewById(R.id.text_id);
        this.compat = new GestureDetectorCompat(this, this);
        compat.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if(vt==null) {
                    vt = VelocityTracker.obtain();
                } else {
                    vt.clear();
                }
                vt.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                vt.addMovement(event);
                vt.computeCurrentVelocity(1000);
                txt.setText(" X Velo = " + VelocityTrackerCompat.getXVelocity(vt, event.getPointerId((event.getActionIndex()))));
                txt.append("\nY Velo = " + VelocityTrackerCompat.getYVelocity(vt, event.getPointerId((event.getActionIndex()))));
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                vt.recycle();
                vt = null;
                break;
        }
        return true;
        //this.compat.onTouchEvent(event);
        //return super.onTouchEvent(event);
    }

    //Gesten//
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        txt.setText("onSingleTapConfirmed");
        //txt.setText(e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        txt.setText("onDoubleTap");
        //txt.setText(e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        txt.setText("onDoubleTapEvent");
        //txt.setText(e.toString());
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        txt.setText("onDown");
        //txt.setText(e.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        txt.setText("onShowPress");
        //txt.setText(e.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        txt.setText("onSingleTapUp");
        //txt.setText(e.toString());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        txt.setText("onScroll");
        //txt.setText(e1.toString() + "\n" + e2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        txt.setText("onLongPress");
        //txt.setText(e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        txt.setText("onFling");
        //txt.setText(e1.toString() + "\n" + e2.toString());
        return true;
    }
}
