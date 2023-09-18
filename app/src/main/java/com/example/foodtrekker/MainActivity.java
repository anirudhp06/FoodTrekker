package com.example.foodtrekker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Spinner drop;
    TextView info;
    String[] items={"Choose","Hubli","Bangalore","Hasan"};
    ImageView img1,img2,img3;
    TextView hotel1,hotel2,hotel3;
    EditText hotel1_details,hotel2_details,hotel3_details;
    Button call1,call2,call3;
    Button map1,map2,map3;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drop=(Spinner) findViewById(R.id.spinner_dropdown);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,items);
        drop.setAdapter(adapter);
        info=(TextView)findViewById(R.id.info);

        hotel1=(TextView) findViewById(R.id.h1);
        hotel2=(TextView) findViewById(R.id.h2);
        hotel3=(TextView) findViewById(R.id.h3);

        hotel1_details=(EditText) findViewById(R.id.h1_details);
        hotel2_details=(EditText) findViewById(R.id.h2_details);
        hotel3_details=(EditText) findViewById(R.id.h3_details);

        call1=(Button) findViewById(R.id.call1);
        call2=(Button) findViewById(R.id.call2);
        call3=(Button) findViewById(R.id.call3);

        map1=(Button) findViewById(R.id.map1);
        map2=(Button) findViewById(R.id.map2);
        map3=(Button) findViewById(R.id.map3);

        img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);
        img3=(ImageView) findViewById(R.id.img3);

        invisible();

        drop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem=items[i];
                Log.d("Dropdown","Selected item:"+selectedItem);
                if(selectedItem!="Choose") {
                    info.setText("Hotels registered with us in " + selectedItem + " are:");
                    switch(selectedItem){
                        case "Hubli":
                            hubli();
                            break;
                        case "Bangalore":
                            bangalore();
                            break;
                        case "Hasan":
                            hasan();
                            break;
                        default:
                            Toast.makeText(MainActivity.this,"Invalid Option",Toast.LENGTH_LONG).show();
                            break;
                    }
                }
                else {
                    info.setText("");
                    invisible();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("No DropDown","No item Selected");
            }
        });
    }
    public void hubli(){
        img1.setImageResource(R.drawable.ganesh_ubl);
        hotel1.setText("Hotel Shree Ganesh");
        hotel1_details.setText("Hotel located in hubli famous for its Idli & Vada.");
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("1234567890");
            }
        });

        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map("15.35523529882348,75.1413573652321");
            }
        });

        img2.setImageResource(R.drawable.denissons_ubl);
        hotel2.setText("Denissons Hotel");
        hotel2_details.setText("5* hotel located in gokul road provides exquisite cuisines.");
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("0987654321");
            }
        });
        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map("15.349182846683652,75.11276123792824");
            }
        });

        img3.setImageResource(R.drawable.president_ubl);
        hotel3.setText("President Hotel");
        hotel3_details.setText("3* hotel in Hubli offering both North and South Indian food");
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("7854965123");
            }
        });

        map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map("15.382082664586198,75.11360756676474");
            }
        });
        visible();
    }

    public void bangalore(){}

    public void hasan(){}
    public void invisible(){
        hotel1.setVisibility(View.INVISIBLE);
        hotel2.setVisibility(View.INVISIBLE);
        hotel3.setVisibility(View.INVISIBLE);

        hotel1_details.setVisibility(View.INVISIBLE);
        hotel2_details.setVisibility(View.INVISIBLE);
        hotel3_details.setVisibility(View.INVISIBLE);

        call1.setVisibility(View.INVISIBLE);
        call2.setVisibility(View.INVISIBLE);
        call3.setVisibility(View.INVISIBLE);

        map1.setVisibility(View.INVISIBLE);
        map2.setVisibility(View.INVISIBLE);
        map3.setVisibility(View.INVISIBLE);

        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
    }

    public void visible(){
        hotel1.setVisibility(View.VISIBLE);
        hotel2.setVisibility(View.VISIBLE);
        hotel3.setVisibility(View.VISIBLE);

        hotel1_details.setVisibility(View.VISIBLE);
        hotel2_details.setVisibility(View.VISIBLE);
        hotel3_details.setVisibility(View.VISIBLE);

        call1.setVisibility(View.VISIBLE);
        call2.setVisibility(View.VISIBLE);
        call3.setVisibility(View.VISIBLE);

        map1.setVisibility(View.VISIBLE);
        map2.setVisibility(View.VISIBLE);
        map3.setVisibility(View.VISIBLE);

        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.VISIBLE);
        img3.setVisibility(View.VISIBLE);
    }

    public void call(String number){
        Uri uri=Uri.parse("tel:"+number);
        Intent call=new Intent(Intent.ACTION_DIAL,uri);
        try{
            startActivity(call);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void map(String geoLocation){
        Uri location=Uri.parse("geo:"+geoLocation+"?z=15");
        Intent openMap=new Intent(Intent.ACTION_VIEW,location);
        openMap.setPackage("com.google.android.apps.maps");
        try{
            startActivity(openMap);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}