package com.example.acer.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainLogin extends AppCompatActivity {

    static String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        final EditText name =(EditText)findViewById(R.id.ETuser);
        EditText pass =(EditText)findViewById(R.id.ETPassword);
        Button blogin =(Button)findViewById(R.id.Blogin);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = name.getText().toString();
                Intent i=new Intent(MainLogin.this,MainActivitymultijoueur.class);
                startActivity(i);
            }
        });
    }
}
