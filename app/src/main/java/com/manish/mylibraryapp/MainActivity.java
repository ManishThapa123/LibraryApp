package com.manish.mylibraryapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
private Button btnSeeAll, btnCurrentlyReading, btnWantToRead, btnAleadyRead, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.in,R.anim.out);

        initWidgets();
        setOnClickListeners();

    }

    private void initWidgets(){
        btnSeeAll =(Button)findViewById(R.id.btnAllBooks);
        btnCurrentlyReading =(Button)findViewById(R.id.btnCurrent);
        btnWantToRead =(Button)findViewById(R.id.btnWantTo);
        btnAleadyRead =(Button)findViewById(R.id.btnAlreadyRead);
        btnAbout =(Button)findViewById(R.id.btnAbout);

    }

    private void setOnClickListeners(){
        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
                
            }
        });

        btnAleadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlreadyReadActivity.class);
                startActivity(intent);
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToActivity.class);
                startActivity(intent);
            }
        });
        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutTapped();
            }
        });
    }

    private void aboutTapped(){
        Log.d(TAG, "aboutTapped: About Started");

        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("About My Library Application").setMessage("Building a website is, in many ways, an exercise of willpower. It’s tempting to get distracted by the bells and whistles of the design process, and forget all about creating compelling content.\n" +
                "\n" +
                "It's that compelling content that's crucial to making inbound marketing work for your business.").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(MainActivity.this,MyWebView.class);
            intent.putExtra("url","https://yts.lt/");
            startActivity(intent);


            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in,R.anim.close_out);
    }

}
