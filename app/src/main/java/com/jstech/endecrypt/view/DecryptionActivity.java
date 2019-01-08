package com.jstech.endecrypt.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jstech.endecrypt.MainActivity;
import com.jstech.endecrypt.R;
import com.jstech.endecrypt.util.EncryptDecryptHelper;

public class DecryptionActivity extends AppCompatActivity {

    EditText eTxtEncryptedString;
    Button btnSubmit;
    TextView textViewString;
    String str = "";
    EncryptDecryptHelper edo;
    String encryptedStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);
        setTitle("Decrypt");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        eTxtEncryptedString = findViewById(R.id.editTextEncryptedString);
        btnSubmit = findViewById(R.id.btnDSubmit);
        textViewString = findViewById(R.id.textViewDecryptedString);
        edo = new EncryptDecryptHelper();
        try{
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    encryptedStr = eTxtEncryptedString.getText().toString();
                    if(encryptedStr.trim().isEmpty()){
                        eTxtEncryptedString.setError("This field must not be empty!");
                    }else {
                        str = edo.decrypt(encryptedStr);
                    }
                    textViewString.setText(str);
                }
            });
        }catch (Exception e){
            Toast.makeText(this,"Please enter String as per the format", Toast.LENGTH_LONG).show();
        }
        eTxtEncryptedString.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewString.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {
            startActivity(new Intent(DecryptionActivity.this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}