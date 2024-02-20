package com.example.youtube;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.inappmessaging.model.Button;

public class input extends AppCompatActivity {

    AppCompatButton appCompatButton;
    EditText editText;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        appCompatButton = findViewById(R.id.button);
        editText = findViewById(R.id.edittext);

        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(input.this, Output.class);

                String text = editText.getText().toString();

                intent.putExtra("key", text);



                startActivity(intent);
            }
        });




    }
}