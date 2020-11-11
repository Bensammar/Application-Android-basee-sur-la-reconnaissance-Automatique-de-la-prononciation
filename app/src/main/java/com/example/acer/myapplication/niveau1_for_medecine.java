package com.example.acer.myapplication;

import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.RecognitionListener;
import edu.cmu.pocketsphinx.SpeechRecognizer;
import edu.cmu.pocketsphinx.SpeechRecognizerSetup;
import es.dmoral.toasty.Toasty;

import static android.widget.Toast.makeText;

public class niveau1_for_medecine extends Activity implements RecognitionListener {

    /* Named searches allow to quickly reconfigure the decoder */
    public  My_helper database;
    private static final String CAT_SEARCH = "cats";
    private static final String Fr_Search = "frs";
    private static final String DOG_SEARCH = "dogs";
    private static final String LION_SEARCH = "lions";
    private static final String HORSE_SEARCH = "horses";
    private static final String COW_SEARCH = "cows";

    private static final String CHAT_SEARCH = "cats";
    private static final String CHIEN_SEARCH = "dogs";
    private static final String LIONFR_SEARCH = "lions";
    private static final String CHEVAL_SEARCH = "horses";
    private static final String VACHE_SEARCH = "cows";
    public static final String mm="sound";
    /* Keyword we are looking for to activate menu */
    /* Used to handle permission request */
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    Button aideb;
    private SpeechRecognizer recognizer;
    private HashMap<String, Integer> captions;
    private  boolean b=false;
    Button b1,b2,b10;
    public static int a;
    public static String  extra_number="score";
    public static int jeton1=3;
    public static   int jeton2=3;
    public static int jeton3=3;
    public static int jeton4=3;
    public static int jeton5=3;


    public static int jeton1_fr=3;
    public static   int jeton2_fr=3;
    public static int jeton3_fr=3;
    public static int jeton4_fr=3;
    public static int jeton5_fr=3;


    public  CircleImageView img;
    public boolean x=false;
    public  int count=1;
    public  int count2=1;
    public static int TotalScore=0;
    public static int TotalScore2=0;
    public String nom,password;
    public String difuculte;
    TextView t1;



    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // Prepare the data for UI
        captions = new HashMap<>();
        setContentView(R.layout.activity_main);
        if(choisir_niveaux_dif.niveaudif==0){
            difuculte="facile";
        }else if(choisir_niveaux_dif.niveaudif==1){
            difuculte="moyen";
        }else if(choisir_niveaux_dif.niveaudif==2){
            difuculte="dificile";
        }

        // Check if user has given permission to record audio
        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
            return;
        }
        // Recognizer initialization is a time-consuming and it involves IO,
        // so we execute it in async task
        new SetupTask(this).execute();
        img=(CircleImageView)findViewById(R.id.img);
        //title=(TextView)findViewById(R.id.imgname);
        t1=(TextView)findViewById(R.id.imgname);

        b10=(Button)findViewById(R.id.help);


        if(startActivity.langue==false) {

            if (count == 1) {
                img.setImageResource(R.drawable.radio);
            } else if (count == 2) {
                img.setImageResource(R.drawable.medecin);
            } else if (count == 3) {
                img.setImageResource(R.drawable.medicament);
            } else if (count == 4) {
                img.setImageResource(R.drawable.patient);
            } else if (count == 5) {
                img.setImageResource(R.drawable.scanner);
            }
        }
        if(startActivity.langue==true) {
            if (count2 == 1) {
                img.setImageResource(R.drawable.radio);
            } else if (count2 == 2) {
                img.setImageResource(R.drawable.medecin);
            } else if (count2 == 3) {
                img.setImageResource(R.drawable.medicament);
            } else if (count2 == 4) {
                img.setImageResource(R.drawable.patient);
            } else if (count2 == 5) {
                img.setImageResource(R.drawable.scanner);
            }
        }


        b1 =(Button)findViewById(R.id.speak);
        b1.setEnabled(false);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if(startActivity.langue==false) {
                    if (count == 1) {
                        switchSearch(CAT_SEARCH);
                    } else if (count == 2) {
                        switchSearch(DOG_SEARCH);
                    } else if (count == 3) {
                        switchSearch(LION_SEARCH);
                    } else if (count == 4) {
                        switchSearch(HORSE_SEARCH);
                    } else if (count == 5) {
                        switchSearch(COW_SEARCH);
                    }
                }else if(startActivity.langue==true){
                    if (count2 == 1) {
                        switchSearch(CHAT_SEARCH);
                    } else if (count2 == 2) {
                        switchSearch(CHIEN_SEARCH);
                    } else if (count2 == 3) {
                        switchSearch(LIONFR_SEARCH);
                    } else if (count2 == 4) {
                        switchSearch(CHEVAL_SEARCH);
                    } else if (count2 == 5) {
                        switchSearch(VACHE_SEARCH);
                    }
                }
            }
        });

        b2=(Button)findViewById(R.id.next);
        b2.setEnabled(false);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("");

                if(startActivity.langue==false) {
                    if (count == 5) {
                        Intent i = new Intent(niveau1_for_medecine.this, Slide_for_medecine.class);
                        i.putExtra("sound", 10);
                        onDestroy();
                        startActivity(i);
                        finish();
                    }
                    if (count == 4) {
                        img.setImageResource(R.drawable.scanner);

                        recognizer.stop();
                        count++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton5);
                        b1.setEnabled(true);
                    } else if (count == 3) {
                        img.setImageResource(R.drawable.patient);

                        recognizer.stop();
                        count++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton4);
                        b1.setEnabled(true);
                    } else if (count == 2) {
                        img.setImageResource(R.drawable.medicament);

                        recognizer.stop();
                        count++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton3);
                        b1.setEnabled(true);
                    } else if (count == 1) {
                        img.setImageResource(R.drawable.medecin);

                        recognizer.stop();
                        count++;
                        
                        b10.setEnabled(true);

                        b10.setText("Help " + jeton2);
                        b1.setEnabled(true);
                    }
                }else if(startActivity.langue==true){
                    if (count2 == 5) {
                        Intent i = new Intent(niveau1_for_medecine.this, Slide_for_medecine.class);
                        i.putExtra("sound", 10);
                        onDestroy();
                        startActivity(i);
                        finish();
                    }
                    if (count2 == 4) {
                        img.setImageResource(R.drawable.scanner);

                        recognizer.stop();
                        count2++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton5_fr);
                        b1.setEnabled(true);
                    } else if (count2 == 3) {
                        img.setImageResource(R.drawable.patient);

                        recognizer.stop();
                        count2++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton4_fr);
                        b1.setEnabled(true);
                    } else if (count2 == 2) {
                        img.setImageResource(R.drawable.medicament);

                        recognizer.stop();
                        count2++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton3_fr);
                        b1.setEnabled(true);
                    } else if (count2 == 1) {
                        img.setImageResource(R.drawable.medecin);

                        recognizer.stop();
                        count2++;
                        
                        b10.setEnabled(true);

                        b10.setText("Help " + jeton2_fr);
                        b1.setEnabled(true);
                    }
                }

            }
        });


        b10.setEnabled(false);
        aideb=(Button)findViewById(R.id.aide);
        aideb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(niveau1_for_medecine.this,enter_ip_add_chat.class);
                startActivity(i);

            }
        });

        final MediaPlayer ball = MediaPlayer.create(this,R.raw.radio);
        final MediaPlayer stadium = MediaPlayer.create(this,R.raw.doctor);
        final MediaPlayer tribune = MediaPlayer.create(this,R.raw.medicamenten);
        final MediaPlayer player = MediaPlayer.create(this,R.raw.patient);
        final MediaPlayer coach = MediaPlayer.create(this,R.raw.scanner);


        final MediaPlayer ballon = MediaPlayer.create(this,R.raw.radiofr);
        final MediaPlayer stade = MediaPlayer.create(this,R.raw.medecin);
        final MediaPlayer tribune_fr = MediaPlayer.create(this,R.raw.medicament);
        final MediaPlayer joueur = MediaPlayer.create(this,R.raw.patientfr);
        final MediaPlayer entraineur = MediaPlayer.create(this,R.raw.frscanner);


        b10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(startActivity.langue==false) {
                    if(choisir_niveaux_dif.niveaudif==0){
                    if ((jeton1 != 0) && (count == 1)) {
                        jeton1--;
                        recognizer.stop();
                        b10.setText("Help " + jeton1);
                        t1.setText("radio");
                        ball.start();
                    } else if ((jeton2 != 0) && (count == 2)) {
                        jeton2--;
                        recognizer.stop();
                        b10.setText("Help " + jeton2);
                        t1.setText("doctor");
                        stadium.start();
                    } else if ((jeton3 != 0) && (count == 3)) {
                        jeton3--;
                        recognizer.stop();
                        b10.setText("Help " + jeton3);
                        t1.setText("medicament");
                        tribune.start();
                    } else if ((jeton4 != 0) && (count == 4)) {
                        jeton4--;
                        recognizer.stop();
                        b10.setText("Help " + jeton4);
                        t1.setText("patient");
                        player.start();
                    } else if ((jeton5 != 0) && (count == 5)) {
                        jeton5--;
                        recognizer.stop();
                        b10.setText("Help " + jeton5);
                        t1.setText("scanner");
                        coach.start();
                    } else if ((jeton1 == 0) && (count == 1)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    } else if ((jeton2 == 0) && (count == 2)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    } else if ((jeton3 == 0) && (count == 3)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    } else if ((jeton4 == 0) && (count == 4)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    } else if ((jeton5 == 0) && (count == 5)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    }
                }else if(choisir_niveaux_dif.niveaudif==1){
                            if ((jeton1 != 0) && (count == 1)) {
                                jeton1--;
                                recognizer.stop();
                                b10.setText("Help " + jeton1);
                                t1.setText("radio");
                            } else if ((jeton2 != 0) && (count == 2)) {
                                jeton2--;
                                recognizer.stop();
                                b10.setText("Help " + jeton2);
                                t1.setText("doctor");

                            } else if ((jeton3 != 0) && (count == 3)) {
                                jeton3--;
                                recognizer.stop();
                                b10.setText("Help " + jeton3);
                                t1.setText("medicament");

                            } else if ((jeton4 != 0) && (count == 4)) {
                                jeton4--;
                                recognizer.stop();
                                b10.setText("Help " + jeton4);
                                t1.setText("patient");

                            } else if ((jeton5 != 0) && (count == 5)) {
                                jeton5--;
                                recognizer.stop();
                                b10.setText("Help " + jeton5);
                                t1.setText("scanner");

                            }

                    }else if(choisir_niveaux_dif.niveaudif==2){

                         b10.setEnabled(false);
                        Toast.makeText(getApplicationContext(),"no keys in dificile livel",Toast.LENGTH_SHORT).show();
                    }
                }else if(startActivity.langue){

                    if(choisir_niveaux_dif.niveaudif==0){
                    if ((jeton1_fr != 0) && (count2 == 1)) {
                        jeton1_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton1_fr);
                        t1.setText("radio");

                        ballon.start();
                    } else if ((jeton2_fr != 0) && (count2 == 2)) {
                        jeton2_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton2_fr);
                        t1.setText("médecin");
                        stade.start();
                    } else if ((jeton3_fr != 0) && (count2 == 3)) {
                        jeton3_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton3_fr);
                        t1.setText("médicament");
                        tribune_fr.start();
                    } else if ((jeton4_fr != 0) && (count2 == 4)) {
                        jeton4_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton4_fr);
                        t1.setText("patient");
                        joueur.start();
                    } else if ((jeton5_fr != 0) && (count2 == 5)) {
                        jeton5_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton5_fr);
                        t1.setText("scanner");
                        entraineur.start();
                    } else if ((jeton1_fr == 0) && (count2 == 1)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    } else if ((jeton2_fr == 0) && (count2 == 2)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    } else if ((jeton3_fr == 0) && (count2 == 3)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    } else if ((jeton4_fr == 0) && (count2 == 4)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    } else if ((jeton5_fr == 0) && (count2 == 5)) {
                         b10.setEnabled(false);
                        makeText(getApplicationContext(), "No keys", Toast.LENGTH_SHORT).show();
                    }
                }else if(choisir_niveaux_dif.niveaudif==1){
                        if ((jeton1_fr != 0) && (count2 == 1)) {
                            jeton1_fr--;
                            recognizer.stop();
                            b10.setText("Help " + jeton1_fr);
                            t1.setText("radio");

                        } else if ((jeton2_fr != 0) && (count2 == 2)) {
                            jeton2_fr--;
                            recognizer.stop();
                            b10.setText("Help " + jeton2_fr);
                            t1.setText("médecin");

                        } else if ((jeton3_fr != 0) && (count2 == 3)) {
                            jeton3_fr--;
                            recognizer.stop();
                            b10.setText("Help " + jeton3_fr);
                            t1.setText("médecament");

                        } else if ((jeton4_fr != 0) && (count2 == 4)) {
                            jeton4_fr--;
                            recognizer.stop();
                            b10.setText("Help " + jeton4_fr);
                            t1.setText("patient");

                        } else if ((jeton5_fr != 0) && (count2 == 5)) {
                            jeton5_fr--;
                            recognizer.stop();
                            b10.setText("Help " + jeton5_fr);
                            t1.setText("scanner");

                        }

                    }else if(choisir_niveaux_dif.niveaudif==2){
                         b10.setEnabled(false);
                        Toast.makeText(getApplicationContext(),"no keys in dificile livel",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        database =new My_helper(this);



    }

    private class SetupTask extends AsyncTask<Void, Void, Exception> {
        WeakReference<niveau1_for_medecine> activityReference;
        SetupTask(niveau1_for_medecine activity) {
            this.activityReference = new WeakReference<>(activity);
        }
        @Override
        protected Exception doInBackground(Void... params) {
            try {
                if(startActivity.langue==true){
                    Assets assets = new Assets(activityReference.get());
                    File assetDir = assets.syncAssets();
                    activityReference.get().setupRecognizer(assetDir);}
                else {
                    Assets assetse = new Assets(activityReference.get());
                    File assetDiree = assetse.syncAssets();
                    activityReference.get().setupRecognizere(assetDiree);}
            }catch (IOException e) {
                return e;
            }
            return null;
        }
        @Override
        protected void onPostExecute(Exception result) {
            if (result != null) {
                ((TextView) activityReference.get().findViewById(R.id.caption_text))
                        .setText("Failed to init recognizer " + result);
            } else {
                b1.setEnabled(true);
                b2.setEnabled(true);
                b10.setEnabled(true);
                b10.setText("Help "+jeton1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSIONS_REQUEST_RECORD_AUDIO) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Recognizer initialization is a time-consuming and it involves IO,
                // so we execute it in async task
                new SetupTask(this).execute();
            } else {
                finish();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (recognizer != null) {
            recognizer.cancel();
            recognizer.shutdown();
        }
    }

    /**
     * In partial result we get quick updates about current hypothesis. In
     * keyword spotting mode we can react here, in other modes we need to wait
     * for final result in onResult.
     */
    @Override
    public void onPartialResult(Hypothesis hypothesis) {

        if (startActivity.langue == false) {
            if (hypothesis == null)
                return;

            String text = hypothesis.getHypstr();
            if (count == 1) {


                if (text.equals("radiography")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }

                    recognizer.stop();

                    //  makeText(getApplicationContext(), "" +" "+ a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("radio",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();


                    Cursor c;
                    c=database.getAllDatajouer("radio");
                    c.moveToFirst();
                    TotalScore=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    //makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(CAT_SEARCH);
                }

            } else if (count == 2) {
                if (text.equals("doctor")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }


                    recognizer.stop();

                    //  makeText(getApplicationContext(), ""+"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();

                    database.updateData("doctor",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

//                img.setImageResource(R.drawable.dog_nike);
                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();
                    Cursor c;
                    c=database.getAllDatajouer("doctor");
                    c.moveToFirst();
                    TotalScore+=Integer.parseInt(c.getString(0));


                    b10.setEnabled(false);
                } else {
                    // makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(DOG_SEARCH);
                }
            } else if (count == 3) {
                if (text.equals("drench")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }


                    recognizer.stop();

                    //  makeText(getApplicationContext(), ""+"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("medicament",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();
                    Cursor c;
                    c=database.getAllDatajouer("medicament");
                    c.moveToFirst();
                    TotalScore+=Integer.parseInt(c.getString(0));



                    b10.setEnabled(false);
                } else {
                    //  makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(LION_SEARCH);
                }
            } else if (count == 4) {
                if (text.equals("patient")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }


                    recognizer.stop();

                    //  makeText(getApplicationContext(), ""+"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("patient",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("patient");
                    c.moveToFirst();
                    TotalScore+=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    //   makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(HORSE_SEARCH);
                }
            } else if (count == 5) {
                if (text.equals("scanner")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }


                    recognizer.stop();

                    // makeText(getApplicationContext(), ""+"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("scanner",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("scanner");
                    c.moveToFirst();
                    TotalScore+=Integer.parseInt(c.getString(0));

                    int scoreniveauENG=TotalScore/5;

                    database.updateDataNiv("niv1cat5",login_activite.nom,scoreniveauENG,"eng",difuculte);


                    b10.setEnabled(false);
                } else {
                    //  makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(COW_SEARCH);
                }
            }
        } else if (startActivity.langue == true) {
            if (hypothesis == null)
                return;

            String text = hypothesis.getHypstr();
            if (count2 == 1) {


                if (text.equals("radiologie")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }

                    recognizer.stop();

                    //  makeText(getApplicationContext(), "" +" "+ a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a +"  ", Toast.LENGTH_SHORT, true).show();
                    database.updateData("radio",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();


                    Cursor c;
                    c=database.getAllDatajouer("radio");
                    c.moveToFirst();
                    TotalScore2=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    //makeText(getApplicationContext(), "Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Réessayer    ", Toast.LENGTH_SHORT, true).show();
                    switchSearch(CHAT_SEARCH);
                }

            } else if (count2 == 2) {
                if (text.equals("médecin")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }


                    recognizer.stop();

                    //  makeText(getApplicationContext(), ""+"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a+"  ", Toast.LENGTH_SHORT, true).show();
                    database.updateData("doctor",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

//                img.setImageResource(R.drawable.dog_nike);
                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("doctor");
                    c.moveToFirst();
                    TotalScore2+=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    // makeText(getApplicationContext(), "Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Réessayer   ", Toast.LENGTH_SHORT, true).show();
                    switchSearch(CHIEN_SEARCH);
                }
            } else if (count2 == 3) {
                if (text.equals("médicament")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }


                    recognizer.stop();

                    //  makeText(getApplicationContext(), ""+"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a+"   ", Toast.LENGTH_SHORT, true).show();
                    database.updateData("medicament",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();


                    Cursor c;
                    c=database.getAllDatajouer("medicament");
                    c.moveToFirst();
                    TotalScore2+=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    //  makeText(getApplicationContext(), "Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Réessayer   ", Toast.LENGTH_SHORT, true).show();
                    switchSearch(LIONFR_SEARCH);
                }
            } else if (count2 == 4) {
                if (text.equals("patient")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }


                    recognizer.stop();

                    //  makeText(getApplicationContext(), ""+"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "  " + a+"   ", Toast.LENGTH_SHORT, true).show();
                    database.updateData("patient",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("patient");
                    c.moveToFirst();
                    TotalScore2+=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    //   makeText(getApplicationContext(), "Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Réessayer    ", Toast.LENGTH_SHORT, true).show();
                    switchSearch(CHEVAL_SEARCH);
                }
            } else if (count2 == 5) {
                if (text.equals("scanner")) {
                    int s = hypothesis.getBestScore();
                    double score = recognizer.getDecoder().getLogmath().exp(s) * 10;
                    double d = (double) Math.round(score * 100) / 100;
                    if (d >= 9.5) {
                        a = 10;
                    } else if (d >= 8.7 && d <= 9.49) {
                        a = 9;
                    } else if (d >= 8.5 && d <= 8.69) {
                        a = 8;
                    } else if (d >= 8.0 && d <= 8.49) {
                        a = 7;
                    } else if (d >= 7.5 && d <= 7.99) {
                        a = 6;
                    } else if (d >= 6.5 && d <= 7.49) {
                        a = 5;
                    } else if (d >= 6.0 && d <= 6.49) {
                        a = 4;
                    } else if (d >= 5.0 && d <= 5.99) {
                        a = 3;
                    } else if (d >= 3.0 && d <= 4.99) {
                        a = 2;
                    } else if (d >= 0.01 && d <= 2.99) {
                        a = 1;
                    }


                    recognizer.stop();

                    // makeText(getApplicationContext(), ""+"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "   " + a+"   ", Toast.LENGTH_SHORT, true).show();
                    database.updateData("scanner",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("scanner");
                    c.moveToFirst();
                    TotalScore2+=Integer.parseInt(c.getString(0));

                    int scoreniveauFR=TotalScore2/5;

                    database.updateDataNiv("niv1cat5",login_activite.nom,scoreniveauFR,"fr",difuculte);


                    b10.setEnabled(false);
                } else {
                    //  makeText(getApplicationContext(), "Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Réessayer   ", Toast.LENGTH_SHORT, true).show();
                    switchSearch(VACHE_SEARCH);
                }
            }
        }
    }

    /**
     * This callback is called when we stop the recognizer.
     */
    @Override
    public void onResult(Hypothesis hypothesis) {
        ((TextView) findViewById(R.id.caption_text)).setText("");
        if (hypothesis != null) {
            String text = hypothesis.getHypstr();
        }
    }

    @Override
    public void onBeginningOfSpeech() {
    }

    /**
     * We stop recognizer here to get a final result
     */
    @Override
    public void onEndOfSpeech() {

        if (startActivity.langue == false) {
            if (count == 1) {

                if (!recognizer.getSearchName().equals(CAT_SEARCH))
                    switchSearch(CAT_SEARCH);

            } else if (count == 2) {
                if (!recognizer.getSearchName().equals(DOG_SEARCH))
                    switchSearch(DOG_SEARCH);
            } else if (count == 3) {
                if (!recognizer.getSearchName().equals(LION_SEARCH))
                    switchSearch(LION_SEARCH);
            } else if (count == 4) {
                if (!recognizer.getSearchName().equals(HORSE_SEARCH))
                    switchSearch(HORSE_SEARCH);
            } else if (count == 5) {
                if (!recognizer.getSearchName().equals(COW_SEARCH))
                    switchSearch(COW_SEARCH);
            }
        } else if (startActivity.langue == true) {
            if (count2 == 1) {

                if (!recognizer.getSearchName().equals(CHAT_SEARCH))
                    switchSearch(CHAT_SEARCH);

            } else if (count2 == 2) {
                if (!recognizer.getSearchName().equals(CHIEN_SEARCH))
                    switchSearch(CHIEN_SEARCH);
            } else if (count2 == 3) {
                if (!recognizer.getSearchName().equals(LIONFR_SEARCH))
                    switchSearch(LIONFR_SEARCH);
            } else if (count2 == 4) {
                if (!recognizer.getSearchName().equals(CHEVAL_SEARCH))
                    switchSearch(CHEVAL_SEARCH);
            } else if (count2 == 5) {
                if (!recognizer.getSearchName().equals(CHEVAL_SEARCH))
                    switchSearch(CHEVAL_SEARCH);
            }
        }
    }


    private void switchSearch(String searchName) {
        ((TextView) findViewById(R.id.caption_text)).setText("");
        recognizer.stop();

        // If we are not spotting, start listening with timeout (10000 ms or 10 seconds).

        recognizer.startListening(searchName, 3000);

    }

    private void setupRecognizer(File assetsDir) throws IOException {
        recognizer = SpeechRecognizerSetup.defaultSetup()
                .setAcousticModel(new File(assetsDir, "cmusphinx-fr-ptm-8khz-5.2"))
                .setDictionary(new File(assetsDir, "fr.dict"))
                .setRawLogDir(assetsDir) // To disable logging of raw audio comment out this call (takes a lot of space on the device)
                .getRecognizer();
        recognizer.addListener(this);

        /* In your application you might not need to add all those searches.
          They are added here for demonstration. You can leave just one.
         */

        // Create grammar-based search for digit recognition
        File frGrammar = new File(assetsDir,"medecin_categorie_fr.gram");
        recognizer.addGrammarSearch(Fr_Search, frGrammar);

        File chatGrammar = new File(assetsDir,"medecin_categorie_fr.gram");
        recognizer.addGrammarSearch(CHAT_SEARCH, chatGrammar);

        File chienGrammar = new File(assetsDir,"medecin_categorie_fr.gram");
        recognizer.addGrammarSearch(CHIEN_SEARCH, chienGrammar);

        File lionGrammar = new File(assetsDir,"medecin_categorie_fr.gram");
        recognizer.addGrammarSearch(LIONFR_SEARCH, lionGrammar);

        File chevalGrammar = new File(assetsDir,"medecin_categorie_fr.gram");
        recognizer.addGrammarSearch(CHEVAL_SEARCH, chevalGrammar);

        File vacheGrammar = new File(assetsDir,"medecin_categorie_fr.gram");
        recognizer.addGrammarSearch(VACHE_SEARCH, vacheGrammar);


    }

    private void setupRecognizere(File assetsDir) throws IOException {
        // The recognizer can be configured to perform multiple searches
        // of different kind and switch between them

        recognizer = SpeechRecognizerSetup.defaultSetup()
                .setAcousticModel(new File(assetsDir, "en-us-ptm"))
                .setDictionary(new File(assetsDir, "cmudict-en-us.dict"))

                .setRawLogDir(assetsDir) // To disable logging of raw audio comment out this call (takes a lot of space on the device)

                .getRecognizer();
        recognizer.addListener(this);

        /* In your application you might not need to add all those searches.
          They are added here for demonstration. You can leave just one.
         */

        // Create grammar-based search for digit recognition
        File catGrammar = new File(assetsDir,"medecin_categorie.gram");
        recognizer.addGrammarSearch(CAT_SEARCH, catGrammar);


        File DogGrammar = new File(assetsDir,"medecin_categorie.gram");
        recognizer.addGrammarSearch(DOG_SEARCH, DogGrammar);

        File LionGrammar = new File(assetsDir,"medecin_categorie.gram");
        recognizer.addGrammarSearch(LION_SEARCH, LionGrammar);

        File HorseGrammar = new File(assetsDir,"medecin_categorie.gram");
        recognizer.addGrammarSearch(HORSE_SEARCH, HorseGrammar);

        File CowGrammar = new File(assetsDir,"medecin_categorie.gram");
        recognizer.addGrammarSearch(COW_SEARCH, CowGrammar);


    }



    @Override
    public void onError(Exception error) {
        ((TextView) findViewById(R.id.caption_text)).setText(error.getMessage());
    }

    @Override
    public void onTimeout() {

        if(startActivity.langue==true)
        ((TextView) findViewById(R.id.caption_text)).setText("Recliquer");
        else
            ((TextView) findViewById(R.id.caption_text)).setText("Click again");

    }
    @Override
    public void onBackPressed() {
        if(startActivity.langue==false){
            Intent i =new Intent(niveau1_for_medecine.this,Slide_for_medecine.class);
            onDestroy();
            startActivity(i);
            finish();


        }else if(startActivity.langue==true){
            Intent i =new Intent(niveau1_for_medecine.this,Slide_for_medecine.class);
            onDestroy();
            startActivity(i);
            finish();
        }
    }
}