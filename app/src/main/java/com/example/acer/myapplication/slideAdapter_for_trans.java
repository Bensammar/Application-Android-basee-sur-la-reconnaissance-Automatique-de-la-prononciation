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

public class slideAdapter_for_trans extends PagerAdapter {

    ProgressBar progressBar;
    private Handler mHandler = new Handler();
    final static String ex2="moncef";
    public static int go2;
    public static boolean x=false;
    My_helper database;



    Context context;
    LayoutInflater layoutInflater;

    public slideAdapter_for_trans(Context context) {
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
            Slide.viewPager.setCurrentItem(3);
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

        int affichage;
        int affichage2;
        affichage = Pocket5.total / 5;
        affichage2 = sheep.som / 2;

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
            final int[] mProgressStatus= {0};

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent i=new Intent(context,niveau1_for_trans.class);
                    startActivity(context,i,null);

                }
            });

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
                        score.setText("" + Slide_for_trans.getscoreimage("car"));
                        score2.setText("" + Slide_for_trans.getscoreimage("bus"));
                        score3.setText("" + Slide_for_trans.getscoreimage("train"));
                        score4.setText("" + Slide_for_trans.getscoreimage("boat"));
                        score5.setText("" + Slide_for_trans.getscoreimage("airplane"));

                        TextView credit1 = (TextView) vie.findViewById(R.id.credit1);
                        credit1.setText("car  ");
                        TextView credit2 = (TextView) vie.findViewById(R.id.credit2);
                        credit2.setText("bus  ");
                        TextView credit3 = (TextView) vie.findViewById(R.id.credit3);
                        credit3.setText("train ");
                        TextView credit4 = (TextView) vie.findViewById(R.id.credit4);
                        credit4.setText("boat ");
                        TextView credit5 = (TextView) vie.findViewById(R.id.credit5);
                        credit5.setText("airplane");


                        Button next = (Button) vie.findViewById(R.id.nextDialog);
                        Button repeat = (Button) vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a = builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_trans.viewPager.setCurrentItem(1);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i = new Intent(context, niveau1_for_trans.class);
                                MainActivity.TotalScore = 0;
                                startActivity(context, i, null);
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
                        TextView score2 = (TextView) vie.findViewById(R.id.TVcrd2);
                        TextView score3 = (TextView) vie.findViewById(R.id.TVcrd3);
                        TextView score4 = (TextView) vie.findViewById(R.id.TVcrd4);
                        TextView score5 = (TextView) vie.findViewById(R.id.TVcrd5);

                        //String sc=   database.getImagescore("cat");
                        score.setText("" + Slide_for_trans.getscoreimage("ball"));
                        score2.setText("" + Slide_for_trans.getscoreimage("stadium"));
                        score3.setText("" + Slide_for_trans.getscoreimage("tribune"));
                        score4.setText("" + Slide_for_trans.getscoreimage("player"));
                        score5.setText("" + Slide_for_trans.getscoreimage("coach"));

                        TextView credit1 = (TextView) vie.findViewById(R.id.credit1);
                        credit1.setText("voiture  ");
                        TextView credit2 = (TextView) vie.findViewById(R.id.credit2);
                        credit2.setText("bus  ");
                        TextView credit3 = (TextView) vie.findViewById(R.id.credit3);
                        credit3.setText("train  ");
                        TextView credit4 = (TextView) vie.findViewById(R.id.credit4);
                        credit4.setText("bateau  ");
                        TextView credit5 = (TextView) vie.findViewById(R.id.credit5);
                        credit5.setText("avion");


                        Button next = (Button) vie.findViewById(R.id.nextDialog);
                        Button repeat = (Button) vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a = builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_trans.viewPager.setCurrentItem(1);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i = new Intent(context, niveau1_for_trans.class);
                                MainActivity.TotalScore = 0;
                                startActivity(context, i, null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");


                        a.show();
                    }
                });

            }




            if (startActivity.langue == false) {
                final int scoreniv=(Slide_for_trans.getscoreimage("car")+Slide_for_trans.getscoreimage("bus")+Slide_for_trans.getscoreimage("train")+Slide_for_trans.getscoreimage("boat")+Slide_for_trans.getscoreimage("airplane"));

                if ((scoreniv > 0) && (scoreniv <= 10)) {

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
                } else if ((scoreniv > 20) && (scoreniv <= 30)) {
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
                final int scoreniv=(Slide_for_trans.getscoreimage("car")+Slide_for_trans.getscoreimage("bus")+Slide_for_trans.getscoreimage("train")+Slide_for_trans.getscoreimage("boat")+Slide_for_trans.getscoreimage("airplane"));

                if ((scoreniv > 0) && (scoreniv <= 10)) {

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
                } else if ((scoreniv > 20) && (scoreniv <= 30)) {
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









        }


        if(position==1){
            final int[] mProgressStatus= {0};

       int scoreniv=(Slide_for_trans.getscoreimage("car")+Slide_for_trans.getscoreimage("bus")+Slide_for_trans.getscoreimage("train")+Slide_for_trans.getscoreimage("boat")+Slide_for_trans.getscoreimage("airplane"));

       if(scoreniv>=5){
           imageView.setImageResource(R.drawable.deux);

           imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i=new Intent(context,niveau2_for_trans.class);
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
                   credit1.setText("bike  ");
                   TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                   credit2.setText("motorbike  ");
                   TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                   credit3.setText("streetcar  ");
                   TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                   credit4.setText("airport  ");
                   TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                   credit5.setText("truck");

                   score.setText(""+Slide_for_trans.viewAll("bike"));
                   score2.setText(""+Slide_for_trans.viewAll("moto"));
                   score3.setText(""+Slide_for_trans.viewAll("tramway"));
                   score4.setText(""+Slide_for_trans.viewAll("airport"));
                   score5.setText(""+Slide_for_trans.viewAll("truck"));

                   Button next=(Button)vie.findViewById(R.id.nextDialog);
                   Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                   builder.setView(vie);
                   final AlertDialog a=builder.create();
                   a.show();

                   next.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Slide_for_trans.viewPager.setCurrentItem(2);
                           a.cancel();
                       }
                   });

                   repeat.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent i=new Intent(context,niveau2_for_trans.class);
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
                   credit1.setText("velo  ");
                   TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                   credit2.setText("moto  ");
                   TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                   credit3.setText("tramway  ");
                   TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                   credit4.setText("aeroport  ");
                   TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                   credit5.setText("camion");

                   score.setText(""+Slide_for_trans.viewAll("bike"));
                   score2.setText(""+Slide_for_trans.viewAll("moto"));
                   score3.setText(""+Slide_for_trans.viewAll("tramway"));
                   score4.setText(""+Slide_for_trans.viewAll("airport"));
                   score5.setText(""+Slide_for_trans.viewAll("truck"));


                   Button next=(Button)vie.findViewById(R.id.nextDialog);
                   Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                   builder.setView(vie);
                   final AlertDialog a=builder.create();
                   a.show();

                   next.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Slide_for_trans.viewPager.setCurrentItem(2);
                           a.cancel();
                       }
                   });

                   repeat.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent i=new Intent(context,niveau2_for_trans.class);
                           startActivity(context,i,null);
                       }
                   });

                   // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                   a.show();
               }
           });

       }

            if (startActivity.langue == false) {
                final   int scoreniv1=(Slide_for_trans.getscoreimage("bike")+Slide_for_trans.getscoreimage("moto")+Slide_for_trans.getscoreimage("tramway")+Slide_for_trans.getscoreimage("airport")+Slide_for_trans.getscoreimage("truck"));

                if ((scoreniv1 > 0) && (scoreniv1 <= 10)) {

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
                                    if ((scoreniv1 > 0) && (scoreniv1 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv1 > 10) && (scoreniv1 <= 20)) {
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
                                    if ((scoreniv1 > 10) && (scoreniv1 <= 15)) {
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
                } else if ((scoreniv1 > 20) && (scoreniv1 <= 30)) {
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
                                    if ((scoreniv1 > 20) && (scoreniv1 <= 25)) {
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
                } else if ((scoreniv1 > 30) && (scoreniv1 <= 40)) {
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
                                    if ((scoreniv1 > 30) && (scoreniv1 <= 35)) {
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
                } else if ((scoreniv1 > 40) && (scoreniv1 <= 50)) {
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

                                    if ((scoreniv1 >= 40) && (scoreniv1 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv1 > 45) && (scoreniv1 <= 47)) {
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
              final   int scoreniv1=(Slide_for_trans.getscoreimage("bike")+Slide_for_trans.getscoreimage("moto")+Slide_for_trans.getscoreimage("tramway")+Slide_for_trans.getscoreimage("airport")+Slide_for_trans.getscoreimage("truck"));

                if ((scoreniv1 > 0) && (scoreniv1 <= 10)) {

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
                                    if ((scoreniv1 > 0) && (scoreniv1 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv1 > 10) && (scoreniv1 <= 20)) {
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
                                    if ((scoreniv1 > 10) && (scoreniv1 <= 15)) {
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
                } else if ((scoreniv1 > 20) && (scoreniv1 <= 30)) {
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
                                    if ((scoreniv1 > 20) && (scoreniv1 <= 25)) {
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
                } else if ((scoreniv1 > 30) && (scoreniv1 <= 40)) {
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
                                    if ((scoreniv1 > 30) && (scoreniv1 <= 35)) {
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
                } else if ((scoreniv1 > 40) && (scoreniv1 <= 50)) {
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

                                    if ((scoreniv1 >= 40) && (scoreniv1 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv1 > 45) && (scoreniv1 <= 47)) {
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


        if(position==2) {
            final int[] mProgressStatus= {0};

            int scoreniv=(Slide_for_trans.getscoreimage("bike")+Slide_for_trans.getscoreimage("moto")+Slide_for_trans.getscoreimage("tramway")+Slide_for_trans.getscoreimage("airport")+Slide_for_trans.getscoreimage("truck"));
            if (scoreniv >= 5) {
                imageView.setImageResource(R.drawable.trois);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveau3_for_trans.class);
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

                        //String sc=   database.getImagescore("cat");
                        score.setText(""+Slide_for_trans.getscoreimage("wagon"));
                        score2.setText(""+Slide_for_trans.getscoreimage("ship"));
                        score3.setText(""+Slide_for_trans.getscoreimage("tractor"));
                        score4.setText(""+Slide_for_trans.getscoreimage("pirogue"));
                        score5.setText(""+Slide_for_trans.getscoreimage("tank"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("wagon  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("ship  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("tractor  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("canoe  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("tank");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_trans.viewPager.setCurrentItem(3);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau3_for_trans.class);
                                MainActivity.TotalScore=0;
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

                        //String sc=   database.getImagescore("cat");
                        score.setText(""+Slide_for_trans.getscoreimage("wagon"));
                        score2.setText(""+Slide_for_trans.getscoreimage("ship"));
                        score3.setText(""+Slide_for_trans.getscoreimage("tractor"));
                        score4.setText(""+Slide_for_trans.getscoreimage("pirogue"));
                        score5.setText(""+Slide_for_trans.getscoreimage("tank"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("wagon  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("voilier  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("tracteur  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("pirogue  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("char");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_trans.viewPager.setCurrentItem(3);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau3_for_trans.class);
                                MainActivity.TotalScore=0;
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });
            }
            if (startActivity.langue == false) {
                final  int scoreniv1=(Slide_for_trans.getscoreimage("wagon")+Slide_for_trans.getscoreimage("ship")+Slide_for_trans.getscoreimage("tractor")+Slide_for_trans.getscoreimage("pirogue")+Slide_for_trans.getscoreimage("tank"));

                if ((scoreniv1 > 0) && (scoreniv1 <= 10)) {

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
                                    if ((scoreniv1 > 0) && (scoreniv1 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv1 > 10) && (scoreniv1 <= 20)) {
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
                                    if ((scoreniv1 > 10) && (scoreniv1 <= 15)) {
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
                } else if ((scoreniv1 > 20) && (scoreniv1 <= 30)) {
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
                                    if ((scoreniv1 > 20) && (scoreniv1 <= 25)) {
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
                } else if ((scoreniv1 > 30) && (scoreniv1 <= 40)) {
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
                                    if ((scoreniv1 > 30) && (scoreniv1 <= 35)) {
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
                } else if ((scoreniv1 > 40) && (scoreniv1 <= 50)) {
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

                                    if ((scoreniv1 >= 40) && (scoreniv1 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv1 > 45) && (scoreniv1 <= 47)) {
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
                final  int scoreniv1=(Slide_for_trans.getscoreimage("wagon")+Slide_for_trans.getscoreimage("ship")+Slide_for_trans.getscoreimage("tractor")+Slide_for_trans.getscoreimage("pirogue")+Slide_for_trans.getscoreimage("tank"));

                if ((scoreniv1 > 0) && (scoreniv1 <= 10)) {

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
                                    if ((scoreniv1 > 0) && (scoreniv1 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv1 > 10) && (scoreniv1 <= 20)) {
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
                                    if ((scoreniv1 > 10) && (scoreniv1 <= 15)) {
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
                } else if ((scoreniv1 > 20) && (scoreniv1 <= 30)) {
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
                                    if ((scoreniv1 > 20) && (scoreniv1 <= 25)) {
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
                } else if ((scoreniv1 > 30) && (scoreniv1 <= 40)) {
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
                                    if ((scoreniv1 > 30) && (scoreniv1 <= 35)) {
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
                } else if ((scoreniv1 > 40) && (scoreniv1 <= 50)) {
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

                                    if ((scoreniv1 >= 40) && (scoreniv1 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv1 > 45) && (scoreniv1 <= 47)) {
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

        if(position==3) {

            final int[] mProgressStatus= {0};

            int scoreniv=(Slide_for_trans.getscoreimage("wagon")+Slide_for_trans.getscoreimage("ship")+Slide_for_trans.getscoreimage("tractor")+Slide_for_trans.getscoreimage("pirogue")+Slide_for_trans.getscoreimage("tank"));
            if (scoreniv >= 5) {
                imageView.setImageResource(R.drawable.quatre);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveau4_for_trans.class);
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

                        //String sc=   database.getImagescore("cat");
                        score.setText(""+Slide_for_trans.getscoreimage("para"));
                        score2.setText(""+Slide_for_trans.getscoreimage("scooter"));
                        score3.setText(""+Slide_for_trans.getscoreimage("carrosse"));
                        score4.setText(""+Slide_for_trans.getscoreimage("zep"));
                        score5.setText(""+Slide_for_trans.getscoreimage("metro"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("para  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("scooter  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("coach  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("zeppelin  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("metro");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_trans.viewPager.setCurrentItem(4);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau4_for_trans.class);
                                MainActivity.TotalScore=0;
                                startActivity(context,i,null);
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
                        TextView score2=(TextView)vie.findViewById(R.id.TVcrd2);
                        TextView score3=(TextView)vie.findViewById(R.id.TVcrd3);
                        TextView score4=(TextView)vie.findViewById(R.id.TVcrd4);
                        TextView score5=(TextView)vie.findViewById(R.id.TVcrd5);

                        //String sc=   database.getImagescore("cat");
                        score.setText(""+Slide_for_trans.getscoreimage("para"));
                        score2.setText(""+Slide_for_trans.getscoreimage("scooter"));
                        score3.setText(""+Slide_for_trans.getscoreimage("carrosse"));
                        score4.setText(""+Slide_for_trans.getscoreimage("zep"));
                        score5.setText(""+Slide_for_trans.getscoreimage("metro"));


                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("para  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("trottinette ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("carrosse  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("zep  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("metro");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_trans.viewPager.setCurrentItem(4);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau4_for_trans.class);
                                MainActivity.TotalScore=0;
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });
            }
            if (startActivity.langue == false) {
                final int scoreniv1=(Slide_for_trans.getscoreimage("para")+Slide_for_trans.getscoreimage("scooter")+Slide_for_trans.getscoreimage("carrosse")+Slide_for_trans.getscoreimage("zep")+Slide_for_trans.getscoreimage("metro"));

                if ((scoreniv1 > 0) && (scoreniv1 <= 10)) {

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
                                    if ((scoreniv1 > 0) && (scoreniv1 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv1 > 10) && (scoreniv1 <= 20)) {
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
                                    if ((scoreniv1 > 10) && (scoreniv1 <= 15)) {
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
                } else if ((scoreniv1 > 20) && (scoreniv1 <= 30)) {
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
                                    if ((scoreniv1 > 20) && (scoreniv1 <= 25)) {
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
                } else if ((scoreniv1 > 30) && (scoreniv1 <= 40)) {
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
                                    if ((scoreniv1 > 30) && (scoreniv1 <= 35)) {
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
                } else if ((scoreniv1 > 40) && (scoreniv1 <= 50)) {
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

                                    if ((scoreniv1 >= 40) && (scoreniv1 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv1 > 45) && (scoreniv1 <= 47)) {
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
               final int scoreniv1=(Slide_for_trans.getscoreimage("para")+Slide_for_trans.getscoreimage("scooter")+Slide_for_trans.getscoreimage("carrosse")+Slide_for_trans.getscoreimage("zep")+Slide_for_trans.getscoreimage("metro"));

                if ((scoreniv1 > 0) && (scoreniv1 <= 10)) {

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
                                    if ((scoreniv1 > 0) && (scoreniv1 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv1 > 10) && (scoreniv1 <= 20)) {
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
                                    if ((scoreniv1 > 10) && (scoreniv1 <= 15)) {
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
                } else if ((scoreniv1 > 20) && (scoreniv1 <= 30)) {
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
                                    if ((scoreniv1 > 20) && (scoreniv1 <= 25)) {
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
                } else if ((scoreniv1 > 30) && (scoreniv1 <= 40)) {
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
                                    if ((scoreniv1 > 30) && (scoreniv1 <= 35)) {
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
                } else if ((scoreniv1 > 40) && (scoreniv1 <= 50)) {
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

                                    if ((scoreniv1 >= 40) && (scoreniv1 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv1 > 45) && (scoreniv1 <= 47)) {
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

        if(position==4) {
            final int[] mProgressStatus= {0};

            int scoreniv=(Slide_for_trans.getscoreimage("para")+Slide_for_trans.getscoreimage("scooter")+Slide_for_trans.getscoreimage("carrosse")+Slide_for_trans.getscoreimage("zep")+Slide_for_trans.getscoreimage("metro"));
            if (scoreniv >= 5) {
                imageView.setImageResource(R.drawable.niveaucinq);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveau5_for_trans.class);
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

                        //String sc=   database.getImagescore("cat");
                        score.setText(""+Slide_for_trans.getscoreimage("peniche"));
                        score2.setText(""+Slide_for_trans.getscoreimage("fourgon"));
                        score3.setText(""+Slide_for_trans.getscoreimage("ticket"));
                        score4.setText(""+Slide_for_trans.getscoreimage("chauffeur"));
                        score5.setText(""+Slide_for_trans.getscoreimage("hele"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("barge  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("van  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("ticket");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("chauffeur ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("hele");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau5_for_trans.class);
                                MainActivity.TotalScore=0;
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

                        //String sc=   database.getImagescore("cat");
                        score.setText(""+Slide_for_trans.getscoreimage("peniche"));
                        score2.setText(""+Slide_for_trans.getscoreimage("fourgon"));
                        score3.setText(""+Slide_for_trans.getscoreimage("ticket"));
                        score4.setText(""+Slide_for_trans.getscoreimage("chauffeur"));
                        score5.setText(""+Slide_for_trans.getscoreimage("hele"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("peniche  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("fourgon  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("billet ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("chauffeur ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("hele");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau5_for_trans.class);
                                MainActivity.TotalScore=0;
                                startActivity(context,i,null);
                            }
                        });

                        // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                        a.show();
                    }
                });
            }
            if (startActivity.langue == false) {
                final int scoreniv1=(Slide_for_trans.getscoreimage("peniche")+Slide_for_trans.getscoreimage("fourgon")+Slide_for_trans.getscoreimage("ticket")+Slide_for_trans.getscoreimage("chauffeur")+Slide_for_trans.getscoreimage("hele"));

                if ((scoreniv1 > 0) && (scoreniv1 <= 10)) {

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
                                    if ((scoreniv1 > 0) && (scoreniv1 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv1 > 10) && (scoreniv1 <= 20)) {
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
                                    if ((scoreniv1 > 10) && (scoreniv1 <= 15)) {
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
                } else if ((scoreniv1 > 20) && (scoreniv1 <= 30)) {
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
                                    if ((scoreniv1 > 20) && (scoreniv1 <= 25)) {
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
                } else if ((scoreniv1 > 30) && (scoreniv1 <= 40)) {
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
                                    if ((scoreniv1 > 30) && (scoreniv1 <= 35)) {
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
                } else if ((scoreniv1 > 40) && (scoreniv1 <= 50)) {
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

                                    if ((scoreniv1 >= 40) && (scoreniv1 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv1 > 45) && (scoreniv1 <= 47)) {
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
                final int scoreniv1=(Slide_for_trans.getscoreimage("peniche")+Slide_for_trans.getscoreimage("fourgon")+Slide_for_trans.getscoreimage("ticket")+Slide_for_trans.getscoreimage("chauffeur")+Slide_for_trans.getscoreimage("hele"));

                if ((scoreniv1 > 0) && (scoreniv1 <= 10)) {

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
                                    if ((scoreniv1 > 0) && (scoreniv1 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv1 > 10) && (scoreniv1 <= 20)) {
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
                                    if ((scoreniv1 > 10) && (scoreniv1 <= 15)) {
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
                } else if ((scoreniv1 > 20) && (scoreniv1 <= 30)) {
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
                                    if ((scoreniv1 > 20) && (scoreniv1 <= 25)) {
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
                } else if ((scoreniv1 > 30) && (scoreniv1 <= 40)) {
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
                                    if ((scoreniv1 > 30) && (scoreniv1 <= 35)) {
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
                } else if ((scoreniv1 > 40) && (scoreniv1 <= 50)) {
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

                                    if ((scoreniv1 >= 40) && (scoreniv1 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv1 > 45) && (scoreniv1 <= 47)) {
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


            container.addView(view);

            return view;

        }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }



}
