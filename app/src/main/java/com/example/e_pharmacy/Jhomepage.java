package com.example.e_pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class Jhomepage extends AppCompatActivity {



    public Button orderdata;
    public Button viewdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xhomepage);
        orderdata = (Button) findViewById(R.id.Order);
        viewdata = (Button) findViewById(R.id.viewdata);

        orderdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jhomepage.this , Jinsert.class);
                startActivity(intent);
            }
        });
        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jhomepage.this , Jview.class);
                startActivity(intent);
            }
        });
    }




}


