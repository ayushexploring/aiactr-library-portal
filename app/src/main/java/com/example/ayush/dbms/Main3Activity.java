package com.example.ayush.dbms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    Products p;
    DBHandler db ;
    EditText third;
    EditText fourth;
    EditText fifth;
    Button c;
    Intent i;
    String name;
    String rollNo;
    String bName;
    String bId;
    String DOI;

    public void onClick(View v)
    {
        bName = third.getText().toString();
        bId = fourth.getText().toString();
        DOI = fifth.getText().toString();

        //SAVE DATA
        p = new Products(rollNo , name, bName, bId, DOI);
        db = new DBHandler(this ,null,null,1);
        db.SAVE(p);

        //VIEW
        i=new Intent(this,ScrollingActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        third=findViewById(R.id.text6);
        fourth=findViewById(R.id.text4);
        fifth=findViewById(R.id.text5);
        c=findViewById(R.id.MyButton5);

        name = getIntent().getStringExtra("N");
        rollNo = getIntent().getStringExtra("R");
    }
}
