package com.example.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_POST4 extends AsyncTask<Void, Void, Void> {
    String duongdan=Bai4.SREVER_NAME;
    TextView tvResult;
    String stra,strb,strc;
    String str;
    ProgressDialog pDialog;
    Context context;


    public BackgroundTask_POST4(TextView tvResult, String stra, String strb, String strc, Context context) {

        this.tvResult = tvResult;
        this.stra = stra;
        this.strb = strb;
        this.strc = strc;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Calculating...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL(duongdan);
            String param = "a=" + URLEncoder.encode(this.stra, "utf-8")+"&b="+URLEncoder.encode(this.strb, "utf-8")+"&c="+URLEncoder.encode(this.strc, "utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter print = new PrintWriter(urlConnection.getOutputStream());
            print.print(param);
            print.close();

            String line = "";
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = bfr.readLine()) != null){
                sb.append(line);
            }
            str = sb.toString();
            urlConnection.disconnect();
        }catch (Exception ex){
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (pDialog.isShowing()){
            pDialog.dismiss();
        }
        tvResult.setText(str);
    }
}
