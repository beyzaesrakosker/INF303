package com.example.inf303;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static String TAG="MainActivity";
    Database v1;
    ListDataActivity v2;
    private Button kayit,goster;




    private EditText ad,soyad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ad = (EditText) findViewById(R.id.ad);
        soyad = (EditText) findViewById(R.id.soyad);

        kayit = (Button) findViewById(R.id.kayit);
        goster = (Button) findViewById(R.id.goster);

        v1 = new Database(this);
        v2=new ListDataActivity();


        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = ad.getText().toString();
                String b = soyad.getText().toString();
                if (a.length() != 0 || b.length() != 0) {
                    AddData(a, b);
                    ad.setText("");
                    soyad.setText("");
                    Toast.makeText(getApplicationContext(),"kayıt",Toast.LENGTH_LONG).show();
                    return;

                } else {
                    //toastMessage("You must put something");
                    Toast.makeText(getApplicationContext(), "başarısız", Toast.LENGTH_LONG).show();
                    toastMessage("You must put something");
                    return;

                }


            }
        });
        goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                startActivity(intent);

            }
        });



    }
     public void
     AddData(String a,String b){
        boolean insertData=v1.addData(a, b);

        if(insertData){

            toastMessage("Data Successfully Inserted");
        }

        else{

            toastMessage("something went wrong");
        }
     }

    private void toastMessage(String data_successfully_inserted) {
    }

}