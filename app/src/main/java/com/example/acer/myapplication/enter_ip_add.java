package com.example.acer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class enter_ip_add extends Activity {

    static String adresse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_add_ip);
        final EditText t =(EditText)findViewById(R.id.editText);
        Button b =(Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"entre ip adresse of the server ",Toast.LENGTH_SHORT).show();
                else{
                adresse = t.getText().toString();
                Intent i=new Intent(enter_ip_add.this,MainActivitymultijoueur.class);
                startActivity(i);}

            }
        });
    }
}
