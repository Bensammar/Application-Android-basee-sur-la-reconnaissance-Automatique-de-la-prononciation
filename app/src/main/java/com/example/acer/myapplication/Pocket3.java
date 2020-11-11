package com.example.acer.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
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

import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.RecognitionListener;
import edu.cmu.pocketsphinx.SpeechRecognizer;
import edu.cmu.pocketsphinx.SpeechRecognizerSetup;

import static android.widget.Toast.makeText;

public class Pocket3 extends Activity implements RecognitionListener {

    /* Named searches allow to quickly reconfigure the decoder */
    private static final String DIGITS_SEARCH = "digits";
    /* Keyword we are looking for to activate menu */
    /* Used to handle permission request */
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    private SpeechRecognizer recognizer;
    private HashMap<String, Integer> captions;
    private  boolean b=false;
    Button b1,b2,b3;
    public static String valeur="valeur";
    public static String extra_number3="sc";
    public static int p3;
    public static int a;
    public static int som2;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // Prepare the data for UI
        captions = new HashMap<>();
        setContentView(R.layout.pocket3);

        // Check if user has given permission to record audio
        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
            return;
        }
        // Recognizer initialization is a time-consuming and it involves IO,
        // so we execute it in async task
        new SetupTask(this).execute();

        Intent intent=getIntent();
        p3=intent.getIntExtra(Pocket2.extra_number2,0);
        ((TextView) findViewById(R.id.caption_text)).setText(""+p3);
        b1 =(Button)findViewById(R.id.speak3);
        b1.setEnabled(false);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
               switchSearch(DIGITS_SEARCH);
            }
        });

        b2 =(Button)findViewById(R.id.next);
        b2.setEnabled(false);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Pocket3.this,Pocket4.class);
                i.putExtra(extra_number3,p3+a);
                onDestroy();
                startActivity(i);
                finish();
            }
        });

        b3 =(Button)findViewById(R.id.prev);
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Pocket3.this,Pocket2.class);
                startActivity(i);
            }
        });


    }

    private class SetupTask extends AsyncTask<Void, Void, Exception> {
        WeakReference<Pocket3> activityReference;
        SetupTask(Pocket3 activity) {
            this.activityReference = new WeakReference<>(activity);
        }
        @Override
        protected Exception doInBackground(Void... params) {
            try {
                Assets assets = new Assets(activityReference.get());
                File assetDir = assets.syncAssets();
                activityReference.get().setupRecognizer(assetDir);
            } catch (IOException e) {
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
        if (hypothesis == null)
            return;


        String text = hypothesis.getHypstr();
        if(text.equals("lion")){
            int s=recognizer.getDecoder().hyp().getBestScore();
            double score =  recognizer.getDecoder().getLogmath().exp(s)*10;
            double d = (double) Math.round(score*100)/100;
            if(d>=9.5){
                a=10;
            }else if(d>=8.7 && d<=9.49){
                a=9;
            }else if(d>=8.5 && d<=8.69){
                a=8;
            }else if(d>=8.0 && d<=8.49){
                a=7;
            }else if(d>=7.5 && d<=7.99){
                a=6;
            }else if(d>=6.5 && d<=7.49){
                a=5;
            }else if(d>=6.0 && d<=6.49){
                a=4;
            }else if(d>=5.0 && d<=5.99){
                a=3;
            }else if(d>=3.0 && d<=4.99){
                a=2;
            }else if(d>=0.01 && d<=2.99){
                a=1;
            }

            som2=p3+a;

            b=true;
            recognizer.stop();
            onTimeout();
            makeText(getApplicationContext(), ""+a, Toast.LENGTH_SHORT).show();

        }else {
            makeText(getApplicationContext(), "Try again", Toast.LENGTH_SHORT).show();
            switchSearch(DIGITS_SEARCH);
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


            //
            // makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            //((TextView) findViewById(R.id.caption_text)).setText(text);
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
        if (!recognizer.getSearchName().equals(DIGITS_SEARCH))
            switchSearch(DIGITS_SEARCH);
    }


    private void switchSearch(String searchName) {
        ((TextView) findViewById(R.id.caption_text)).setText("");
        recognizer.stop();

        // If we are not spotting, start listening with timeout (10000 ms or 10 seconds).

        recognizer.startListening(searchName, 3000);

    }

    private void setupRecognizer(File assetsDir) throws IOException {
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
        File lionGrammar = new File(assetsDir,"lion.gram");
        recognizer.addGrammarSearch(DIGITS_SEARCH, lionGrammar);


    }

    @Override
    public void onError(Exception error) {
        ((TextView) findViewById(R.id.caption_text)).setText(error.getMessage());
    }

    @Override
    public void onTimeout() {
        if(b==true){
            b2.setEnabled(true);
            b1.setEnabled(false);

        }else{
            ((TextView) findViewById(R.id.caption_text)).setText("Recliquer");
        }

    }

    @Override
    public void onBackPressed() {
        Intent i =new Intent(Pocket3.this,Slide.class);
        onDestroy();
        startActivity(i);
        finish();

    }
}
