package com.example.tutorialapp;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) this.findViewById(R.id.button_id);
        final EditText groesse = (EditText) this.findViewById(R.id.nu_groesse_id);
        final EditText gewicht = (EditText) this.findViewById(R.id.nu_gewicht_id);

        final TextView out = (TextView) this.findViewById(R.id.out_id);
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        double bmi = Double.parseDouble(gewicht.getText().toString());
                        bmi /= (Double.parseDouble(groesse.getText().toString())/100);
                        bmi /= (Double.parseDouble(groesse.getText().toString())/100);

                        out.setText(((Double) bmi).toString());
                    }
                }
        );
    }
}
