package com.example.ayush.dbms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText first;
    DBHandler db;
    EditText second;
    Button a;
    Button b;
    Button c;
    Intent i;
    Intent j;
    String Name;
    String Roll;

    public void onClick1(View v)
    {
        Name = first.getText().toString();
        Roll = second.getText().toString();
        i=new Intent(this, Main3Activity.class);
        i.putExtra("N",Name);
        i.putExtra("R",Roll);
        startActivity(i);
    }
    public void onClick2(View v)
    {
        j=new Intent(this, ScrollingActivity.class);
        startActivity(j);
    }

    public void onClick3(View v)
    {
        // delete
        Roll = second.getText().toString();
        db = new DBHandler(this,null,null,1);
        db.del(Roll);
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        first=findViewById(R.id.text1);
        second=findViewById(R.id.text2);
        a=findViewById(R.id.MyButton2);
        b=findViewById(R.id.MyButton3);
        c=findViewById(R.id.MyButton4);
    }
}
