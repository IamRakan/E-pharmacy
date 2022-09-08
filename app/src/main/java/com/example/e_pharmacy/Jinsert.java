package com.example.e_pharmacy;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

import java.time.Instant;
import java.util.Random;

public class Jinsert extends AppCompatActivity {
    String[] names = {"AL Yamamah Hospital", "King Faisal Specialist Hospital", "King Salman Hospital", "Prince Mohammed Bin Abdulaziz Hospital", "Prince Sultan Military Medical City"};


    public Button goback;
    public Database MyDB;
    public Button Insert;
    public EditText id;
    public EditText name;
    public EditText phone;
    public EditText MedicineName;

    ArrayAdapter<String> adapter;
    Spinner Spinner2;

    String Hospital= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xinsert);




        id = (EditText)findViewById(R.id.tex1);
        name = (EditText)findViewById(R.id.tex2);
        phone= (EditText)findViewById(R.id.editTextPhone);
        MedicineName= (EditText)findViewById(R.id.tex3);
        goback = (Button) findViewById(R.id.GoBackBu);
        MyDB = new Database(this);
        Insert = (Button)findViewById(R.id.InsertButOrder);
        Spinner2 = (Spinner) findViewById(R.id.spinner1);


        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, names);

        Spinner2.setAdapter(adapter);


        Spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 0:
                        Hospital= "AL Yamamah Hospital";

                        break;
                    case 1:

                        Hospital= "King Faisal Specialist Hospital";

                        break;
                    case 2:

                        Hospital= "King Salman Hospital";

                        break;
                    case 3:

                        Hospital= "Prince Mohammed Bin Abdulaziz Hospital";

                        break;
                    case 4:
                        Hospital= "Prince Sultan Military Medical City";

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }



        });





        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jinsert.this , Jhomepage.class);
                startActivity(intent);
            }
        });

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jinsert.this, Jview.class);
                Random random = new Random();
                String id1 = id.getText().toString();
                String name1 = name.getText().toString();
                String MedicineName1 = MedicineName.getText().toString();
                String phone1 = phone.getText().toString();
                int OrderCode = random.nextInt(100000);

                String Hospital1 = Hospital;


               Boolean addinfo = MyDB.insert(id1 , name1 , MedicineName1 ,phone1, Hospital1 ,OrderCode);



                if(addinfo == true) {
                    Toast.makeText(Jinsert.this, "Data has been added", Toast.LENGTH_LONG).show();

                }
                else {

                    Toast.makeText(Jinsert.this, "Error", Toast.LENGTH_LONG).show();


                }
                startActivity(intent);
            }

        });

    }



}

