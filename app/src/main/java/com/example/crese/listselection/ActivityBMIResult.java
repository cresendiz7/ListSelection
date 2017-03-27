package com.example.crese.listselection;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Locale;

public class ActivityBMIResult extends AppCompatActivity {

    RelativeLayout ResultActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        TextView textViewBMIValue = (TextView) findViewById(R.id.textViewBMIValue);
        TextView textViewBMIResult = (TextView) findViewById(R.id.textViewResult);
        ResultActivity = (RelativeLayout) findViewById(R.id.activity_bmiresult);

        double BMIValue = getIntent().getExtras().getDouble("BMI Value");

        if(BMIValue > 99.99){
            BMIValue = 99.99;
        }
        textViewBMIValue.setText(String.format(Locale.ENGLISH, "%.2f", BMIValue));

        ImageView image = (ImageView) findViewById(R.id.imageViewResult);

        if(BMIValue < 18.5){
            textViewBMIResult.setText(R.string.underweight);
            textViewBMIResult.setTextColor(Color.BLUE);
            textViewBMIValue.setTextColor(Color.BLUE);
            image.setImageResource(R.drawable.bmiunder);
        }else if(BMIValue >= 18.5 && BMIValue <= 24.9){
            textViewBMIResult.setText(R.string.normal);
            textViewBMIResult.setTextColor(Color.GREEN);
            textViewBMIValue.setTextColor(Color.GREEN);
            image.setImageResource(R.drawable.bminormal);
        }else if(BMIValue > 24.9 && BMIValue <= 29.9) {
            textViewBMIResult.setText(R.string.overweight);
            textViewBMIResult.setTextColor(Color.YELLOW);
            textViewBMIValue.setTextColor(Color.YELLOW);
            image.setImageResource(R.drawable.bmiover);
        }else {
            textViewBMIResult.setText(R.string.obese);
            textViewBMIResult.setTextColor(Color.RED);
            textViewBMIValue.setTextColor(Color.RED);
            image.setImageResource(R.drawable.bmiobese);
        }
    }
}
