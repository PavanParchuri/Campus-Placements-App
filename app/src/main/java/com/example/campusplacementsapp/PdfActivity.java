package com.example.campusplacementsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.common.util.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfActivity extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdfView = (PDFView)findViewById(R.id.pdfView);
        //This is function read PDF from Assets
        //pdfView.fromAsset("sample.pdf").load();

        //This is function read PDF from URL
        //new RetrievePDFStream().execute("http://ancestralauthor.com/download/sample.pdf"); // Or any url direct PDF from internet

        //This is function read PDF from bytes
        new RetrievePDFBytes().execute("https://www.freshersnow.com/wp-content/uploads/2018/02/TCS-Aptitude-Questions.pdf");
    }

    class RetrievePDFBytes extends AsyncTask<String,Void,byte[]>
    {

        @Override
        protected byte[] doInBackground(String... strings) {
            InputStream inputStream = null;
            try{
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode() == 200)
                {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            catch (IOException e)
            {
                return null;
            }
            try {
                return IOUtils.toByteArray(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            pdfView.fromBytes(bytes).load();
        }
    }
}
