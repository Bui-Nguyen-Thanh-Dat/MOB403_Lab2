package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4 extends AppCompatActivity implements View.OnClickListener{
    public static final String SREVER_NAME = "http://10.24.19.128/api_android/giaiphuongtrinh.php";
    private EditText eda,edb,edc;
    private Button btnSend;
    private TextView tvResult;
    String stra,strb,strc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        eda=findViewById(R.id.eda);
        edb=findViewById(R.id.edb);
        edc=findViewById(R.id.edc);
        btnSend=findViewById(R.id.btnSend);
        tvResult=findViewById(R.id.tvResult);


        btnSend.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnSend){
            stra = eda.getText().toString();
            strb = edb.getText().toString();
            strc = edc.getText().toString();

            BackgroundTask_POST4 backgroundTaskPost = new BackgroundTask_POST4(tvResult,stra,strb,strc,this);
            backgroundTaskPost.execute();
        }
    }
}