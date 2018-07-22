package com.example.ayush.dbms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    String query;
    SQLiteDatabase database;
    String dbString;
    Cursor c;

    private static final Integer DATABASE_VERSION = 1 ;
    private static final String DATABASE_NAME = "products.db" ;
    private static final String TABLE_NAME = "LIBRARY";
    private static final String COLUMN_ROLL = "_ROLL";
    private static final String COLUMN_NAME = "_NAME";
    private static final String COLUMN_BOOK = "_BOOK";
    private static final String COLUMN_BOOKID = "_BOOKID";
    private static final String COLUMN_DOI = "_DOI";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        query = "CREATE TABLE " + TABLE_NAME + " ( " +
                COLUMN_ROLL + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_BOOK + " TEXT, " +
                COLUMN_BOOKID + " TEXT, " +
                COLUMN_DOI + " TEXT ) ;" ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

    public void SAVE(Products products)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROLL, products.get_roll());
        values.put(COLUMN_NAME, products.get_name());
        values.put(COLUMN_BOOK, products.get_book());
        values.put(COLUMN_BOOKID, products.get_bookID());
        values.put(COLUMN_DOI, products.get_DOI());

        database = getWritableDatabase();
        database.insert(TABLE_NAME , null, values);
        database.close();
    }

    public void del(String roll)
    {
        database = getWritableDatabase();
        database.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ROLL + " = \'" +  roll + "\' ;");
        database.close();
    }

    public String databaseToStringComp()
    {
        dbString = "";
        database = getWritableDatabase();
        query = "SELECT * FROM "+ TABLE_NAME + " WHERE 1=1 ;";

        c = database.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("_ROLL"))!=null)
            {
                dbString+="Student Name : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_NAME));
                dbString+="\nRoll No. : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_ROLL));
                dbString+="\nBook Name : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_BOOK));
                dbString+="\nBook ID : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_BOOKID));
                dbString+="\nDate of Issue :";
                dbString+=c.getString(c.getColumnIndex(COLUMN_DOI));
                dbString+="\n********************************\n\n";
                c.moveToNext();
            }
        }
        database.close();
        return dbString;
    }
}
