package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bai2 extends AppCompatActivity implements View.OnClickListener {
    public static final String SREVER_NAME = "http://10.24.19.128/api_android/rectangle_POST.php";
    private EditText edDai, edRong;
    private Button btnSend;
    private TextView tvResult;
    String strdai, strrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        edDai = (EditText) findViewById(R.id.edName);
        edRong = (EditText) findViewById(R.id.edScore);
        btnSend = (Button) findViewById(R.id.btnSend);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnSend){
            strdai = edDai.getText().toString();
            strrong = edRong.getText().toString();
            BackgroundTask_POST backgroundTaskPost = new BackgroundTask_POST(tvResult, strdai,strrong,this);
            backgroundTaskPost.execute();
        }

    }
}