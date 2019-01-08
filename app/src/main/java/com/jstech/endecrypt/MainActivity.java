package com.jstech.endecrypt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jstech.endecrypt.util.EncryptDecryptHelper;
import com.jstech.endecrypt.view.DecryptionActivity;
import com.jstech.endecrypt.view.EncryptionActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonEncrypt;
    Button buttonDecrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonEncrypt = findViewById(R.id.btnEncrypt);
        buttonDecrypt = findViewById(R.id.btnDecrypt);
        buttonEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EncryptionActivity.class);
                startActivity(intent);
            }
        });
        buttonDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DecryptionActivity.class);
                startActivity(intent);
            }
        });
    }
}
