package com.example.foodtrekker;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Spinner drop;
    String[] items={"Hubli","Bangalore","Hasan","Mangalore"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drop=(Spinner) findViewById(R.id.spinner_dropdown);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,items);
        drop.setAdapter(adapter);
    }
}