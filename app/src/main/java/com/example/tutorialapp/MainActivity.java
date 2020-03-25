package com.example.tutorialapp;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.MotionEventCompat;


public class MainActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) this.findViewById(R.id.text_id);
        txt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);

                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        txt.setText("Pressed the TXT");
                    case (MotionEvent.ACTION_MOVE):
                        txt.setText("I got to");
                }
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                txt.setText("Pressed");
                return true;
            case (MotionEvent.ACTION_MOVE):
                txt.setText("Move It Move It");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}
