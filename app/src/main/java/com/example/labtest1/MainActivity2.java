package com.example.labtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
      //  int no = intent.getIntExtra("number",0);


        int age = intent.getIntExtra("leeyunkang",0);
        int age2 =  intent.getIntExtra("michelle",0);
        int age3 = age +age2;

        Toast.makeText(MainActivity2.this, Integer.toString(age3) , Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity2.this, age3, Toast.LENGTH_SHORT).show();

    }
}