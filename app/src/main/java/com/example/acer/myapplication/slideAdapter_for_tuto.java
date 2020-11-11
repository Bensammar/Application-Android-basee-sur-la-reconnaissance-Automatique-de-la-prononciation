package com.example.acer.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by ETS HS on 27/03/2018.
 */

public class slideAdapter_for_tuto extends PagerAdapter {
    //  private  int[] mProgressStatus= {0};
    public static boolean x=false;
    My_helper database;
    Context context;
    LayoutInflater layoutInflater;

    public slideAdapter_for_tuto(Context context) {
        this.context = context;
    }

    public int img[] = {
            R.drawable.un,
            R.drawable.deuxchahba,
            R.drawable.troischahba,
            R.drawable.quatrechahba,
            R.drawable.cinqchahba
    };
    public String slideheadings[] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    public String description[] = {
            "",
            "",
            "",
            "",
            ""
    };


    public  void dialog(){

    }

    @Override
    public int getCount() {
        return slideheadings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {


        ImageView v;
        Button next;
        RelativeLayout r1;


        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layoutslide_for_tuto, container, false);


        v = (ImageView) view.findViewById(R.id.imageView);
        r1=(RelativeLayout)view.findViewById(R.id.relativeimage);


        final ImageView imageView = (ImageView) view.findViewById(R.id.img3);

        final ProgressBar progressBar;
        final Handler mHandler = new Handler();


        final ImageView vb;

        if(position==0){
            r1.setBackgroundResource(R.drawable.a);
        }
        if(position==1){
            r1.setBackgroundResource(R.drawable.b);
        }
        if(position==2){
            r1.setBackgroundResource(R.drawable.c);
        }
        if(position==3){
            r1.setBackgroundResource(R.drawable.d);
        }
        if(position==4){
            r1.setBackgroundResource(R.drawable.e);
        }
        if(position==5){
            r1.setBackgroundResource(R.drawable.f);
        }
        if(position==6){
            r1.setBackgroundResource(R.drawable.g);
        }
        if(position==7){
            r1.setBackgroundResource(R.drawable.h);
        }
        if(position==8){
            r1.setBackgroundResource(R.drawable.i);
        }
        if(position==9){
            r1.setBackgroundResource(R.drawable.j);
        }
        if(position==10){
            r1.setBackgroundResource(R.drawable.k);
        }
        if(position==11){
            r1.setBackgroundResource(R.drawable.l);
        }




        container.addView(view);

        return view;

    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }



}
