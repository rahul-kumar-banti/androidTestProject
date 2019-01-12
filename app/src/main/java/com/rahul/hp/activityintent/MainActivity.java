package com.rahul.hp.activityintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText edtName;
 Button btn1,btn2;
 TextView tvResult;
 int activity3Code=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edtName);
        btn1=findViewById(R.id.btnAct1);
        btn2=findViewById(R.id.btnAct2);
        tvResult=findViewById(R.id.tvResult);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.rahul.hp.activityintent.Activity3.class);
                startActivityForResult(intent,activity3Code);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Edn = edtName.getText().toString().trim();
                if (Edn.isEmpty()) {
                    Toast.makeText(MainActivity.this, "enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, com.rahul.hp.activityintent.Activity2.class);
                    intent.putExtra("inptname", Edn);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==activity3Code){
            if(resultCode==RESULT_OK){
                tvResult.setText(data.getStringExtra("surname"));
            }
            else if(resultCode==RESULT_CANCELED){
                tvResult.setText("canceled");

            }
            else
            {
                tvResult.setText("some thing waint wrong");
            }
            tvResult.setVisibility(View.VISIBLE);
        }
    }
}
