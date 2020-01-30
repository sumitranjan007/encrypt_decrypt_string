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

public class DecryptActivity extends AppCompatActivity {
    Toolbar toolbarDecrypt;
    EditText decrypt_edt;
    Button decrypt_submit_btn;
    TextView result_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decryption_activity);
        //
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        //initialization
        toolbarDecrypt=findViewById(R.id.toolbarDecrypt);
        decrypt_edt=findViewById(R.id.decrypt_edt);
        decrypt_submit_btn=findViewById(R.id.decrypt_submit_btn);
        result_text=findViewById(R.id.result_text);
        //toolbar title
        toolbarDecrypt.setTitle(R.string.decrypt_toolbar);

        setSupportActionBar(toolbarDecrypt);
        toolbarDecrypt.setNavigationOnClickListener(v->{
            onBackPressed();
        });
        decrypt_submit_btn.setOnClickListener(v->{
            veryfyEdt();
        });
    }

    public  void veryfyEdt()  {
        if (decrypt_edt.getText().toString().isEmpty()){
            decrypt_edt.setFocusable(true);
            decrypt_edt.setError("Please Enter Some Text");
        }else{

            result_text.setText(new DecryptionMethod().decryptionString(decrypt_edt.getText().toString()));

        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backIntent=new Intent(DecryptActivity.this,MainActivity.class);
        backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(backIntent);
    }
}
