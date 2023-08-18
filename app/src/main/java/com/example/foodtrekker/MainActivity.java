package com.example.foodtrekker;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Spinner drop;
    TextView info;
    String[] items={"Hubli","Bangalore","Hasan","Mangalore"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drop=(Spinner) findViewById(R.id.spinner_dropdown);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,items);
        drop.setAdapter(adapter);
        info=(TextView)findViewById(R.id.info);
        drop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem=items[i];
                Log.d("Dropdown","Selected item:"+selectedItem);
                info.setText("You have selected:"+selectedItem+" city");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("No DropDown","No item Selected");
            }
        });
    }
}