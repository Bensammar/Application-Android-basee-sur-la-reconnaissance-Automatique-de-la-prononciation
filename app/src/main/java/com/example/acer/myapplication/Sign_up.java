package com.example.acer.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Sign_up extends Activity {
    TextView et1,et2,et3;
    EditText pass,login,pass_conf;
    Button ok,annuler;
    My_helper database;
    public static String nom,password;
    public static boolean x=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        pass=(EditText)findViewById(R.id.pass_insc);
        login=(EditText)findViewById(R.id.login_insc);
        pass_conf=(EditText)findViewById(R.id.pass_conf);
        ok=(Button)findViewById(R.id.ok);

        database = new My_helper(this);


        final String etV = "<font color=#39ac33> * </font>";

        final String etR = "<font color=#c93037> * </font>";

        et1=(TextView)findViewById(R.id.etoile1);
        et2=(TextView)findViewById(R.id.etoile2);
        et3=(TextView)findViewById(R.id.etoile3);


        if(!(login.getText().toString().equals(""))){
            et1.setText(Html.fromHtml(etV));
        }
        ok.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if(!(login.getText().toString().equals(""))&&(pass.getText().toString().equals(pass_conf.getText().toString()))&&!(pass.getText().toString().equals(""))&&!(pass_conf.getText().toString().equals(""))){
                    if(database.userExists(login.getText().toString(),pass.getText().toString())){
                        Toasty.error(getApplicationContext(), "User Exist", Toast.LENGTH_SHORT, true).show();
                    }else {

                        nom = login.getText().toString();
                        password = pass.getText().toString();
                        x = true;
//database.createuser(new user(login.getText().toString(),pass.getText().toString()),
                        et1.setText(Html.fromHtml(etV));
                        et2.setText(Html.fromHtml(etV));
                        et3.setText(Html.fromHtml(etV));


                        Toasty.success(getApplicationContext(), "Inscreption succes", Toast.LENGTH_SHORT, true).show();


                        Intent i = new Intent(Sign_up.this, login_activite.class);
                        startActivity(i);

                    }
                }else{
                    if((login.getText().toString().equals(""))){
                        et1.setText(Html.fromHtml(etR));
                        Toasty.error(getApplicationContext(), "Empty champs", Toast.LENGTH_SHORT, true).show();
                    }else if(!(pass.getText().toString().equals(pass_conf.getText().toString()))){
                        et3.setText(Html.fromHtml(etR));
                        Toasty.error(getApplicationContext(), "Password Confirmation error", Toast.LENGTH_SHORT, true).show();
                    }else if((pass.getText().toString().equals(""))){
                        et2.setText(Html.fromHtml(etR));
                        Toasty.error(getApplicationContext(), "Empty champs", Toast.LENGTH_SHORT, true).show();
                    }else if(pass_conf.getText().toString().equals("")){
                        et3.setText(Html.fromHtml(etR));
                        Toasty.error(getApplicationContext(), "Empty champs", Toast.LENGTH_SHORT, true).show();
                    }

                }
            }
        });



    }
}
