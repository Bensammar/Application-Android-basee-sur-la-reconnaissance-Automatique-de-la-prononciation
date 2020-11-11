package com.example.acer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choisir_niveaux_dif extends Activity {

    public Button easy,moyen,hard;
    static int niveaudif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_niveaux_dif);
        easy =(Button)findViewById(R.id.facile);
        moyen=(Button)findViewById(R.id.moyen);
        hard=(Button)findViewById(R.id.dificile);

        if(startActivity.langue==false){
            easy.setText("Easy");
            moyen.setText("Medium");
            hard.setText("Hard");
        }

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(choisir_niveaux_dif.this,Slide_for_tuto.class);
                niveaudif=0;
                startActivity(i);

            }
        });
        moyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(choisir_niveaux_dif.this,Slide_for_tuto.class);
                niveaudif=1;
                startActivity(i);

            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(choisir_niveaux_dif.this,Slide_for_tuto.class);
                niveaudif=2;
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(),startActivity.class);
        startActivity(i);
    }
}
