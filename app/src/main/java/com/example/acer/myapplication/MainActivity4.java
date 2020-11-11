package com.example.acer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends Activity {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private gridViewAdpter gridViewAdapter;
    private ListViewAdpter listViewAdapter;
    private List<categorie> buffer;
    private int currentViewMode = 0;
    public static My_helper database;
    public String difuculte;




    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;
    String langue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        database =new My_helper(this);

        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);

        //Inflate ViewStub before get view

        stubList.inflate();
        stubGrid.inflate();

        listView = (ListView) findViewById(R.id.my_list_item);
        gridView = (GridView) findViewById(R.id.mygridl);


        int scorecat1,scorecat2,scorecat3,scorecat4,scorecat5,scorecat6,scorecat7,scorecat8,scorecat9,scorecat10;

        scorecat1=((viewAll2("niv1cat1"))+viewAll2("niv2cat1")+viewAll2("niv3cat1")+viewAll2("niv4cat1")+viewAll2("niv5cat1"))/5;
        scorecat2=((viewAll2("niv1cat2"))+viewAll2("niv2cat2")+viewAll2("niv3cat2")+viewAll2("niv4cat2")+viewAll2("niv5cat2"))/5;
        scorecat3=((viewAll2("niv1cat3"))+viewAll2("niv2cat3")+viewAll2("niv3cat3")+viewAll2("niv4cat3")+viewAll2("niv5cat3"))/5;
        scorecat4=((viewAll2("niv1cat4"))+viewAll2("niv2cat4")+viewAll2("niv3cat4")+viewAll2("niv4cat4")+viewAll2("niv5cat4"))/5;
        scorecat5=((viewAll2("niv1cat5"))+viewAll2("niv2cat5")+viewAll2("niv3cat5")+viewAll2("niv4cat5")+viewAll2("niv5cat5"))/5;
        scorecat6=((viewAll2("niv1cat6"))+viewAll2("niv2cat6")+viewAll2("niv3cat6")+viewAll2("niv4cat6")+viewAll2("niv5cat6"))/5;
        scorecat7=((viewAll2("niv1cat7"))+viewAll2("niv2cat7")+viewAll2("niv3cat7")+viewAll2("niv4cat7")+viewAll2("niv5cat7"))/5;
        scorecat8=((viewAll2("niv1cat8"))+viewAll2("niv2cat8")+viewAll2("niv3cat8")+viewAll2("niv4cat8")+viewAll2("niv5cat8"))/5;
        scorecat9=((viewAll2("niv1cat9"))+viewAll2("niv2cat9")+viewAll2("niv3cat9")+viewAll2("niv4cat9")+viewAll2("niv5cat9"))/5;
        scorecat10=((viewAll2("niv1cat10"))+viewAll2("niv2cat10")+viewAll2("niv3cat10")+viewAll2("niv4cat10")+viewAll2("niv5cat10"))/5;


        //get list of
        update(scorecat1,"Animals");
        update(scorecat2,"Art");
        update(scorecat3,"Food");
        update(scorecat4,"Geography");
        update(scorecat5,"Medecine");
        update(scorecat6,"Objects");
        update(scorecat7,"Sport");
        update(scorecat8,"Technologie");
        update(scorecat9,"Transport");
        update(scorecat10,"revision");

        viewAll();

        //Get current view mode in share reference
        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview
        //Register item lick
        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);


        switchView();

    }

    private void switchView() {

        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            //Display listview
            stubList.setVisibility(View.VISIBLE);
            //Hide gridview
//            stubGrid.setVisibility(View.GONE);
        } else {
            //Hide listview
            stubList.setVisibility(View.GONE);
            //Display gridview
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapters(listViewAdapter);
    }

    public void setAdapters(ListViewAdpter listViewAdapter2) {
        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewAdapter2 = new ListViewAdpter(this, R.layout.list_item, buffer);
            listView.setAdapter(listViewAdapter2);
        }else {
            gridViewAdapter = new gridViewAdpter(this, R.layout.grid_item, buffer);
            gridView.setAdapter(gridViewAdapter);
        }
    }


    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Do any thing when user click to item
            // Toast.makeText(getApplicationContext(), stageList.get(position).getTitle() + " - " + stageList.get(position).getDescription(), Toast.LENGTH_SHORT).show();

            if(position==0){
                Intent i=new Intent(MainActivity4.this,Slide.class);
                startActivity(i);
            }
            if(position==1){
                Intent i=new Intent(MainActivity4.this,Slide3.class);
                startActivity(i);
            }
            if(position==2){

                Intent i=new Intent(MainActivity4.this,Slide2.class);
                startActivity(i);
            }
            if(position==3){
                Intent i=new Intent(MainActivity4.this,Slide_for_geo.class);
                startActivity(i);
            }
            if(position==4){
                Intent i=new Intent(MainActivity4.this,Slide_for_medecine.class);
                startActivity(i);
            }
            if(position==5){
                Intent i=new Intent(MainActivity4.this,Slide_for_object.class);
                startActivity(i);
            }
            if(position==6){
                Intent i=new Intent(MainActivity4.this,Slide_for_sport.class);
                startActivity(i);
            }
            if(position==7){
                Intent i=new Intent(MainActivity4.this,Slide_for_techno.class);
                startActivity(i);
            }if(position==8){
                Intent i=new Intent(MainActivity4.this,Slide_for_trans.class);
                startActivity(i);
            }if(position==9){
                Intent i=new Intent(MainActivity4.this,Slide_for_revision.class);
                startActivity(i);
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_1:
                if(VIEW_MODE_LISTVIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                } else {
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }
                //Switch view
                switchView();
                //Save view mode in share reference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();

                break;
        }
        return true;
    }

    public void viewAll() {

        if(startActivity.langue){
            langue="fr";
        }else
            langue="eng";
        if(choisir_niveaux_dif.niveaudif==0){
            difuculte="facile";
        }else if(choisir_niveaux_dif.niveaudif==1){
            difuculte="moyen";
        }else if(choisir_niveaux_dif.niveaudif==2){
            difuculte="dificile";
        }
        Cursor res = database.getAllData(login_activite.nom,langue,difuculte);

        buffer = new ArrayList<>();
        res.moveToFirst();
        while (!res.isAfterLast()) {
            buffer.add(new categorie(
                    res.getString(1),
                    res.getString(2)
                    ));

            res.moveToNext();
        }
        database.closedv();
    }


    public void update(int score ,String ca){


        String lg;
        if(startActivity.langue){
            lg="fr";
        }else {
            lg = "eng";
        }
        if(choisir_niveaux_dif.niveaudif==0){
            difuculte="facile";
        }else if(choisir_niveaux_dif.niveaudif==1){
            difuculte="moyen";
        }else if(choisir_niveaux_dif.niveaudif==2){
            difuculte="dificile";
        }
        database.updateDataCategorie(""+ca,login_activite.nom,score,lg,difuculte);
    }

    public static int viewAll2(String nomimg) {
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
        Intent i=new Intent(MainActivity4.this,demarage.class);
        startActivity(i);

    }
}



