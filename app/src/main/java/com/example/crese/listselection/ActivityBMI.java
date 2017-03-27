package com.example.crese.listselection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class ActivityBMI extends AppCompatActivity {


    private EditText heightFt, heightIn, weight;
    private double BMI, hFt, hIn;
    private RadioButton radioButtonEng, radioButtonMet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Button buttonCalc = (Button) findViewById(R.id.buttonCalc);
        RadioGroup radioGroupUnits = (RadioGroup) findViewById(R.id.radioGroupUnits);
        heightFt = (EditText) findViewById(R.id.editTextHeightFt);
        heightIn = (EditText) findViewById(R.id.editTextHeightIn);
        weight = (EditText) findViewById(R.id.editTextWeight);
        radioButtonEng = (RadioButton) findViewById(R.id.radioButtonEng);
        radioButtonMet = (RadioButton) findViewById(R.id.radioButtonMet);

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (heightFt.getText().toString().trim().equals("") && heightFt.getText().toString().trim().equals("") && weight.getText().toString().trim().equals("")) {
                        Toast.makeText(ActivityBMI.this, "You did not enter a height or a weight", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (heightFt.getText().toString().trim().equals("") && heightIn.getText().toString().trim().equals("")) {
                        Toast.makeText(ActivityBMI.this, "You did not enter a height", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (heightFt.getText().toString().trim().equals("") && radioButtonMet.isChecked()) {
                        Toast.makeText(ActivityBMI.this, "You did not enter a height", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (weight.getText().toString().trim().equals("")) {
                        Toast.makeText(ActivityBMI.this, "You did not enter a weight", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        if (heightIn.getText().toString().trim().equals("")) {
                            hFt = Double.parseDouble(heightFt.getText().toString());
                            hIn = 0.0;
                        } else if (heightFt.getText().toString().trim().equals("")) {
                            hFt = 0.0;
                            hIn = Double.parseDouble(heightIn.getText().toString());
                        } else {
                            hFt = Double.parseDouble(heightFt.getText().toString());
                            hIn = Double.parseDouble(heightIn.getText().toString());
                        }
                    }
                    double h = (hFt * 12) + hIn;
                    double w = Double.parseDouble(weight.getText().toString());
                    if (radioButtonEng.isChecked()) {
                        BMI = (w * 703.0) / (h * h);
                    } else if (radioButtonMet.isChecked()) {
                        BMI = w / ((hFt / 100) * (hFt / 100));
                    }
                    Intent intent = new Intent(ActivityBMI.this, ActivityBMIResult.class);
                    intent.putExtra("BMI Value", BMI);
                    ActivityBMI.this.startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(ActivityBMI.this, "Please enter a valid height/weight", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroupUnits.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView HUnits = (TextView) findViewById(R.id.textViewHUnit);
                TextView WUnits = (TextView) findViewById(R.id.textViewWUnit);

                if(radioButtonEng.isChecked()){
                    HUnits.setText(R.string.ftin);
                    heightFt.setHint(R.string.ft);
                    heightIn.setHint(R.string.in);
                    WUnits.setText(R.string.lb);
                    weight.setHint(R.string.lb);
                    heightIn.setVisibility(View.VISIBLE);
                    heightFt.setEms(3);
                }
                if(radioButtonMet.isChecked()){
                    HUnits.setText(R.string.cm);
                    WUnits.setText(R.string.kg);
                    heightFt.setHint(R.string.cm);
                    weight.setHint(R.string.kg);
                    heightIn.setVisibility(View.GONE);
                    heightFt.setEms(6);
                }
            }
        });
    }
}
