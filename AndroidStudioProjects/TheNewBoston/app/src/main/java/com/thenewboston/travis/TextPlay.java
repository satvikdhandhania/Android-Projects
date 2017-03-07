package com.thenewboston.travis;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by satvik on 18/6/15.
 */
public class TextPlay extends Activity implements View.OnClickListener {
    Button chkCmd;
    ToggleButton passTog;
    EditText input;
    TextView display;

    private void baconAndEggs() {
        chkCmd = (Button) findViewById(R.id.bResults);
        passTog = (ToggleButton) findViewById(R.id.tbPassword);
        input = (EditText) findViewById(R.id.etCommands);
        display = (TextView) findViewById(R.id.tvResults);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        baconAndEggs();
        passTog.setOnClickListener(this);
        chkCmd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bResults:
                String check = input.getText().toString();
                display.setText(check);
                if (check.contentEquals("left")) {
                    display.setGravity(Gravity.LEFT);
                } else if (check.contentEquals("center")) {
                    display.setGravity(Gravity.CENTER);
                } else if (check.contentEquals("right")) {
                    display.setGravity(Gravity.RIGHT);
                } else if (check.contentEquals("blue")) {
                    display.setTextColor(Color.BLUE);
                } else if (check.contentEquals("WTF")) {
                    Random crazy = new Random();
                    display.setText("WTF!!!");
                    display.setTextSize(crazy.nextInt(75));
                    display.setTextColor(Color.rgb(crazy.nextInt(255), crazy.nextInt(255), crazy.nextInt(255)));
                    switch (crazy.nextInt(3)) {
                        case 0:
                            display.setGravity(Gravity.LEFT);
                            break;
                        case 1:
                            display.setGravity(Gravity.CENTER);
                            break;
                        case 2:
                            display.setGravity(Gravity.RIGHT);
                            break;
                    }
                } else {
                    display.setText("invalid");
                    display.setGravity(Gravity.CENTER);
                    display.setTextColor(Color.WHITE);
                }


                break;
            case R.id.tbPassword:
                if (passTog.isChecked()) {
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                break;
        }
    }
}
