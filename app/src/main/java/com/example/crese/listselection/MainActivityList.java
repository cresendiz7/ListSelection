package com.example.crese.listselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivityList extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        listView = (ListView) findViewById(R.id.listView);

        String[] values = new String[]
                { "BMI Calculator",
                  "Tip Calculator",
                  "Guessing Game"
                };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent0 = new Intent(getApplicationContext(),ActivityBMI.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(),ActivityTip.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(),ActivityGuess.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

    }
}
