package com.example.acer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import es.dmoral.toasty.Toasty;

public class login_activite extends Activity {
    EditText user,pass;
    Button ok,creer;
    My_helper database =new My_helper(this);

    public static String nom;
    public static String password;
    RelativeLayout R1,R2,R3,R4;
    Animation uptodown,downtotop,righttoleft,lefttoright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activite);

        user=(EditText)findViewById(R.id.ETlogin);

        pass=(EditText)findViewById(R.id.ETpass);
        ok=(Button)findViewById(R.id.ok);
        creer=(Button)findViewById(R.id.creer_compte);

         R1=(RelativeLayout)findViewById(R.id.R1);
         R2=(RelativeLayout)findViewById(R.id.R2);
        R3=(RelativeLayout)findViewById(R.id.layoutuser);
        R4=(RelativeLayout)findViewById(R.id.layoutpass) ;


        uptodown= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.uptodown);
        downtotop=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtotop);
        righttoleft=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.righttoleft);
        lefttoright=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lefttoright);


        R1.setAnimation(uptodown);
        R2.setAnimation(downtotop);
        R3.setAnimation(righttoleft);
        R4.setAnimation(lefttoright);

        if(Sign_up.x==true){
            user.setText(""+Sign_up.nom);


            user.setEnabled(false);
            pass.setText(""+Sign_up.password);
            pass.setEnabled(false);
        }


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Sign_up.x==true) {
                    Intent i=new Intent(login_activite.this,startActivity.class);
                    nom=Sign_up.nom;
                    password=Sign_up.password;
                    startActivity(i);
                }else{  if(database.userExists(user.getText().toString(),pass.getText().toString())) {
                     nom=user.getText().toString();
                    password=pass.getText().toString();
                    ArrayList<String> user = database.getUserName(nom);
                    Log.d("Retrieved userfullname", user.toString());
                    Intent i=new Intent(login_activite.this,startActivity.class);
                startActivity(i);

                }else {
                    Toasty.error(getApplicationContext(),"User don't exists",Toast.LENGTH_SHORT,false).show();
                }
                }

            }
        });
        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(login_activite.this,Sign_up.class);
                startActivity(i);
            }
        });

    }




    @Override
    public void onBackPressed() {
finishAffinity();
    }
}
