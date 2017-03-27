package com.example.crese.listselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class ActivityGuess extends AppCompatActivity {

    private EditText input;
    private TextView feedback, tries;
    private ImageView image, image2, image3;
    private int answer, count;
    private Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        input = (EditText) findViewById(R.id.editTextGuess);
        Button guess = (Button) findViewById(R.id.button);
        Button tryAgain = (Button) findViewById(R.id.tryAgain);
        feedback = (TextView) findViewById(R.id.textView2);
        tries = (TextView) findViewById(R.id.tries);
        image = (ImageView) findViewById(R.id.imageView);
        image2 = (ImageView) findViewById(R.id.imageView2);
        image3 = (ImageView) findViewById(R.id.imageView3);
        answer = r.nextInt(10) + 1;
        feedback.setText("");
        image.setImageResource(android.R.color.transparent);
        image2.setImageResource(android.R.color.transparent);
        image3.setImageResource(android.R.color.transparent);
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(android.R.color.transparent);
                tries.setText("");
                try {
                    if (Integer.parseInt(input.getText().toString()) > 10 || Integer.parseInt(input.getText().toString()) < 1 || input.getText().toString().equals("")) {
                        Toast.makeText(ActivityGuess.this, "Please enter a number 1 - 10", Toast.LENGTH_SHORT).show();
                    } else {
                        if (Integer.parseInt(input.getText().toString()) > answer) {
                            feedback.setText(R.string.lower);
                            feedback.setTextSize(25);
                            image2.setImageResource(R.drawable.down);
                            image3.setImageResource(R.drawable.down);
                            count++;
                        } else if (Integer.parseInt(input.getText().toString()) < answer) {
                            feedback.setText(R.string.higher);
                            feedback.setTextSize(25);
                            image2.setImageResource(R.drawable.up);
                            image3.setImageResource(R.drawable.up);
                            count++;
                        } else {
                            count++;
                            feedback.setText(R.string.correct);
                            if(count == 1)
                                tries.setText("\nThat took you " + count + " try!");
                            else
                                tries.setText("\nThat took you " + count + " tries.");
                            feedback.setTextSize(25);
                            image2.setImageResource(android.R.color.transparent);
                            image3.setImageResource(android.R.color.transparent);
                            image.setImageResource(R.drawable.checkmark);
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(ActivityGuess.this, "Please enter a number 1 - 10", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = r.nextInt(10) + 1;
                feedback.setText("");
                tries.setText("");
                feedback.setTextSize(18);
                input.setText("");
                image.setImageResource(android.R.color.transparent);
                image2.setImageResource(android.R.color.transparent);
                image3.setImageResource(android.R.color.transparent);
                count = 0;
            }
        });
    }
}