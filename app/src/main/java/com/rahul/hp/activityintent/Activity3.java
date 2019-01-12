package com.rahul.hp.activityintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
Button btnSubmit;
EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        btnSubmit=findViewById(R.id.btnSubmit);
        edtName=findViewById(R.id.edtName);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          String sname=edtName.getText().toString().trim();
          if(sname.isEmpty()){
              Toast.makeText(Activity3.this,"name field is empty",Toast.LENGTH_SHORT).show();
          }
          else
          {
              Intent intent=new Intent();
              intent.putExtra("surname",sname);
              setResult(RESULT_OK,intent);
              Activity3.this.finish();
          }
            }
        });
    }
}
