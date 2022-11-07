package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class input_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        //get all elements by their id
        Button add_btn = findViewById(R.id.add_btn);
        EditText name = findViewById(R.id.name_area);
        EditText phone = findViewById(R.id.phone_no);

        add_btn.setOnClickListener(v -> {



            Intent intent = new Intent(input_data.this, MainActivity.class);
            intent.putExtra("phone", phone.getText().toString());
            intent.putExtra("name", name.getText().toString());

            setResult(2,intent);
            finish();


        });

    }
}