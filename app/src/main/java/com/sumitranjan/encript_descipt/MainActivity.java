package com.sumitranjan.encript_descipt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnEncrypt,btnDecrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        //Button's Initialization
        btnEncrypt=findViewById(R.id.btnEncrypt);
        btnDecrypt=findViewById(R.id.btnDecrypt);

        //Click Events
        //Encript Btn Click events
        btnEncrypt.setOnClickListener(v->{
            Intent encryptIntent=new Intent(MainActivity.this,EncriptActivity.class);
            encryptIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(encryptIntent);
        });
        //Decript Btn Click Events
        btnDecrypt.setOnClickListener(v->{
            Intent encryptIntent=new Intent(MainActivity.this,DecryptActivity.class);
            encryptIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(encryptIntent);
        });

    }
}
