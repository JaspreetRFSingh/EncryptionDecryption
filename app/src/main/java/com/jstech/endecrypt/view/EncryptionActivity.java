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

public class EncryptionActivity extends AppCompatActivity {

    EditText eTxtString;
    Button btnSubmit;
    TextView textViewEncryptedString;
    String str = "";
    EncryptDecryptHelper edo;
    String encryptedStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
        setTitle("Encrypt");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        eTxtString = findViewById(R.id.editTextString);
        btnSubmit = findViewById(R.id.btnESubmit);
        textViewEncryptedString = findViewById(R.id.textViewEncryptedString);
        edo = new EncryptDecryptHelper();
        try{
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str = eTxtString.getText().toString();
                    if(str.trim().isEmpty()){
                        eTxtString.setError("This field must not be empty!");
                    }
                    else{
                        encryptedStr = edo.encrypt(str);
                    }
                    textViewEncryptedString.setText(encryptedStr);
                }
            });
        }catch (Exception e){
            Toast.makeText(this,"Please enter String as per the format", Toast.LENGTH_LONG).show();
        }

        eTxtString.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewEncryptedString.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {
            startActivity(new Intent(EncryptionActivity.this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
