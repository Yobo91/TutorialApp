package com.example.tutorialapp;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) this.findViewById(R.id.button_id);

        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        button.setText("You did it!!!");
                    }
                }
        );
    }
}
