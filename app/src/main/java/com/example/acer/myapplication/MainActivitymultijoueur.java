package com.example.acer.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
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
import android.widget.FrameLayout;
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
import es.dmoral.toasty.Toasty;

public class MainActivitymultijoueur extends Activity  implements RecognitionListener {

    /* Named searches allow to quickly reconfigure the decoder */
    private static final String DIGITS_SEARCH = "digits";
    /* Keyword we are looking for to activate menu */
    /* Used to handle permission request */
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    private SpeechRecognizer recognizer;
    private HashMap<String, Integer> captions;
    private  boolean b=false;
    static Button  b1,b2;
    public static int a;
    public static String  extra_number="score";
    public static int scoremulti=1;
    public FrameLayout back;

    public static int count=1 ;
    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // Prepare the data for UI
        captions = new HashMap<>();
        setContentView(R.layout.activity_mainchatmultijoueur);

        // Check if user has given permission to record audio
        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
            return;
        }
        // Recognizer initialization is a time-consuming and it involves IO,
        // so we execute it in async task
        new SetupTask(this).execute();
        //   ((TextView) findViewById(R.id.caption_text)).setText(""+sc);

        back =(FrameLayout) findViewById(R.id.container);

        if (count == 1) {
            back.setBackgroundResource(R.drawable.cat);
        } else if (count == 2) {
            back.setBackgroundResource(R.drawable.dog);
        } else if (count == 3) {
            back.setBackgroundResource(R.drawable.lion);
        } else if (count == 4) {
            back.setBackgroundResource(R.drawable.hisan);
        } else if (count == 5) {
            back.setBackgroundResource(R.drawable.bakara);

        }

        b1 =(Button)findViewById(R.id.speak);
        b1.setEnabled(false);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                switchSearch(DIGITS_SEARCH);
            }
        });

        b2=(Button)findViewById(R.id.baddal);
        b2.setEnabled(false);

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (count == 5) {
                        Intent i = new Intent(MainActivitymultijoueur.this, login_activite.class);
                        i.putExtra("sound", 10);
                        startActivity(i);
                        finish();
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);



                    }
                    if (count == 4) {
                        back.setBackgroundResource(R.drawable.bakara);
                        recognizer.stop();
                        count++;
                        b1.setEnabled(true);
                        b2.setVisibility(View.INVISIBLE);
                        ChatFragmentmultijoueur.finishButton.setVisibility(View.VISIBLE);
                        b2.setText("QUIT");
                    } else if (count == 3) {
                        back.setBackgroundResource(R.drawable.hisan);
                        recognizer.stop();
                        count++;
                        b1.setEnabled(true);
                    } else if (count == 2) {
                        back.setBackgroundResource(R.drawable.lion);
                        recognizer.stop();
                        count++;
                        b1.setEnabled(true);
                    } else if (count == 1) {
                        back.setBackgroundResource(R.drawable.dog);
                        recognizer.stop();
                        count++;
                        b1.setEnabled(true);
                    }
                }
            });


    }

    private class SetupTask extends AsyncTask<Void, Void, Exception> {
        WeakReference<MainActivitymultijoueur> activityReference;
        SetupTask(MainActivitymultijoueur activity) {
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
                b1.setEnabled(false);
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
        if (count == 1) {


            if (text.equals("cat")) {
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

                //  makeText(getApplicationContext(), "" +text+" "+ a, Toast.LENGTH_SHORT).show();
                Toasty.success(this, "" + a+"   "+text, Toast.LENGTH_SHORT, true).show();
                scoremulti=a;
                b1.setEnabled(false);


            } else {
                //makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                switchSearch(DIGITS_SEARCH);
            }

        } else if (count == 2) {
            if (text.equals("dog")) {
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

                //  makeText(getApplicationContext(), ""+text+"  " + a, Toast.LENGTH_SHORT).show();
                Toasty.success(this, "" + a+"  "+text, Toast.LENGTH_SHORT, true).show();
                scoremulti+=a;
                b1.setEnabled(false);


            } else {
                // makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                switchSearch(DIGITS_SEARCH);
            }
        } else if (count == 3) {
            if (text.equals("lion")) {
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

                //  makeText(getApplicationContext(), ""+text+"  " + a, Toast.LENGTH_SHORT).show();
                Toasty.success(this, "" + a+"  "+text, Toast.LENGTH_SHORT, true).show();
                scoremulti+=a;
                b1.setEnabled(false);

            } else {
                //  makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                switchSearch(DIGITS_SEARCH);
            }
        } else if (count == 4) {
            if (text.equals("horse")) {
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

                //  makeText(getApplicationContext(), ""+text+"  " + a, Toast.LENGTH_SHORT).show();
                Toasty.success(this, "" + a+" "+text, Toast.LENGTH_SHORT, true).show();
                scoremulti+=a;
                b1.setEnabled(false);

            } else {
                //   makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                switchSearch(DIGITS_SEARCH);
            }
        } else if (count == 5) {
            if (text.equals("cow")) {
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

                // makeText(getApplicationContext(), ""+text+"  " + a, Toast.LENGTH_SHORT).show();
                Toasty.success(this, "" +a+"  "+text, Toast.LENGTH_SHORT, true).show();
                scoremulti+=a;
                b1.setEnabled(false);



            } else {
                //  makeText(getApplicationContext(), "Try again  " + text, Toast.LENGTH_SHORT).show();
                Toasty.error(this, "Try again", Toast.LENGTH_SHORT, true).show();
                switchSearch(DIGITS_SEARCH);
            }}
    }

    /**
     * This callback is called when we stop the recognizer.
     */
    @Override
    public void onResult(Hypothesis hypothesis) {
//            ((TextView) findViewById(R.id.caption_text)).setText("");
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
        //  ((TextView) findViewById(R.id.caption_text)).setText("");
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
        File catGrammar = new File(assetsDir,"stage.gram");
        recognizer.addGrammarSearch(DIGITS_SEARCH, catGrammar);


    }

    @Override
    public void onError(Exception error) {
        ((TextView) findViewById(R.id.caption_text)).setText(error.getMessage());
    }

    @Override
    public void onTimeout() {
        if(b==true){
//                b2.setEnabled(true);
            b1.setEnabled(false);

        }else{
//                ((TextView) findViewById(R.id.caption_text)).setText("Recliquer");
        }

    }
    @Override
    public void onBackPressed() {
        Intent i =new Intent(MainActivitymultijoueur.this,login_activite.class);
        startActivity(i);
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);


    }
}

