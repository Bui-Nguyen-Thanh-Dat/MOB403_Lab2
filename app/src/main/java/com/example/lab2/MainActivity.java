package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String SREVER_NAME = "http://10.24.19.128/api_android/index.php";
    private EditText edName, edScore;
    private Button btnSend;
    private TextView tvResult;
    String strName, strScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName = (EditText) findViewById(R.id.edName);
        edScore = (EditText) findViewById(R.id.edScore);
        btnSend = (Button) findViewById(R.id.btnSend);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        strName = edName.getText().toString();
        strScore = edScore.getText().toString();
        BackgroundTask_GET backgroundTaskGet = new BackgroundTask_GET(tvResult, strName,strScore,this);
        backgroundTaskGet.execute();
    }
}