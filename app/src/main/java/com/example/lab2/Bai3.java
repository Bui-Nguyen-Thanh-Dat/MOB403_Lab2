package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai3 extends AppCompatActivity implements View.OnClickListener{
    public static final String SREVER_NAME = "http://10.24.19.128/api_android/thetich.php";
    private EditText edcanh;
    private Button btnSend;
    private TextView tvResult;
    String strcanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        edcanh=findViewById(R.id.edCanh);
        btnSend=findViewById(R.id.btnSend);
        tvResult=findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnSend){
            strcanh = edcanh.getText().toString();

            BackgroundTask_POST3 backgroundTaskPost = new BackgroundTask_POST3(tvResult,strcanh,this);
            backgroundTaskPost.execute();
        }
    }
}