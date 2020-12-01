package com.example.inf303;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
    private static final String TAG="ListDataActivity";
    Database v1;
    private ListView l1;
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.list_layout);
        l1=(ListView)findViewById(R.id.listView);
        v1=new Database(this);
        populateListView();

    }
    private void populateListView(){
        Log.d(TAG,"populateListView: Display data in the ListView");
        Cursor data=v1.getData();
        ArrayList<String> listData=new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1) + " " +  data.getString(2));


        }
        ListAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        l1.setAdapter(adapter);

    }

}
