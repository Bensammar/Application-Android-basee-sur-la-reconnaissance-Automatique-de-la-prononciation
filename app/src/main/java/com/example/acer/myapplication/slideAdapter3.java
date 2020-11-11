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

public class slideAdapter3 extends PagerAdapter {
    //  private  int[] mProgressStatus= {0};
    public static boolean x=false;
    My_helper database;
    Context context;
    LayoutInflater layoutInflater;

    public slideAdapter3(Context context) {
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


        final ImageView v;


        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layoutslide, container, false);

        if(niveauquatre.didididi==20){
            Slide3.viewPager.setCurrentItem(3);
        }


        v = (ImageView) view.findViewById(R.id.imageView);


        final ImageView imageView = (ImageView) view.findViewById(R.id.img3);

        ImageView flag = (ImageView) view.findViewById(R.id.Drap);
        final ImageView nj1 = (ImageView) view.findViewById(R.id.njoum1);
        final ImageView nj2 = (ImageView) view.findViewById(R.id.njoum2);
        final ImageView nj3 = (ImageView) view.findViewById(R.id.njoum3);
        final ImageView nj4 = (ImageView) view.findViewById(R.id.njoum4);
        final ImageView nj5 = (ImageView) view.findViewById(R.id.njoum5);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        TextView textView2 = (TextView) view.findViewById(R.id.langue);
        //      database=new My_helper(context);

        //     Cursor c= database.getAllDatajouerniv("niv1cat1");
        //     int a=c.getInt(0);


        TextView textViewSC = (TextView) view.findViewById(R.id.textViewSC);



        // TextView textView1 = (TextView) view.findViewById(R.id.textView2);

        imageView.setImageResource(img[position]);
        textView.setText(slideheadings[position]);
        // textView1.setText(description[position]);
        final ProgressBar progressBar;
        final Handler mHandler = new Handler();
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);


        final ImageView vb;

        vb = (ImageView) view.findViewById(R.id.img3);


        if (position == 0) {

            final   int[] mProgressStatus= {0};

            if(startActivity.langue==false) {
                flag.setImageResource(R.drawable.united_states);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2 = (TextView) vie.findViewById(R.id.TVcrd2);
                        TextView score3 = (TextView) vie.findViewById(R.id.TVcrd3);
                        TextView score4 = (TextView) vie.findViewById(R.id.TVcrd4);
                        TextView score5 = (TextView) vie.findViewById(R.id.TVcrd5);

                        //String sc=   database.getImagescore("cat");
                        TextView credit1 = (TextView) vie.findViewById(R.id.credit1);
                        credit1.setText("film  ");
                        TextView credit2 = (TextView) vie.findViewById(R.id.credit2);
                        credit2.setText("filmmaker  ");
                        TextView credit3 = (TextView) vie.findViewById(R.id.credit3);
                        credit3.setText("cartoons  ");
                        TextView credit4 = (TextView) vie.findViewById(R.id.credit4);
                        credit4.setText("actor  ");
                        TextView credit5 = (TextView) vie.findViewById(R.id.credit5);
                        credit5.setText("draw");

                        score.setText("" + Slide3.viewAll("film"));
                        score2.setText("" + Slide3.viewAll("filmmaker"));
                        score3.setText("" + Slide3.viewAll("cartoons"));
                        score4.setText("" + Slide3.viewAll("actor"));
                        score5.setText("" + Slide3.viewAll("draw"));

                        Button next = (Button) vie.findViewById(R.id.nextDialog);
                        Button repeat = (Button) vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a = builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(1);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i = new Intent(context, MainActivity.class);
                                MainActivity.TotalScore = 0;
                                startActivity(context, i, null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");


                        a.show();
                    }
                });
            }

            if(startActivity.langue){
                flag.setImageResource(R.drawable.french_flag);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2 = (TextView) vie.findViewById(R.id.TVcrd2);
                        TextView score3 = (TextView) vie.findViewById(R.id.TVcrd3);
                        TextView score4 = (TextView) vie.findViewById(R.id.TVcrd4);
                        TextView score5 = (TextView) vie.findViewById(R.id.TVcrd5);

                        //String sc=   database.getImagescore("cat");
                        TextView credit1 = (TextView) vie.findViewById(R.id.credit1);
                        credit1.setText("film  ");
                        TextView credit2 = (TextView) vie.findViewById(R.id.credit2);
                        credit2.setText("filmmaker  ");
                        TextView credit3 = (TextView) vie.findViewById(R.id.credit3);
                        credit3.setText("cartoons  ");
                        TextView credit4 = (TextView) vie.findViewById(R.id.credit4);
                        credit4.setText("actor  ");
                        TextView credit5 = (TextView) vie.findViewById(R.id.credit5);
                        credit5.setText("draw");

                        score.setText("" + Slide3.viewAll("film"));
                        score2.setText("" + Slide3.viewAll("filmmaker"));
                        score3.setText("" + Slide3.viewAll("cartoons"));
                        score4.setText("" + Slide3.viewAll("actor"));
                        score5.setText("" + Slide3.viewAll("draw"));

                        Button next = (Button) vie.findViewById(R.id.nextDialog);
                        Button repeat = (Button) vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a = builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(1);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i = new Intent(context, MainActivity.class);
                                MainActivity.TotalScore = 0;
                                startActivity(context, i, null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");


                        a.show();
                    }
                });
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent i=new Intent(context,niveauunart.class);
                    startActivity(context,i,null);

                }
            });
            if (startActivity.langue == false) {
                String tt = "<font color=#c93037>E</font><font color=#ffffff>N</font>";

                //  textView2.setText(Html.fromHtml(tt));
                flag.setImageResource(R.drawable.united_states);

                if (MainActivity.TotalScore != 0) {
                    int y = MainActivity.TotalScore / 5;
                    String text = String.valueOf(y);
                    //String Text = "<font color=#ffffff> Votre Score </font>";
                    //  textView.setText("Votre Score = " + MainActivity.TotalScore/5);


                }
            } else if (startActivity.langue == true) {
                String tt = "<font color=#0e4dee>F</font><font color=#c93037>R</font>";

                // textView2.setText(Html.fromHtml(tt));

                String Text2 = "<font color=#ffffff> Votre Score </font>";

                flag.setImageResource(R.drawable.french_flag);
             /*   if (MainActivity.TotalScore2 != 0) {

                    int y = MainActivity.TotalScore2 / 5;
                    String text = String.valueOf(y);
                    String Text = "<font color=#ffffff> Votre Score </font>";
                    textView.setText(Html.fromHtml(Text));
                    textViewSC.setText("          " + text);

                }*/

            }


            if (startActivity.langue == false) {
                final int scoreniv=(Integer.parseInt(Slide3.viewAll("film"))+Integer.parseInt(Slide3.viewAll("filmmaker"))+Integer.parseInt(Slide3.viewAll("cartoons"))+Integer.parseInt(Slide3.viewAll("actor"))+Integer.parseInt(Slide3.viewAll("draw")));

                if ((scoreniv > 0) && (scoreniv<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv> 0) && (scoreniv<= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv > 10) && (scoreniv<= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv > 10) && (scoreniv <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv> 20) && (scoreniv <= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv > 20) && (scoreniv <= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv> 30) && (scoreniv<= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv > 30) && (scoreniv <= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv> 40) && (scoreniv <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.ungold);

                                    if ((scoreniv >= 40) && (scoreniv <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv > 45) && (scoreniv <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }
            }




            else if (startActivity.langue == true) {
                final int scoreniv=(Integer.parseInt(Slide3.viewAll("film"))+Integer.parseInt(Slide3.viewAll("filmmaker"))+Integer.parseInt(Slide3.viewAll("cartoons"))+Integer.parseInt(Slide3.viewAll("actor"))+Integer.parseInt(Slide3.viewAll("draw")));

                if ((scoreniv > 0) && (scoreniv<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv > 0) && (scoreniv <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv > 10) && (scoreniv <= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv > 10) && (scoreniv <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv > 20) && (scoreniv<= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv > 20) && (scoreniv <= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv > 30) && (scoreniv <= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv> 30) && (scoreniv <= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv > 40) && (scoreniv <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.ungold);

                                    if ((scoreniv >= 40) && (scoreniv<= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv > 45) && (scoreniv <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }

            }
        }

        if(position==1){
            final int[] mProgressStatus= {0};
            int scoreniv=(Integer.parseInt(Slide3.viewAll("film"))+Integer.parseInt(Slide3.viewAll("filmmaker"))+Integer.parseInt(Slide3.viewAll("cartoons"))+Integer.parseInt(Slide3.viewAll("actor"))+Integer.parseInt(Slide3.viewAll("draw")));
            if(scoreniv>=25){
                imageView.setImageResource(R.drawable.deux);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(context,niveaudeuxart.class);
                        startActivity(context,i,null);
                    }
                });
            }

            if(startActivity.langue==false){
                flag.setImageResource(R.drawable.united_states);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("cinema  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("camera  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("singer  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("museum  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("musician");

                        score.setText(""+Slide3.viewAll("cinema"));
                        score2.setText(""+Slide3.viewAll("camera"));
                        score3.setText(""+Slide3.viewAll("singer"));
                        score4.setText(""+Slide3.viewAll("museum"));
                        score5.setText(""+Slide3.viewAll("musician"));

                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(2);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveaudeux.class);
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });



            }


            if(startActivity.langue==true){
                flag.setImageResource(R.drawable.french_flag);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("cinema  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("camera  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("singer  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("museum  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("musician");

                        score.setText(""+Slide3.viewAll("cinema"));
                        score2.setText(""+Slide3.viewAll("camera"));
                        score3.setText(""+Slide3.viewAll("singer"));
                        score4.setText(""+Slide3.viewAll("museum"));
                        score5.setText(""+Slide3.viewAll("musician"));

                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(2);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveaudeux.class);
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });



            }
            if (startActivity.langue == false) {
                final int scoreniv2 = (Integer.parseInt(Slide3.viewAll("cinema")) + Integer.parseInt(Slide3.viewAll("camera")) + Integer.parseInt(Slide3.viewAll("singer")) + Integer.parseInt(Slide3.viewAll("museum")) + Integer.parseInt(Slide3.viewAll("musician"))) ;

                if ((scoreniv2 > 0) && (scoreniv2<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 0) && (scoreniv2 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 10) && (scoreniv2<= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 10) && (scoreniv2 <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 20) && (scoreniv2 <= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 20) && (scoreniv2 <= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 30) && (scoreniv2<= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 30) && (scoreniv2 <= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 40) && (scoreniv2 <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.gold);

                                    if ((scoreniv2 >= 40) && (scoreniv2 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv2 > 45) && (scoreniv2 <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }
            }




            else if (startActivity.langue == true) {
                final int scoreniv2 = (Integer.parseInt(Slide3.viewAll("cinema")) + Integer.parseInt(Slide3.viewAll("camera")) + Integer.parseInt(Slide3.viewAll("singer")) + Integer.parseInt(Slide3.viewAll("museum")) + Integer.parseInt(Slide3.viewAll("draw"))) ;

                if ((scoreniv2 > 0) && (scoreniv2<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 0) && (scoreniv2 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 10) && (scoreniv2 <= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 10) && (scoreniv2 <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 20) && (scoreniv2<= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 20) && (scoreniv2<= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 30) && (scoreniv2 <= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 30) && (scoreniv2<= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 40) && (scoreniv2 <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.gold);

                                    if ((scoreniv2 >= 40) && (scoreniv2<= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv2 > 45) && (scoreniv2 <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }}
        }

        if(position==2) {
            final int[] mProgressStatus= {0};
            int scoreniv = (Integer.parseInt(Slide3.viewAll("cinema")) + Integer.parseInt(Slide3.viewAll("camera")) + Integer.parseInt(Slide3.viewAll("singer")) + Integer.parseInt(Slide3.viewAll("museum")) + Integer.parseInt(Slide3.viewAll("draw"))) / 5;
            if (scoreniv >= 5) {
                imageView.setImageResource(R.drawable.trois);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveautroisart.class);
                        startActivity(context, i, null);
                    }
                });
            }

            if(startActivity.langue==false){
                flag.setImageResource(R.drawable.united_states);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("opera  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("theater  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("modeling  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("statue  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("designer");

                        score.setText(""+Slide3.viewAll("opera"));
                        score2.setText(""+Slide3.viewAll("theater"));
                        score3.setText(""+Slide3.viewAll("modeling"));
                        score4.setText(""+Slide3.viewAll("statue"));
                        score5.setText(""+Slide3.viewAll("designer"));

                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(2);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveautrois.class);
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });



            }

            if(startActivity.langue==true){
                flag.setImageResource(R.drawable.french_flag);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("opera  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("theater  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("modeling  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("statue  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("designer");

                        score.setText(""+Slide3.viewAll("opera"));
                        score2.setText(""+Slide3.viewAll("theater"));
                        score3.setText(""+Slide3.viewAll("modeling"));
                        score4.setText(""+Slide3.viewAll("statue"));
                        score5.setText(""+Slide3.viewAll("designer"));

                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(2);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveautrois.class);
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });



            }
            if (startActivity.langue == false) {
                final int scoreniv2 = Integer.parseInt(Slide3.viewAll("opera")) + Integer.parseInt(Slide3.viewAll("theater")) + Integer.parseInt(Slide3.viewAll("modeling")) + Integer.parseInt(Slide3.viewAll("statue")) + Integer.parseInt(Slide3.viewAll("designer")) ;

                if ((scoreniv2 > 0) && (scoreniv2<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 0) && (scoreniv2 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 10) && (scoreniv2<= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 10) && (scoreniv2 <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 20) && (scoreniv2 <= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 20) && (scoreniv2 <= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 30) && (scoreniv2<= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 30) && (scoreniv2 <= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 40) && (scoreniv2 <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.troisgold);

                                    if ((scoreniv2 >= 40) && (scoreniv2 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv2 > 45) && (scoreniv2 <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }
            }




            else if (startActivity.langue == true) {
                final int scoreniv2 = Integer.parseInt(Slide3.viewAll("opera")) + Integer.parseInt(Slide3.viewAll("theater")) + Integer.parseInt(Slide3.viewAll("modeling")) + Integer.parseInt(Slide3.viewAll("statue")) + Integer.parseInt(Slide3.viewAll("designer")) ;

                if ((scoreniv2 > 0) && (scoreniv2<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 0) && (scoreniv2 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 10) && (scoreniv2 <= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 10) && (scoreniv2 <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 20) && (scoreniv2<= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 20) && (scoreniv2<= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 30) && (scoreniv2 <= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 30) && (scoreniv2<= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 40) && (scoreniv2 <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.troisgold);

                                    if ((scoreniv2 >= 40) && (scoreniv2<= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv2 > 45) && (scoreniv2 <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }}
        }

        if(position==3) {
            final int[] mProgressStatus= {0};
            int scoreniv = (Integer.parseInt(Slide3.viewAll("opera")) + Integer.parseInt(Slide3.viewAll("theater")) + Integer.parseInt(Slide3.viewAll("modeling")) + Integer.parseInt(Slide3.viewAll("statue")) + Integer.parseInt(Slide3.viewAll("designer"))) ;
            if (scoreniv >= 5) {
                imageView.setImageResource(R.drawable.quatre);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveauquatreart.class);
                        startActivity(context, i, null);
                    }
                });
            }
            if(startActivity.langue==false){
                flag.setImageResource(R.drawable.united_states);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("writer  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("violinist  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("pianist  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("guitarist  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("brush");

                        score.setText(""+Slide3.viewAll("writer"));
                        score2.setText(""+Slide3.viewAll("violinist"));
                        score3.setText(""+Slide3.viewAll("pianist"));
                        score4.setText(""+Slide3.viewAll("guitarist"));
                        score5.setText(""+Slide3.viewAll("brush"));

                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(2);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveautrois.class);
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });



            }

            if(startActivity.langue==true){
                flag.setImageResource(R.drawable.french_flag);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("writer  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("violinist  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("pianist  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("guitarist  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("brush");

                        score.setText(""+Slide3.viewAll("writer"));
                        score2.setText(""+Slide3.viewAll("violinist"));
                        score3.setText(""+Slide3.viewAll("pianist"));
                        score4.setText(""+Slide3.viewAll("guitarist"));
                        score5.setText(""+Slide3.viewAll("brush"));

                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(2);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveautrois.class);
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });



            }
            if (startActivity.langue == false) {
                final int scoreniv2 = (Integer.parseInt(Slide3.viewAll("writer")) + Integer.parseInt(Slide3.viewAll("violinist")) + Integer.parseInt(Slide3.viewAll("pianist")) + Integer.parseInt(Slide3.viewAll("guitarist")) + Integer.parseInt(Slide3.viewAll("brush")));

                if ((scoreniv2 > 0) && (scoreniv2<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 0) && (scoreniv2 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 10) && (scoreniv2<= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 10) && (scoreniv2 <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 20) && (scoreniv2 <= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 20) && (scoreniv2 <= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 30) && (scoreniv2<= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 30) && (scoreniv2 <= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 40) && (scoreniv2 <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.quatregold);

                                    if ((scoreniv2 >= 40) && (scoreniv2 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv2 > 45) && (scoreniv2 <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }
            }




            else if (startActivity.langue == true) {
                final int scoreniv2 = (Integer.parseInt(Slide3.viewAll("writer")) + Integer.parseInt(Slide3.viewAll("violinist")) + Integer.parseInt(Slide3.viewAll("pianist")) + Integer.parseInt(Slide3.viewAll("guitarist")) + Integer.parseInt(Slide3.viewAll("brush")));

                if ((scoreniv2 > 0) && (scoreniv2<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 0) && (scoreniv2 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 10) && (scoreniv2 <= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 10) && (scoreniv2 <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 20) && (scoreniv2<= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 20) && (scoreniv2<= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 30) && (scoreniv2 <= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 30) && (scoreniv2<= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 40) && (scoreniv2 <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.quatregold);

                                    if ((scoreniv2 >= 40) && (scoreniv2<= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv2 > 45) && (scoreniv2 <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }}
        }

        if(position==4) {
            final int[] mProgressStatus= {0};
            int scoreniv = (Integer.parseInt(Slide3.viewAll("writer")) + Integer.parseInt(Slide3.viewAll("violinist")) + Integer.parseInt(Slide3.viewAll("pianist")) + Integer.parseInt(Slide3.viewAll("guitarist")) + Integer.parseInt(Slide3.viewAll("brush"))) ;
            if (scoreniv >= 5) {
                imageView.setImageResource(R.drawable.niveaucinq);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveaucinqart.class);
                        startActivity(context, i, null);
                    }
                });
            }
            if(startActivity.langue==false){
                flag.setImageResource(R.drawable.united_states);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("guitar  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("violin  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("piano  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("drums  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("trumpet");

                        score.setText(""+Slide3.viewAll("guitar"));
                        score2.setText(""+Slide3.viewAll("violin"));
                        score3.setText(""+Slide3.viewAll("piano"));
                        score4.setText(""+Slide3.viewAll("drums"));
                        score5.setText(""+Slide3.viewAll("trumpet"));

                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(2);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveautrois.class);
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'applifilmion de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });



            }

            if(startActivity.langue==true){
                flag.setImageResource(R.drawable.french_flag);
                flag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View vie = LayoutInflater.from(context).inflate(R.layout.dialog_syllabus, null);

                        TextView title = (TextView) vie.findViewById(R.id.title);
                        TextView desc = (TextView) vie.findViewById(R.id.TVdesc);
                        TextView score = (TextView) vie.findViewById(R.id.TVcrd);
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("guitar  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("violin  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("piano  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("drums  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("trumpet");

                        score.setText(""+Slide3.viewAll("guitar"));
                        score2.setText(""+Slide3.viewAll("violin"));
                        score3.setText(""+Slide3.viewAll("piano"));
                        score4.setText(""+Slide3.viewAll("drums"));
                        score5.setText(""+Slide3.viewAll("trumpet"));

                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide3.viewPager.setCurrentItem(2);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveautrois.class);
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'applifilmion de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });



            }
            if (startActivity.langue == false) {

                final int scoreniv2 = (Integer.parseInt(Slide3.viewAll("guitar")) + Integer.parseInt(Slide3.viewAll("violin")) + Integer.parseInt(Slide3.viewAll("piano")) + Integer.parseInt(Slide3.viewAll("drums")) + Integer.parseInt(Slide3.viewAll("trumpet")));

                if ((scoreniv2 > 0) && (scoreniv2<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 0) && (scoreniv2 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 10) && (scoreniv2<= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 10) && (scoreniv2 <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 20) && (scoreniv2 <= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 20) && (scoreniv2 <= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 30) && (scoreniv2<= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 30) && (scoreniv2 <= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2> 40) && (scoreniv2 <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.cinqgold);

                                    if ((scoreniv2 >= 40) && (scoreniv2 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv2 > 45) && (scoreniv2 <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }
            }




            else if (startActivity.langue == true) {
                final int scoreniv2 = (Integer.parseInt(Slide3.viewAll("guitar")) + Integer.parseInt(Slide3.viewAll("violin")) + Integer.parseInt(Slide3.viewAll("piano")) + Integer.parseInt(Slide3.viewAll("drums")) + Integer.parseInt(Slide3.viewAll("trumpet")));

                if ((scoreniv2 > 0) && (scoreniv2<= 10)) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 20) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 0) && (scoreniv2 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 10) && (scoreniv2 <= 20)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 40) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 10) && (scoreniv2 <= 15)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star_half);

                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 20) && (scoreniv2<= 30)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 60) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 20) && (scoreniv2<= 25)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 30) && (scoreniv2 <= 40)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 80) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if ((scoreniv2 > 30) && (scoreniv2<= 35)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star_half);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv2 > 40) && (scoreniv2 <= 50)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (mProgressStatus[0] < 100) {
                                mProgressStatus[0]++;
                                SystemClock.sleep(40);
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(mProgressStatus[0]);
                                    }
                                });
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.cinqgold);

                                    if ((scoreniv2 >= 40) && (scoreniv2<= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv2 > 45) && (scoreniv2 <= 47)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star_half);
                                    } else {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                        nj5.setImageResource(R.drawable.star);
                                    }
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;

                    x = true;
                }}
        }


        container.addView(view);

        return view;

    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }



}
