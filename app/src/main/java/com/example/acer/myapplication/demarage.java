package com.example.acer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class demarage extends Activity {


    public  My_helper database;
    String langue;
    String dif;
    static int plus =0;
    static boolean chchc;
    public Button start,statistique,multi,chatt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demarage_layout);
        database =new My_helper(this);
        start =(Button)findViewById(R.id.categ);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chchc=false;
                Intent i =new Intent(demarage.this,MainActivity4.class);
                startActivity(i);
            }
        });
        statistique=(Button)findViewById(R.id.statistique);
        statistique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(demarage.this,statistique.class);
                startActivity(i);
            }
        });
        chatt=(Button)findViewById(R.id.chat);
        multi=(Button)findViewById(R.id.multijoueur);
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(demarage.this,enter_ip_add.class);
                startActivity(i);
            }
        });
        chatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(demarage.this,enter_ip_add_chat.class);
                plus=2000;
                chchc=true;
                startActivity(i);
            }
        });

        AddData();

        if(startActivity.langue==true){
            multi.setText("multi-joueur");
            statistique.setText("statistique");
        }
    }

    public  void AddData() {


        String c1= database.insertData(new categorie( "Animals", "0"));
        String c2= database.insertData(new categorie( "Food", "0"));
        String c3= database.insertData(new categorie("Art", "0"));
        String c4= database.insertData(new categorie("Sport", "0"));
        String c5= database.insertData(new categorie("Transport", "0"));
        String c6= database.insertData(new categorie("Medecine", "0"));
        String c7= database.insertData(new categorie("Technologie", "0"));
        String c8= database.insertData(new categorie("revision", "0"));
        String c9= database.insertData(new categorie("Geography", "0"));
        String c10= database.insertData(new categorie("Objects", "0"));

        String m1=database.insertimage(new image("cat",R.drawable.cat));
        String m2=database.insertimage(new image("dog",R.drawable.dog));
        String m3=database.insertimage(new image("lion",R.drawable.lion));
        String m4=database.insertimage(new image("horse",R.drawable.cat));
        String m5=database.insertimage(new image("cow",R.drawable.dog));


        String s1=database.insertimage(new image("sheep",R.drawable.sheep));
        String s2=database.insertimage(new image("monkey",R.drawable.monkey));
        String s3=database.insertimage(new image("tiger",R.drawable.tiger));
        String s4=database.insertimage(new image("panda",R.drawable.panda));
        String s5=database.insertimage(new image("gazelle",R.drawable.gazelle));

        String k1=database.insertimage(new image("crocodile",R.drawable.crocodiles));
        String k2=database.insertimage(new image("snail",R.drawable.escargot));
        String k3=database.insertimage(new image("giraffe",R.drawable.girafe));
        String k4=database.insertimage(new image("frog",R.drawable.grenouille));
        String k5=database.insertimage(new image("rabbit",R.drawable.lapin));


        String t1=database.insertimage(new image("donkey",R.drawable.donkey));
        String t2=database.insertimage(new image("fox",R.drawable.fox));
        String t3=database.insertimage(new image("kitchen",R.drawable.kitchen));
        String t4=database.insertimage(new image("snake",R.drawable.snake));
        String t5=database.insertimage(new image("zebra",R.drawable.zebra));

        String z1=database.insertimage(new image("wolf",R.drawable.loup));
        String z2=database.insertimage(new image("paone",R.drawable.paon));
        String z3=database.insertimage(new image("panther",R.drawable.panthere));
        String z4=database.insertimage(new image("elephant",R.drawable.elephant));
        String z5=database.insertimage(new image("hippopotamus",R.drawable.hippopotame));

        String nour1=database.insertimage(new image("bread",R.drawable.bread));
        String nour2=database.insertimage(new image("carrot",R.drawable.carotte));
        String nour3=database.insertimage(new image("orange",R.drawable.orange));
        String nour4=database.insertimage(new image("pizza",R.drawable.pizza));
        String nour5=database.insertimage(new image("milk",R.drawable.lait));


        String nour6=database.insertimage(new image("tomato",R.drawable.tomate));
        String nour7=database.insertimage(new image("onion",R.drawable.oignon));
        String nour8=database.insertimage(new image("salt",R.drawable.sel));
        String nour9=database.insertimage(new image("olive",R.drawable.olive));
        String nour10=database.insertimage(new image("bean",R.drawable.haricot));

        String nour11=database.insertimage(new image("pineapple",R.drawable.pineapple));
        String nour12=database.insertimage(new image("pepper",R.drawable.poivre));
        String nour13=database.insertimage(new image("cheese",R.drawable.fromage));
        String nour14=database.insertimage(new image("hamburger",R.drawable.hamburger));
        String nour15=database.insertimage(new image("potato",R.drawable.batata));

        String nour16=database.insertimage(new image("egg",R.drawable.egg));
        String nour17=database.insertimage(new image("water",R.drawable.water));
        String nour18=database.insertimage(new image("flour",R.drawable.flour));
        String nour19=database.insertimage(new image("banana",R.drawable.banana));
        String nour20=database.insertimage(new image("strawberry",R.drawable.strawberry));

        String nour21=database.insertimage(new image("lemon",R.drawable.citron));
        String nour22=database.insertimage(new image("rice",R.drawable.rice));
        String nour23=database.insertimage(new image("grapes",R.drawable.grapes));
        String nour24=database.insertimage(new image("sugar",R.drawable.sugar));
        String nour25=database.insertimage(new image("butter",R.drawable.butter));

        String art1=database.insertimage(new image("film",R.drawable.film));
        String art2=database.insertimage(new image("filmmaker",R.drawable.filmmaker));
        String art3=database.insertimage(new image("cartoons",R.drawable.cartoons));
        String art4=database.insertimage(new image("actor",R.drawable.actor));
        String art5=database.insertimage(new image("draw",R.drawable.draw));

        String art6=database.insertimage(new image("cinema",R.drawable.cinema));
        String art7=database.insertimage(new image("camera",R.drawable.camerar));
        String art8=database.insertimage(new image("singer",R.drawable.singer));
        String art9=database.insertimage(new image("museum",R.drawable.museum));
        String art10=database.insertimage(new image("musician",R.drawable.musician));

        String art11=database.insertimage(new image("opera",R.drawable.opera));
        String art12=database.insertimage(new image("theater",R.drawable.theater));
        String art13=database.insertimage(new image("modeling",R.drawable.modeling));
        String art14=database.insertimage(new image("statue",R.drawable.statue));
        String art15=database.insertimage(new image("designer",R.drawable.designer));

        String art16=database.insertimage(new image("writer",R.drawable.writer));
        String art17=database.insertimage(new image("violinist",R.drawable.violinist));
        String art18=database.insertimage(new image("pianist",R.drawable.pianist));
        String art19=database.insertimage(new image("guitarist",R.drawable.guitarist));
        String art20=database.insertimage(new image("brush",R.drawable.brush));

        String art21=database.insertimage(new image("guitar",R.drawable.guitar));
        String art22=database.insertimage(new image("violin",R.drawable.violin));
        String art23=database.insertimage(new image("piano",R.drawable.piano));
        String art24=database.insertimage(new image("drums",R.drawable.battery));
        String art25=database.insertimage(new image("trumpet",R.drawable.trumpet));

        String sp1=database.insertimage(new image("ball",R.drawable.ballon));
        String sp2=database.insertimage(new image("stadium",R.drawable.stade));
        String sp3=database.insertimage(new image("tribune",R.drawable.tribune));
        String sp4=database.insertimage(new image("player",R.drawable.joueur));
        String sp5=database.insertimage(new image("coach",R.drawable.entraineur));

        String sp11=database.insertimage(new image("shirt",R.drawable.maillot));
        String sp12=database.insertimage(new image("baseball",R.drawable.baseball));
        String sp13=database.insertimage(new image("handball",R.drawable.handball));
        String sp14=database.insertimage(new image("racket",R.drawable.raquette));
        String sp15=database.insertimage(new image("volleyball",R.drawable.volleyball));

        String l1=database.insertimage(new image("goal",R.drawable.goal));
        String l2=database.insertimage(new image("basketball",R.drawable.basketball));
        String l3=database.insertimage(new image("club",R.drawable.club));
        String l4=database.insertimage(new image("shorts",R.drawable.shorts));
        String l5=database.insertimage(new image("shoe",R.drawable.soulier));

        String lm1=database.insertimage(new image("gloves",R.drawable.gloves));
        String lm2=database.insertimage(new image("sport",R.drawable.sport));
        String lm3=database.insertimage(new image("racing",R.drawable.racing));
        String lm4=database.insertimage(new image("victory",R.drawable.victory));
        String lm5=database.insertimage(new image("loss",R.drawable.loss));


        String ll1=database.insertimage(new image("golf",R.drawable.golf));
        String ll2=database.insertimage(new image("hockey",R.drawable.hockey));
        String ll3=database.insertimage(new image("ping-pong",R.drawable.ping));
        String ll4=database.insertimage(new image("tennis",R.drawable.tennis));
        String ll5=database.insertimage(new image("billiard",R.drawable.billiards));


        String a1=database.insertimage(new image("car",R.drawable.car));
        String a2=database.insertimage(new image("bus",R.drawable.bus));
        String a3=database.insertimage(new image("train",R.drawable.train));
        String a4=database.insertimage(new image("boat",R.drawable.boat));
        String a5=database.insertimage(new image("airplane",R.drawable.airplane));

        String b1=database.insertimage(new image("bike",R.drawable.velo));
        String b2=database.insertimage(new image("moto",R.drawable.moto));
        String b3=database.insertimage(new image("tramway",R.drawable.tramway));
        String b4=database.insertimage(new image("airport",R.drawable.airoport));
        String b5=database.insertimage(new image("truck",R.drawable.truck));

        String bb1=database.insertimage(new image("wagon",R.drawable.wagon));
        String bb2=database.insertimage(new image("ship",R.drawable.ship));
        String bb3=database.insertimage(new image("tractor",R.drawable.tracteur));
        String bb4=database.insertimage(new image("pirogue",R.drawable.pirogue));
        String bb5=database.insertimage(new image("tank",R.drawable.tank));

        String bc1=database.insertimage(new image("para",R.drawable.para));
        String bc2=database.insertimage(new image("scooter",R.drawable.scooter));
        String bc3=database.insertimage(new image("carrosse",R.drawable.carosse));
        String bc4=database.insertimage(new image("zep",R.drawable.zep));
        String bc5=database.insertimage(new image("metro",R.drawable.metro));


        String cc1=database.insertimage(new image("peniche",R.drawable.peniche));
        String cc2=database.insertimage(new image("fourgon",R.drawable.fourgon));
        String cc3=database.insertimage(new image("ticket",R.drawable.ticket));
        String cc4=database.insertimage(new image("chauffeur",R.drawable.chauffeur));
        String cc5=database.insertimage(new image("hele",R.drawable.hele));

        String med1=database.insertimage(new image("radio",R.drawable.radio));
        String med2=database.insertimage(new image("doctor",R.drawable.medecin));
        String med3=database.insertimage(new image("medicament",R.drawable.medicament));
        String med4=database.insertimage(new image("scanner",R.drawable.scanner));
        String med5=database.insertimage(new image("patient",R.drawable.patient));

        String med6=database.insertimage(new image("pharmacie",R.drawable.pharmacie));
        String med7=database.insertimage(new image("chirurgien",R.drawable.chirurgien));
        String med8=database.insertimage(new image("dentiste",R.drawable.dentiste));
        String med9=database.insertimage(new image("operation",R.drawable.operation));
        String med10=database.insertimage(new image("hopital",R.drawable.hopital));

        String med11=database.insertimage(new image("gants",R.drawable.gants));
        String med12=database.insertimage(new image("clinique",R.drawable.clinique));
        String med13=database.insertimage(new image("blouse",R.drawable.blouse));
        String med14=database.insertimage(new image("bulb",R.drawable.ampoule));
        String med15=database.insertimage(new image("radiologue",R.drawable.radiologue));

        String med16=database.insertimage(new image("suppo",R.drawable.suppo));
        String med17=database.insertimage(new image("injection",R.drawable.injection));
        String med18=database.insertimage(new image("glasses",R.drawable.glasses));
        String med19=database.insertimage(new image("fracture",R.drawable.fracture));
        String med20=database.insertimage(new image("stamp",R.drawable.stamp));

        String med21=database.insertimage(new image("lens",R.drawable.lentilles));
        String med22=database.insertimage(new image("room",R.drawable.room));
        String med23=database.insertimage(new image("plaster",R.drawable.platre));
        String med24=database.insertimage(new image("dechirure",R.drawable.dechirure));
        String med25=database.insertimage(new image("office",R.drawable.office));

        String tec1=database.insertimage(new image("phone",R.drawable.phone));
        String tec2=database.insertimage(new image("television",R.drawable.television));
        String tec3=database.insertimage(new image("modem",R.drawable.modem));
        String tec4=database.insertimage(new image("robot",R.drawable.robot));
        String tec5=database.insertimage(new image("parleur",R.drawable.parleur));

        String tec6=database.insertimage(new image("stove",R.drawable.stove));
        String tec7=database.insertimage(new image("printer",R.drawable.imprimante));
        String tec8=database.insertimage(new image("demo",R.drawable.demo));
        String tec9=database.insertimage(new image("application",R.drawable.application));
        String tec10=database.insertimage(new image("ecran",R.drawable.ecran));

        String tec11=database.insertimage(new image("automobile",R.drawable.automobile));
        String tec12=database.insertimage(new image("souris",R.drawable.souris));
        String tec13=database.insertimage(new image("ascenseur",R.drawable.ascenseur));
        String tec14=database.insertimage(new image("clavier",R.drawable.clavier));
        String tec15=database.insertimage(new image("clock",R.drawable.horloge));

        String tec16=database.insertimage(new image("informatique",R.drawable.informatique));
        String tec17=database.insertimage(new image("mixeur",R.drawable.mixeur));
        String tec18=database.insertimage(new image("climatiseur",R.drawable.climatiseur));
        String tec19=database.insertimage(new image("refrigerator",R.drawable.refrigerator));
        String tec20=database.insertimage(new image("frigo",R.drawable.frigo));

        String tec21=database.insertimage(new image("montre",R.drawable.montre));
        String tec22=database.insertimage(new image("souris",R.drawable.souris));
        String tec23=database.insertimage(new image("clavier",R.drawable.clavier));
        String tec24=database.insertimage(new image("ecran",R.drawable.ecran));
        String tec25=database.insertimage(new image("mixeur",R.drawable.mixeur));

        String aa1=database.insertimage(new image("algeria",R.drawable.alg_flag));
        String aa2=database.insertimage(new image("french",R.drawable.french_flag));
        String aa3=database.insertimage(new image("spain",R.drawable.spain_flag));
        String aa4=database.insertimage(new image("canada",R.drawable.canada_flag));
        String aa5=database.insertimage(new image("italy",R.drawable.italy_flag));

        String ac1=database.insertimage(new image("brazil",R.drawable.brazil));
        String ac2=database.insertimage(new image("tunisia",R.drawable.tunisia));
        String ac3=database.insertimage(new image("bolivia",R.drawable.bolivia));
        String ac4=database.insertimage(new image("india",R.drawable.india));
        String ac5=database.insertimage(new image("china",R.drawable.china));

        String ad1=database.insertimage(new image("suisse",R.drawable.suisse));
        String ad2=database.insertimage(new image("maroc",R.drawable.maroc));
        String ad3=database.insertimage(new image("portugal",R.drawable.portugal));
        String ad4=database.insertimage(new image("belgique",R.drawable.belgique));
        String ad5=database.insertimage(new image("germany",R.drawable.germany));

        String ak1=database.insertimage(new image("egypt",R.drawable.egypt));
        String ak2=database.insertimage(new image("engelt",R.drawable.eng));
        String ak3=database.insertimage(new image("mexico",R.drawable.mexico));
        String ak4=database.insertimage(new image("japan",R.drawable.japan));
        String ak5=database.insertimage(new image("australia",R.drawable.australia));

        String at1=database.insertimage(new image("argentine",R.drawable.argentine));
        String at2=database.insertimage(new image("uruguay",R.drawable.uruguay));
        String at3=database.insertimage(new image("colombia",R.drawable.colombia));
        String at4=database.insertimage(new image("iceland",R.drawable.iceland));
        String at5=database.insertimage(new image("costa",R.drawable.costa));


        String am1=database.insertimage(new image("bed",R.drawable.bed));
        String am2=database.insertimage(new image("table",R.drawable.table));
        String am3=database.insertimage(new image("door",R.drawable.door));
        String am4=database.insertimage(new image("picture",R.drawable.picture));
        String am5=database.insertimage(new image("stair",R.drawable.stair));

        String as1=database.insertimage(new image("chair",R.drawable.chair));
        String as2=database.insertimage(new image("plate",R.drawable.plate));
        String as3=database.insertimage(new image("cup",R.drawable.cup));
        String as4=database.insertimage(new image("box",R.drawable.box));
        String as5=database.insertimage(new image("bathroom",R.drawable.bathroom));

        String ax1=database.insertimage(new image("pen",R.drawable.pen));
        String ax2=database.insertimage(new image("spoon",R.drawable.spoon));
        String ax3=database.insertimage(new image("knife",R.drawable.knife));
        String ax4=database.insertimage(new image("book",R.drawable.book));
        String ax5=database.insertimage(new image("receiver",R.drawable.receiver));

        String ay1=database.insertimage(new image("ciseaux",R.drawable.ciseaux));
        String ay2=database.insertimage(new image("pebble",R.drawable.pebble));
        String ay3=database.insertimage(new image("pencil",R.drawable.pencil));
        String ay4=database.insertimage(new image("bottle",R.drawable.bottle));
        String ay5=database.insertimage(new image("glass",R.drawable.glass));

        String az1=database.insertimage(new image("clock",R.drawable.clock));
        String az2=database.insertimage(new image("rubber",R.drawable.rubber));
        String az3=database.insertimage(new image("ruler",R.drawable.ruler));
        String az4=database.insertimage(new image("lock",R.drawable.lock));
        String az5=database.insertimage(new image("calculator",R.drawable.calculator));

        String n1=database.insertniveau(new niveau("niv1cat1"));
        String n2=database.insertniveau(new niveau("niv2cat1"));
        String n3=database.insertniveau(new niveau("niv3cat1"));
        String n4=database.insertniveau(new niveau("niv4cat1"));
        String n5=database.insertniveau(new niveau("niv5cat1"));

        String n11=database.insertniveau(new niveau("niv1cat2"));
        String n12=database.insertniveau(new niveau("niv2cat2"));
        String n13=database.insertniveau(new niveau("niv3cat2"));
        String n14=database.insertniveau(new niveau("niv4cat2"));
        String n15=database.insertniveau(new niveau("niv5cat2"));

        String n21=database.insertniveau(new niveau("niv1cat3"));
        String n22=database.insertniveau(new niveau("niv2cat3"));
        String n23=database.insertniveau(new niveau("niv3cat3"));
        String n24=database.insertniveau(new niveau("niv4cat3"));
        String n25=database.insertniveau(new niveau("niv5cat3"));

        String n31=database.insertniveau(new niveau("niv1cat4"));
        String n32=database.insertniveau(new niveau("niv2cat4"));
        String n33=database.insertniveau(new niveau("niv3cat4"));
        String n34=database.insertniveau(new niveau("niv4cat4"));
        String n35=database.insertniveau(new niveau("niv5cat4"));

        String n41=database.insertniveau(new niveau("niv1cat5"));
        String n42=database.insertniveau(new niveau("niv2cat5"));
        String n43=database.insertniveau(new niveau("niv3cat5"));
        String n44=database.insertniveau(new niveau("niv4cat5"));
        String n45=database.insertniveau(new niveau("niv5cat5"));

        String n71=database.insertniveau(new niveau("niv1cat6"));
        String n72=database.insertniveau(new niveau("niv2cat6"));
        String n73=database.insertniveau(new niveau("niv3cat6"));
        String n74=database.insertniveau(new niveau("niv4cat6"));
        String n75=database.insertniveau(new niveau("niv5cat6"));

        String n81=database.insertniveau(new niveau("niv1cat7"));
        String n82=database.insertniveau(new niveau("niv2cat7"));
        String n83=database.insertniveau(new niveau("niv3cat7"));
        String n84=database.insertniveau(new niveau("niv4cat7"));
        String n85=database.insertniveau(new niveau("niv5cat7"));

        String n51=database.insertniveau(new niveau("niv1cat8"));
        String n52=database.insertniveau(new niveau("niv2cat8"));
        String n53=database.insertniveau(new niveau("niv3cat8"));
        String n54=database.insertniveau(new niveau("niv4cat8"));
        String n55=database.insertniveau(new niveau("niv5cat8"));

        String n61=database.insertniveau(new niveau("niv1cat9"));
        String n62=database.insertniveau(new niveau("niv2cat9"));
        String n63=database.insertniveau(new niveau("niv3cat9"));
        String n64=database.insertniveau(new niveau("niv4cat9"));
        String n65=database.insertniveau(new niveau("niv5cat9"));



        Intent i=getIntent();

        if(startActivity.langue){
            langue="fr";
        }else
            langue="eng";

        if(choisir_niveaux_dif.niveaudif==0){
            dif="facile";
        }else if(choisir_niveaux_dif.niveaudif==1){
            dif="moyen";
        }else if(choisir_niveaux_dif.niveaudif==2){
            dif="dificile";
        }

        database.createuser(new user("" + login_activite.nom, "" + login_activite.password), new String[]{c1, c2, c3,c4,c5,c6,c7,c8,c9,c10}, new String[]{m1, m2, m3,m4,m5,s1,s2,s3,s4,s5,k1,k2,k3,k4,k5,t1,t2,t3,t4,t5,z1,z2,z3,z4,z5,
                nour1,nour2,nour3,nour4,nour5,nour6,nour7,nour8,nour9,nour10,nour11,nour12,nour13,nour14,nour15,nour16,nour17,nour18,nour19,nour20,nour21,nour22,nour23,nour24,nour25,
                art1,art2,art3,art4,art5,art6,art7,art8,art9,art10,art11,art12,art13,art14,art15,art16,art17,art18,art19,art20,art21,art22,art23,art24,art25,sp1,sp2,sp3,sp4,sp5,sp11,sp12,sp13,sp14,sp15,l1,l2,l3,l4,l5,lm1,lm2,lm3,lm4,lm5,ll1,ll2,ll3,ll4,ll5,
                a1,a2,a3,a4,a5,b1,b2,b3,b4,b5,bb1,bb2,bb3,bb4,bb5,bc1,bc2,bc3,
                bc4,bc5,cc1,cc2,cc3,cc4,cc5,med1,med2,med3,med4,med5,med6,med7,med8,med9,med10,med11,med12,
                med13,med14,med15,med16,med17,med18,med19,med20,med21,med22,med23,med24,med25,tec1,tec2,tec3,tec4,tec5,tec6,
                tec7,tec8,tec9,tec10,tec11,tec12,tec13,tec14,tec15,tec16,tec17,tec18,tec19,tec20,tec21,tec22,tec23,tec24,tec25,aa1,aa2,aa3,aa4,aa5,ac1,ac2,ac3,ac4,ac5,ad1,ad2,ad3,ad4,ad5,ak1,ak2,ak3,ak4,ak5,at1,at2,at3,at4,at5,am1,am2,am3,am4,am5,as1,as2,as3,as4,as5,ax1,ax2,ax3,ax4,ax5,ay1,ay2,ay3,ay4,ay5,az1,az2,az3,az4,az5}, new String[]{n1, n2, n3,n4,n5,n11,n12,n13,n14, n15,n21,n22,n23,n24,n25,n31,n32,n33,n34,
                n35,n41,n42,n43,n44,n45,n51,n52,n53,n54,n55,n61,n62,n63,n64,n65,n71,n72,n73,n74,n75,n81,n82,n84,n83,n85},""+langue,""+dif);


    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(),choisir_niveaux_dif.class);
        startActivity(i);
    }
}
