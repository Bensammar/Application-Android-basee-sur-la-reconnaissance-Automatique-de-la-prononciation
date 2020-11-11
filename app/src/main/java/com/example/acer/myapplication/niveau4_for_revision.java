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

public class niveau4_for_revision extends Activity implements RecognitionListener {

    /* Named searches allow to quickly reconfigure the decoder */
    public  My_helper database;
    private static final String SHEEP_SEARCH = "sheeps";
    private static final String Fr_Search = "frs";
    private static final String MONKEY_SEARCH = "monkeys";
    private static final String TIGER_SEARCH = "tigers";
    private static final String PANDA_SEARCH = "pandas";
    private static final String GAZELLE_SEARCH = "gazelles";

    private static final String MOUTON_SEARCH = "moutons";
    private static final String SINGE_SEARCH = "dogs";
    private static final String TIGERFR_SEARCH = "tigers";
    private static final String PANDAFR_SEARCH = "pandass";
    private static final String GAZELLEFR_SEARCH = "gazelles";
    public static final String mm="sound";
    /* Keyword we are looking for to activate menu */
    /* Used to handle permission request */
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    private SpeechRecognizer recognizer;
    private HashMap<String, Integer> captions;
    private  boolean b=false;
    Button b1,b2,b10,b3;
    public static int a;
    public static String  extra_number="score";
    public static int jeton1=3;
    public static int jeton2=3;
    public static int jeton3=3;
    public static int jeton4=3;
    public static int jeton5=3;

    public static int jeton1_fr=3;
    public static   int jeton2_fr=3;
    public static int jeton3_fr=3;
    public static int jeton4_fr=3;
    public static int jeton5_fr=3;
    Button aideb;
    public  CircleImageView img;
    public boolean x=false;
    public  int count=1;
    public  int count2=1;
    public static int TotalScore=0;
    public static int TotalScore2=0;
    public String nom,password;
    public String difuculte;


    public static int didididi;


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


        if(startActivity.langue==false) {

            if (count == 1) {
                img.setImageResource(R.drawable.bread);
            } else if (count == 2) {
                img.setImageResource(R.drawable.carotte);
            } else if (count == 3) {
                img.setImageResource(R.drawable.oranges);
            } else if (count == 4) {
                img.setImageResource(R.drawable.pizza);
            } else if (count == 5) {
                img.setImageResource(R.drawable.lait);
            }
        }
        if(startActivity.langue==true) {
            if (count2 == 1) {
                img.setImageResource(R.drawable.bread);
            } else if (count2 == 2) {
                img.setImageResource(R.drawable.carotte);
            } else if (count2 == 3) {
                img.setImageResource(R.drawable.orange);
            } else if (count2 == 4) {
                img.setImageResource(R.drawable.pizza);
            } else if (count2 == 5) {
                img.setImageResource(R.drawable.lait);
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
                        switchSearch(SHEEP_SEARCH);
                    } else if (count == 2) {
                        switchSearch(MONKEY_SEARCH);
                    } else if (count == 3) {
                        switchSearch(TIGER_SEARCH);
                    } else if (count == 4) {
                        switchSearch(PANDA_SEARCH);
                    } else if (count == 5) {
                        switchSearch(GAZELLE_SEARCH);
                    }
                }else if(startActivity.langue==true){
                    if (count2 == 1) {
                        switchSearch(MOUTON_SEARCH);
                    } else if (count2 == 2) {
                        switchSearch(SINGE_SEARCH);
                    } else if (count2 == 3) {
                        switchSearch(TIGERFR_SEARCH);
                    } else if (count2 == 4) {
                        switchSearch(PANDAFR_SEARCH);
                    } else if (count2 == 5) {
                        switchSearch(GAZELLEFR_SEARCH);
                    }
                }
            }
        });

        b2=(Button)findViewById(R.id.next);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(startActivity.langue==false) {
                    if (count == 5) {
                        Intent i = new Intent(niveau4_for_revision.this, Slide_for_revision.class);




                        onDestroy();
                        startActivity(i);
                        finish();
                    }
                    if (count == 4) {
                        img.setImageResource(R.drawable.lait);
                        recognizer.stop();
                        count++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton5);
                        b1.setEnabled(true);
                    } else if (count == 3) {
                        img.setImageResource(R.drawable.pizza);
                        recognizer.stop();
                        count++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton4);
                        b1.setEnabled(true);
                    } else if (count == 2) {
                        img.setImageResource(R.drawable.orange);
                        recognizer.stop();
                        count++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton3);
                        b1.setEnabled(true);
                    } else if (count == 1) {
                        img.setImageResource(R.drawable.carotte);
                        recognizer.stop();
                        count++;
                        
                        b10.setEnabled(true);

                        b10.setText("Help " + jeton2);
                        b1.setEnabled(true);
                    }
                }else if(startActivity.langue==true){
                    if (count2 == 5) {
                        Intent i = new Intent(niveau4_for_revision.this, Slide_for_revision.class);
                        i.putExtra("sound", 10);
                        onDestroy();
                        startActivity(i);
                        finish();
                    }
                    if (count2 == 4) {
                        img.setImageResource(R.drawable.lait);
                        recognizer.stop();
                        count2++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton5_fr);
                        b1.setEnabled(true);
                    } else if (count2 == 3) {
                        img.setImageResource(R.drawable.pizza);
                        recognizer.stop();
                        count2++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton4_fr);
                        b1.setEnabled(true);
                    } else if (count2 == 2) {
                        img.setImageResource(R.drawable.orange);
                        recognizer.stop();
                        count2++;
                        
                        b10.setEnabled(true);
                        b10.setText("Help " + jeton3_fr);
                        b1.setEnabled(true);
                    } else if (count2 == 1) {
                        img.setImageResource(R.drawable.carotte);
                        recognizer.stop();
                        count2++;
                        
                        b10.setEnabled(true);

                        b10.setText("Help " + jeton2_fr);
                        b1.setEnabled(true);
                    }
                }

            }
        });


        b10=(Button)findViewById(R.id.help);
        b10.setEnabled(false);
        aideb=(Button)findViewById(R.id.aide);
        aideb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(niveau4_for_revision.this,enter_ip_add_chat.class);
                startActivity(i);

            }
        });
        final MediaPlayer donkey = MediaPlayer.create(this,R.raw.bread);
        final MediaPlayer fox = MediaPlayer.create(this,R.raw.carrot);
        final MediaPlayer kitchen = MediaPlayer.create(this,R.raw.orange);
        final MediaPlayer snake = MediaPlayer.create(this,R.raw.pizza);
        final MediaPlayer zebra = MediaPlayer.create(this,R.raw.milk);


        final MediaPlayer donkey_fr = MediaPlayer.create(this,R.raw.pain);
        final MediaPlayer fox_fr = MediaPlayer.create(this,R.raw.carotte);
        final MediaPlayer kitchen_fr = MediaPlayer.create(this,R.raw.orangefr);
        final MediaPlayer snake_fr = MediaPlayer.create(this,R.raw.pizzafr);
        final MediaPlayer zebra_fr = MediaPlayer.create(this,R.raw.lait);



        b10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(startActivity.langue==false) {


                    if ((jeton1 != 0) && (count == 1)) {
                        jeton1--;
                        recognizer.stop();
                        b10.setText("Help " + jeton1);
                        donkey.start();
                    } else if ((jeton2 != 0) && (count == 2)) {
                        jeton2--;
                        recognizer.stop();
                        b10.setText("Help " + jeton2);
                        fox.start();
                    } else if ((jeton3 != 0) && (count == 3)) {
                        jeton3--;
                        recognizer.stop();
                        b10.setText("Help " + jeton3);
                        kitchen.start();
                    } else if ((jeton4 != 0) && (count == 4)) {
                        jeton4--;
                        recognizer.stop();
                        b10.setText("Help " + jeton4);
                        snake.start();
                    } else if ((jeton5 != 0) && (count == 5)) {
                        jeton5--;
                        recognizer.stop();
                        b10.setText("Help " + jeton5);
                        zebra.start();
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
                }else if(startActivity.langue==true) {

                    if ((jeton1_fr != 0) && (count2 == 1)) {
                        jeton1_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton1_fr);
                        donkey_fr.start();
                    } else if ((jeton2_fr != 0) && (count2 == 2)) {
                        jeton2_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton2_fr);
                        fox_fr.start();
                    } else if ((jeton3_fr != 0) && (count2 == 3)) {
                        jeton3_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton3_fr);
                        kitchen_fr.start();
                    } else if ((jeton4_fr != 0) && (count2 == 4)) {
                        jeton4_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton4_fr);
                        snake_fr.start();
                    } else if ((jeton5_fr != 0) && (count2 == 5)) {
                        jeton5_fr--;
                        recognizer.stop();
                        b10.setText("Help " + jeton5_fr);
                        zebra_fr.start();
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
                }
            }
        });
        database =new My_helper(this);



    }

    private class SetupTask extends AsyncTask<Void, Void, Exception> {
        WeakReference<niveau4_for_revision> activityReference;
        SetupTask(niveau4_for_revision activity) {
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


                if (text.equals("bread")) {
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

                    //  makeText(getApplicationContext(), ""  +" "+ a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("bread",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("bread");
                    c.moveToFirst();
                    TotalScore=Integer.parseInt(c.getString(0));


                    b10.setEnabled(false);
                } else {
                    //makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(SHEEP_SEARCH);
                }

            } else if (count == 2) {
                if (text.equals("carrot")) {
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

                    //  makeText(getApplicationContext(), "" +"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("carrot",login_activite.nom,a,"eng",difuculte);
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
                    c=database.getAllDatajouer("carrot");
                    c.moveToFirst();
                    TotalScore+=Integer.parseInt(c.getString(0));


                    b10.setEnabled(false);
                } else {
                    // makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(MONKEY_SEARCH);
                }
            } else if (count == 3) {
                if (text.equals("orange")) {
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

                    //  makeText(getApplicationContext(), "" +"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("orange",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();


                    Cursor c;
                    c=database.getAllDatajouer("orange");
                    c.moveToFirst();
                    TotalScore+=Integer.parseInt(c.getString(0));


                    b10.setEnabled(false);
                } else {
                    //  makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(TIGER_SEARCH);
                }
            } else if (count == 4) {
                if (text.equals("pizza")) {
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

                    //  makeText(getApplicationContext(), "" +"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("pizza",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("pizza");
                    c.moveToFirst();
                    TotalScore+=Integer.parseInt(c.getString(0));


                    b10.setEnabled(false);
                } else {
                    //   makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(PANDA_SEARCH);
                }
            } else if (count == 5) {
                if (text.equals("milk")) {
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

                    // makeText(getApplicationContext(), "" +"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a, Toast.LENGTH_SHORT, true).show();
                    database.updateData("milk",login_activite.nom,a,"eng",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("milk");
                    c.moveToFirst();
                    TotalScore+=Integer.parseInt(c.getString(0));

                    int Scoreniv2ENG=TotalScore/5;
                    database.updateDataNiv("niv4cat10",login_activite.nom,Scoreniv2ENG,"eng",difuculte);


                    b10.setEnabled(false);
                } else {
                    //  makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                    switchSearch(GAZELLE_SEARCH);
                }
            }
        } else if (startActivity.langue == true) {
            if (hypothesis == null)
                return;

            String text = hypothesis.getHypstr();
            if (count2 == 1) {


                if (text.equals("pain")) {
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

                    //  makeText(getApplicationContext(), ""  +" "+ a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a +"  " , Toast.LENGTH_SHORT, true).show();
                    database.updateData("bread",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();


                    Cursor c;
                    c=database.getAllDatajouer("bread");
                    c.moveToFirst();
                    TotalScore2=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    //makeText(getApplicationContext(), " Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, " Réessayer    " , Toast.LENGTH_SHORT, true).show();
                    switchSearch(MOUTON_SEARCH);
                }

            } else if (count2 == 2) {
                if (text.equals("carotte")) {
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

                    //  makeText(getApplicationContext(), "" +"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a+"  " , Toast.LENGTH_SHORT, true).show();
                    database.updateData("carrot",login_activite.nom,a,"fr",difuculte);
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
                    c=database.getAllDatajouer("carrot");
                    c.moveToFirst();
                    TotalScore2+=Integer.parseInt(c.getString(0));


                    b10.setEnabled(false);
                } else {
                    // makeText(getApplicationContext(), " Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, " Réessayer   " , Toast.LENGTH_SHORT, true).show();
                    switchSearch(SINGE_SEARCH);
                }
            } else if (count2 == 3) {
                if (text.equals("orange")) {
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

                    //  makeText(getApplicationContext(), "" +"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "" + a+"   " , Toast.LENGTH_SHORT, true).show();
                    database.updateData("orange",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();


                    Cursor c;
                    c=database.getAllDatajouer("orange");
                    c.moveToFirst();
                    TotalScore2+=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    //  makeText(getApplicationContext(), " Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, " Réessayer   " , Toast.LENGTH_SHORT, true).show();
                    switchSearch(TIGERFR_SEARCH);
                }
            } else if (count2 == 4) {
                if (text.equals("pizza")) {
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

                    //  makeText(getApplicationContext(), "" +"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "  " + a+"   " , Toast.LENGTH_SHORT, true).show();
                    database.updateData("pizza",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("pizza");
                    c.moveToFirst();
                    TotalScore2+=Integer.parseInt(c.getString(0));

                    b10.setEnabled(false);
                } else {
                    //   makeText(getApplicationContext(), " Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, " Réessayer    " , Toast.LENGTH_SHORT, true).show();
                    switchSearch(PANDAFR_SEARCH);
                }
            } else if (count2 == 5) {
                if (text.equals("lait")) {
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

                    // makeText(getApplicationContext(), "" +"  " + a, Toast.LENGTH_SHORT).show();
                    Toasty.success(this, "   " + a+"   " , Toast.LENGTH_SHORT, true).show();
                    database.updateData("milk",login_activite.nom,a,"fr",difuculte);
                    b1.setEnabled(false);

                    ObjectAnimator o = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    o.setDuration(1000);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o);
                    animatorSet.start();

                    final MediaPlayer sound = MediaPlayer.create(this, R.raw.touchid_success);
                    sound.start();

                    Cursor c;
                    c=database.getAllDatajouer("milk");
                    c.moveToFirst();
                    TotalScore2+=Integer.parseInt(c.getString(0));

                    int scoreniveau2FR=TotalScore2/5;

                    database.updateDataNiv("niv4cat10",login_activite.nom,scoreniveau2FR,"fr",difuculte);

                    b10.setEnabled(false);
                } else {
                    //  makeText(getApplicationContext(), " Réessayer  " + text, Toast.LENGTH_SHORT).show();
                    Toasty.error(this, " Réessayer   " , Toast.LENGTH_SHORT, true).show();
                    switchSearch(GAZELLEFR_SEARCH);
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

                if (!recognizer.getSearchName().equals(SHEEP_SEARCH))
                    switchSearch(SHEEP_SEARCH);

            } else if (count == 2) {
                if (!recognizer.getSearchName().equals(MONKEY_SEARCH))
                    switchSearch(MONKEY_SEARCH);
            } else if (count == 3) {
                if (!recognizer.getSearchName().equals(TIGER_SEARCH))
                    switchSearch(TIGER_SEARCH);
            } else if (count == 4) {
                if (!recognizer.getSearchName().equals(PANDA_SEARCH))
                    switchSearch(PANDA_SEARCH);
            } else if (count == 5) {
                if (!recognizer.getSearchName().equals(GAZELLE_SEARCH))
                    switchSearch(GAZELLE_SEARCH);
            }
        } else if (startActivity.langue == true) {
            if (count2 == 1) {

                if (!recognizer.getSearchName().equals(MOUTON_SEARCH))
                    switchSearch(MOUTON_SEARCH);

            } else if (count2 == 2) {
                if (!recognizer.getSearchName().equals(SINGE_SEARCH))
                    switchSearch(SINGE_SEARCH);
            } else if (count2 == 3) {
                if (!recognizer.getSearchName().equals(TIGERFR_SEARCH))
                    switchSearch(TIGERFR_SEARCH);
            } else if (count2 == 4) {
                if (!recognizer.getSearchName().equals(PANDAFR_SEARCH))
                    switchSearch(PANDAFR_SEARCH);
            } else if (count2 == 5) {
                if (!recognizer.getSearchName().equals(PANDAFR_SEARCH))
                    switchSearch(PANDAFR_SEARCH);
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
        File frGrammar = new File(assetsDir,"niveau_un_nour_fr.gram");
        recognizer.addGrammarSearch(Fr_Search, frGrammar);

        File moutonGrammar = new File(assetsDir,"niveau_un_nour_fr.gram");
        recognizer.addGrammarSearch(MOUTON_SEARCH, moutonGrammar);

        File singeGrammar = new File(assetsDir,"niveau_un_nour_fr.gram");
        recognizer.addGrammarSearch(SINGE_SEARCH, singeGrammar);

        File tigerGrammar = new File(assetsDir,"niveau_un_nour_fr.gram");
        recognizer.addGrammarSearch(TIGERFR_SEARCH, tigerGrammar);

        File chevalGrammar = new File(assetsDir,"niveau_un_nour_fr.gram");
        recognizer.addGrammarSearch(PANDAFR_SEARCH, chevalGrammar);

        File gazelleGrammar = new File(assetsDir,"niveau_un_nour_fr.gram");
        recognizer.addGrammarSearch(GAZELLEFR_SEARCH, gazelleGrammar);


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
        File sheepGrammar = new File(assetsDir,"niveau_un_nour.gram");
        recognizer.addGrammarSearch(SHEEP_SEARCH, sheepGrammar);


        File monkeyGrammar = new File(assetsDir,"niveau_un_nour.gram");
        recognizer.addGrammarSearch(MONKEY_SEARCH, monkeyGrammar);

        File tigerGrammar = new File(assetsDir,"niveau_un_nour.gram");
        recognizer.addGrammarSearch(TIGER_SEARCH, tigerGrammar);

        File pandaGrammar = new File(assetsDir,"niveau_un_nour.gram");
        recognizer.addGrammarSearch(PANDA_SEARCH, pandaGrammar);

        File gazelleGrammar = new File(assetsDir,"niveau_un_nour.gram");
        recognizer.addGrammarSearch(GAZELLE_SEARCH, gazelleGrammar);


    }



    @Override
    public void onError(Exception error) {
        ((TextView) findViewById(R.id.caption_text)).setText(error.getMessage());
    }

    @Override
    public void onTimeout() {
        if(startActivity.langue==true) {
            ((TextView) findViewById(R.id.caption_text)).setText("Recliquer");
        }else
            ((TextView) findViewById(R.id.caption_text)).setText("Click Again");
    }
    @Override
    public void onBackPressed() {
        if(startActivity.langue==false){
            Intent i =new Intent(niveau4_for_revision.this,Slide_for_revision.class);
            onDestroy();
            startActivity(i);
            finish();


        }else if(startActivity.langue==true){
            Intent i =new Intent(niveau4_for_revision.this,Slide_for_revision.class);
            onDestroy();
            startActivity(i);
            finish();
        }
    }
}