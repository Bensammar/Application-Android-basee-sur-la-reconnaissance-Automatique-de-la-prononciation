package com.example.acer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class startActivity extends Activity {

    static boolean langue =false;

    My_helper database=new My_helper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        Button b1 =(Button)findViewById(R.id.button2);
        Button b2 =(Button)findViewById(R.id.button3);
        TextView tv=(TextView)findViewById(R.id.TVSC);
/*if(MainActivity.y==true) {
    String sc = database.getImagescore("cat");
    tv.setText("" + sc);
}
*/


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(startActivity.this,choisir_niveaux_dif.class);
                langue=false;
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(startActivity.this,choisir_niveaux_dif.class);
                langue=true;
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(startActivity.this,login_activite.class);
        startActivity(i);
    }
}
