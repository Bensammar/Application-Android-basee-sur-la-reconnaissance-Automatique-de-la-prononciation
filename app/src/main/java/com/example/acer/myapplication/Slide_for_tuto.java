package com.example.acer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Slide_for_tuto extends Activity {

    public static ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView ndot[];
    private  slideAdapter_for_tuto aslideAdapter;
    private Button b10;
    public static String dede;
    public  static String dede2;
    public static String dede3;
    public static String dede4;
    public static String dede5;

    static My_helper database;

    Button skip,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_for_tuto);
        database=new My_helper(this);
        viewPager=(ViewPager)findViewById(R.id.viewslide);
        linearLayout=(LinearLayout)findViewById(R.id.docts);
        aslideAdapter = new slideAdapter_for_tuto(this);


        skip=(Button)findViewById(R.id.skipslide);



        viewPager.setAdapter(aslideAdapter);
        ndotset(0);

        viewPager.addOnPageChangeListener(viewlistner);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Slide_for_tuto.this,demarage.class);
                onDestroy();
                startActivity(i);
            }
        });



}

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public  void dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Slide_for_tuto.this);

        View vie = LayoutInflater.from(Slide_for_tuto.this).inflate(R.layout.dialog_syllabus, null);

        TextView title = (TextView) vie.findViewById(R.id.title);
        TextView desc=(TextView)vie.findViewById(R.id.TVdesc);
       // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");
        builder.setView(vie);
        builder.show();
    }

    public void ndotset(int position){
        ndot=new TextView[12];
        linearLayout.removeAllViews();
        for(int i=0;i<ndot.length;i++){
            ndot[i]=new TextView(this);
            ndot[i].setText(Html.fromHtml("&#8226;"));
            ndot[i].setTextSize(35);
            ndot[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            linearLayout.addView(ndot[i]);
        }
        if(ndot.length>0){
            ndot[position].setTextColor(getResources().getColor(R.color.white));
        }

    }

    ViewPager.OnPageChangeListener viewlistner= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            ndotset(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    @Override
    public void onBackPressed() {
        Intent i =new Intent(Slide_for_tuto.this,demarage.class);
        onDestroy();
        startActivity(i);
    }
}
