package com.example.e_pharmacy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class Jview extends AppCompatActivity {



    public Button homepage;
    public Button Order;
    ListView mListView;
    public Database myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xview);
        homepage = (Button) findViewById(R.id.toHomePage);
        Order = (Button) findViewById(R.id.toOrder);
        mListView = (ListView) findViewById(R.id.listView);
        myDB = new Database(this);
        populateListView();

        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jview.this , Jhomepage.class);
                startActivity(intent);
            }
        });
        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jview.this , Jinsert.class);
                startActivity(intent);
            }
        });
    }

    public void populateListView() {
        Cursor data = myDB.retrieve();
        ArrayList<String> listData = new ArrayList<>();

        while (data.moveToNext()){
            listData.add("ID:"+data.getString(0)+ "\nName: "+data.getString(1)+"\nMedicine: "+data.getString(2)+"\nphone: "+ data.getString(3)+"\nHospital: "+data.getString(4)+"\nOrderCode: "+ data.getString(5));

        }
        ListAdapter adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }
}

