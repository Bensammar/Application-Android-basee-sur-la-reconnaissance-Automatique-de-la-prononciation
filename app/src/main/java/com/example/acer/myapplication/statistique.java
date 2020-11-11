package com.example.acer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class statistique extends Activity {
    Spinner spinner,spinner2,spinner3 ;
    ArrayAdapter<String> adapter,adapter2,adapter3;
    String names[] = {"cat","dog","lion","horse","cow","sheep","monkey","tiger","panda","gazelle","crocodile","snail","giraffe","frog","rabbit","donkey","fox","kitchen","snake","zebra","wolf","paone","panther","elephant","hippopotamus"};
    String livels[] = {"niv1","niv2","niv3","niv4","niv5"};
    String categories[] = {"Animaux","Sport","M"};
    My_helper database;
    TextView t1,t2,t3;
    public String langue;

    int Scoreniv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistique);

        database = new My_helper(this);

        ImageView imganim = (ImageView) findViewById(R.id.imganim);
        ImageView imgfood = (ImageView) findViewById(R.id.imgfood);
        ImageView imgtech = (ImageView) findViewById(R.id.imgtech);
        ImageView imggeo = (ImageView) findViewById(R.id.imggeo);
        ImageView imgart = (ImageView) findViewById(R.id.imgart);
        ImageView imgobj = (ImageView) findViewById(R.id.imgobject);
        ImageView imgtrans = (ImageView) findViewById(R.id.imgtrans);
        ImageView imgmed = (ImageView) findViewById(R.id.imgmedecine);
        ImageView imgsport = (ImageView) findViewById(R.id.imgsport);

        imganim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int scorecat1 = ((viewAll2("niv1cat1")) + viewAll2("niv2cat1") + viewAll2("niv3cat1") + viewAll2("niv4cat1") + viewAll2("niv5cat1")) / 5;
                Toasty.warning(getApplication(), "Le score de la cat animal : " + scorecat1, Toast.LENGTH_SHORT).show();
            }
        });


        registerForContextMenu(imganim);

        imgart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int scorecat2=((viewAll2("niv1cat2"))+viewAll2("niv2cat2")+viewAll2("niv3cat2")+viewAll2("niv4cat2")+viewAll2("niv5cat2"))/5;
                Toasty.warning(getApplication(), "Le score de la cat art : " + scorecat2, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(imgart);


        imgfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int scorecat3=((viewAll2("niv1cat3"))+viewAll2("niv2cat3")+viewAll2("niv3cat3")+viewAll2("niv4cat3")+viewAll2("niv5cat3"))/5;
                Toasty.warning(getApplication(), "Le score de la cat food : " + scorecat3, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(imgfood);

        imggeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int  scorecat4=((viewAll2("niv1cat4"))+viewAll2("niv2cat4")+viewAll2("niv3cat4")+viewAll2("niv4cat4")+viewAll2("niv5cat4"))/5;
                Toasty.warning(getApplication(), "Le score de la cat geo : " + scorecat4, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(imggeo);

        imgmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int  scorecat5=((viewAll2("niv1cat5"))+viewAll2("niv2cat5")+viewAll2("niv3cat5")+viewAll2("niv4cat5")+viewAll2("niv5cat5"))/5;
                Toasty.warning(getApplication(), "Le score de la cat Medecine : " + scorecat5, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(imgmed);

        imgobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int  scorecat6=((viewAll2("niv1cat6"))+viewAll2("niv2cat6")+viewAll2("niv3cat6")+viewAll2("niv4cat6")+viewAll2("niv5cat6"))/5;
                Toasty.warning(getApplication(), "Le score de la cat objet : " + scorecat6, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(imgobj);

        imgsport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int scorecat7 = ((viewAll2("niv1cat7")) + viewAll2("niv2cat7") + viewAll2("niv3cat7") + viewAll2("niv4cat7") + viewAll2("niv5cat7")) / 5;
                Toasty.warning(getApplication(), "Le score de la cat sport : " + scorecat7, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(imgsport);

        imgtech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int  scorecat8=((viewAll2("niv1cat8"))+viewAll2("niv2cat8")+viewAll2("niv3cat8")+viewAll2("niv4cat8")+viewAll2("niv5cat8"))/5;
                Toasty.warning(getApplication(), "Le score de la cat techno : " + scorecat8, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(imgtech);

        imgtrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int  scorecat9=((viewAll2("niv1cat9"))+viewAll2("niv2cat9")+viewAll2("niv3cat9")+viewAll2("niv4cat9")+viewAll2("niv5cat9"))/5;
                Toasty.warning(getApplication(), "Le score de la cat transport : " + scorecat9, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(imgtrans);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()) {
            case (R.id.imganim):
                getMenuInflater().inflate(R.menu.stats, menu);
                return;
            case (R.id.imgfood):
                getMenuInflater().inflate(R.menu.stats_food, menu);
                return;
            case (R.id.imgsport):
                getMenuInflater().inflate(R.menu.stats_sport, menu);
                return;
            case (R.id.imgart):
                getMenuInflater().inflate(R.menu.stats_art, menu);
                return;
            case (R.id.imgmedecine):
                getMenuInflater().inflate(R.menu.stats_med, menu);
                return;
            case (R.id.imggeo):
                getMenuInflater().inflate(R.menu.stats_geo, menu);
                return;
            case (R.id.imgobject):
                getMenuInflater().inflate(R.menu.stats_object, menu);
                return;
            case (R.id.imgtech):
                getMenuInflater().inflate(R.menu.stats_techno, menu);
                return;
            case (R.id.imgtrans):
                getMenuInflater().inflate(R.menu.stats_trans, menu);
                return;

        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case(R.id.opt1_anim):
               int scoreniv1=viewAll2("niv1cat1");

                Toasty.info(getApplicationContext(),""+scoreniv1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_anim):

                int scoreniv2=viewAll2("niv2cat1");
                Toasty.info(getApplicationContext(),""+scoreniv2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_anim):

                int scoreniv3=viewAll2("niv3cat1");
                Toasty.info(getApplicationContext(),""+scoreniv3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_anim):

                int scoreniv4=viewAll2("niv4cat1");
                Toasty.info(getApplicationContext(),""+scoreniv4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_anim):

                int scoreniv5=viewAll2("niv5cat1");
                Toasty.info(getApplicationContext(),""+scoreniv5,Toast.LENGTH_SHORT).show();
                return true;



            case(R.id.opt1_art):
                int art1=viewAll2("niv1cat2");

                Toasty.info(getApplicationContext(),""+art1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_art):

                int art2=viewAll2("niv2cat2");
                Toasty.info(getApplicationContext(),""+art2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_art):

                int art3=viewAll2("niv3cat2");
                Toasty.info(getApplicationContext(),""+art3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_art):

                int art4=viewAll2("niv4cat2");
                Toasty.info(getApplicationContext(),""+art4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_art):

                int art5=viewAll2("niv5cat2");
                Toasty.info(getApplicationContext(),""+art5,Toast.LENGTH_SHORT).show();
                return true;



            case(R.id.opt1_food):
                int food1=viewAll2("niv1cat3");

                Toasty.info(getApplicationContext(),""+food1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_food):

                int food2=viewAll2("niv2cat3");
                Toasty.info(getApplicationContext(),""+food2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_food):

                int food3=viewAll2("niv3cat3");
                Toasty.info(getApplicationContext(),""+food3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_food):

                int food4=viewAll2("niv4cat3");
                Toasty.info(getApplicationContext(),""+food4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_food):

                int food5=viewAll2("niv5cat3");
                Toasty.info(getApplicationContext(),""+food5,Toast.LENGTH_SHORT).show();
                return true;



            case(R.id.opt1_geo):
                int geo1=viewAll2("niv1cat4");

                Toasty.info(getApplicationContext(),""+geo1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_geo):

                int geo2=viewAll2("niv2cat4");
                Toasty.info(getApplicationContext(),""+geo2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_geo):

                int geo3=viewAll2("niv3cat4");
                Toasty.info(getApplicationContext(),""+geo3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_geo):

                int geo4=viewAll2("niv4cat4");
                Toasty.info(getApplicationContext(),""+geo4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_geo):

                int geo5=viewAll2("niv5cat4");
                Toasty.info(getApplicationContext(),""+geo5,Toast.LENGTH_SHORT).show();
                return true;


            case(R.id.opt1_med):
                int med1=viewAll2("niv1cat5");

                Toasty.info(getApplicationContext(),""+med1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_med):

                int med2=viewAll2("niv2cat5");
                Toasty.info(getApplicationContext(),""+med2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_med):

                int med3=viewAll2("niv3cat5");
                Toasty.info(getApplicationContext(),""+med3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_med):

                int med4=viewAll2("niv4cat5");
                Toasty.info(getApplicationContext(),""+med4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_med):

                int med5=viewAll2("niv5cat5");
                Toasty.info(getApplicationContext(),""+med5,Toast.LENGTH_SHORT).show();
                return true;



            case(R.id.opt1_obj):
                int obj1=viewAll2("niv1cat6");

                Toasty.info(getApplicationContext(),""+obj1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_obj):

                int obj2=viewAll2("niv2cat6");
                Toasty.info(getApplicationContext(),""+obj2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_obj):

                int obj3=viewAll2("niv3cat6");
                Toasty.info(getApplicationContext(),""+obj3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_obj):

                int obj4=viewAll2("niv4cat6");
                Toasty.info(getApplicationContext(),""+obj4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_obj):

                int obj5=viewAll2("niv5cat6");
                Toasty.info(getApplicationContext(),""+obj5,Toast.LENGTH_SHORT).show();
                return true;


            case(R.id.opt1_sport):
                int sport1=viewAll2("niv1cat7");

                Toasty.info(getApplicationContext(),""+sport1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_sport):

                int sport2=viewAll2("niv2cat7");
                Toasty.info(getApplicationContext(),""+sport2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_sport):

                int sport3=viewAll2("niv3cat7");
                Toasty.info(getApplicationContext(),""+sport3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_sport):

                int sport4=viewAll2("niv4cat7");
                Toasty.info(getApplicationContext(),""+sport4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_sport):

                int sport5=viewAll2("niv5cat7");
                Toasty.info(getApplicationContext(),""+sport5,Toast.LENGTH_SHORT).show();
                return true;




            case(R.id.opt1_techno):
                int tech1=viewAll2("niv1cat8");

                Toasty.info(getApplicationContext(),""+tech1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_techno):

                int tech2=viewAll2("niv2cat8");
                Toasty.info(getApplicationContext(),""+tech2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_techno):

                int tech3=viewAll2("niv3cat8");
                Toasty.info(getApplicationContext(),""+tech3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_techno):

                int tech4=viewAll2("niv4cat8");
                Toasty.info(getApplicationContext(),""+tech4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_techno):

                int tech5=viewAll2("niv5cat8");
                Toasty.info(getApplicationContext(),""+tech5,Toast.LENGTH_SHORT).show();
                return true;




            case(R.id.opt1_trans):
                int trans1=viewAll2("niv1cat9");

                Toasty.info(getApplicationContext(),""+trans1,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt2_trans):

                int trans2=viewAll2("niv2cat9");
                Toasty.info(getApplicationContext(),""+trans2,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt3_trans):

                int trans3=viewAll2("niv3cat9");
                Toasty.info(getApplicationContext(),""+trans3,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt4_trans):

                int trans4=viewAll2("niv4cat9");
                Toasty.info(getApplicationContext(),""+trans4,Toast.LENGTH_SHORT).show();
                return true;

            case(R.id.opt5_trans):

                int trans5=viewAll2("niv5cat9");
                Toasty.info(getApplicationContext(),""+trans5,Toast.LENGTH_SHORT).show();
                return true;



            default:
                return super.onContextItemSelected(item);
        }

    }

    public  int viewAll2(String nomimg) {
        int kaka = 0;
        Cursor res = database.getAllDatajouerniv(nomimg);


        res.moveToFirst();
        while (!res.isAfterLast()) {
            kaka= res.getInt(0);

            res.moveToNext();
        }
        database.closedv();

        return kaka;
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(),demarage.class);
        startActivity(i);
    }
}
