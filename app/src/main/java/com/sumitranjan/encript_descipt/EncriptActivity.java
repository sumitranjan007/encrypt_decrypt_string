package com.sumitranjan.encript_descipt;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class EncriptActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText encrypt_edt;
    Button encrypt_submit_btn;
    TextView result_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encrypt_activity);
        //
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        //initialization
        result_text=findViewById(R.id.result_text);
        toolbar=findViewById(R.id.toolbarEncrypt);
        encrypt_edt=findViewById(R.id.encrypt_edt);
        encrypt_submit_btn=findViewById(R.id.encrypt_submit_btn);
        toolbar.setTitle(R.string.encrypt_toolbar);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v->{
                onBackPressed();
        });
        encrypt_submit_btn.setOnClickListener(v->{

                veryfyEdt();

        });
    }
     public  void veryfyEdt()  {
        if (encrypt_edt.getText().toString().isEmpty()){
            encrypt_edt.setFocusable(true);
            encrypt_edt.setError("Please Enter Some Text");
        }else{

            result_text.setText(new EncryptMethods().encryptString(encrypt_edt.getText().toString()));

        }
     }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backIntent=new Intent(EncriptActivity.this,MainActivity.class);
        backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(backIntent);
    }
}
