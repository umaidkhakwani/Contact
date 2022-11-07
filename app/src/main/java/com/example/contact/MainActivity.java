package com.example.contact;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    protected void createRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecylerContactAdapter adapter = new RecylerContactAdapter(this,arraycontacts);
        recyclerView.setAdapter(adapter);
    }

    ArrayList<contact_model> arraycontacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arraycontacts.add(new contact_model(R.drawable.ic_launcher_background, "Umaid", "666"));
        createRecyclerView();
        Button add_contact = findViewById(R.id.add_contact);

        add_contact.setOnClickListener(v -> {
            Intent intent = new Intent(this, input_data.class);
            startActivityForResult(intent, 2);
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode==2){
            String name=intent.getStringExtra("name");
            String number=intent.getStringExtra("phone");
            contact_model contact = new contact_model(R.drawable.ic_launcher_background, name, number);
            arraycontacts.add(contact);
            createRecyclerView();
        }
    }
}