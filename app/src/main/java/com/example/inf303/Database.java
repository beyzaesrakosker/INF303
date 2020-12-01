package com.example.inf303;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String TAG="Database";
    private static final String TABLE_NAME="kullaniciekle_tablosu";
    private static final String COL1="ID";
    private static final String COL2="NAME";
    private static final String COL3="SURNAME";
    private static final int veritabani_versiyon=1;




    public Database(Context context) {
        super(context,TABLE_NAME,null,veritabani_versiyon);
        Log.d("Hello1", "Fuck1");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table kullaniciekle_tablosu " +
                        "(id integer primary key autoincrement, NAME text,SURNAME text)"
        );

       Log.d("Hello", "Fuck");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(String name, String surname){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("SURNAME", surname);

        Log.d(TAG,"addData:Adding "+ name + surname +"to"+ TABLE_NAME);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_NAME;
        Cursor data=db.rawQuery(query,null);
        return data;
    }


}
