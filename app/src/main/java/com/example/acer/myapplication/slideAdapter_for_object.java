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

public class slideAdapter_for_object extends PagerAdapter {

    ProgressBar progressBar;
    private Handler mHandler = new Handler();
    final static String ex2="moncef";
    public static int go2;
    public static boolean x=false;
    My_helper database;



    Context context;
    LayoutInflater layoutInflater;

    public slideAdapter_for_object(Context context) {
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
            final   int[] mProgressStatus= {0};
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent i=new Intent(context,niveau1_for_object.class);
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
                        score.setText("" + Slide_for_object.getscoreimage("bed"));
                        score2.setText("" + Slide_for_object.getscoreimage("table"));
                        score3.setText("" + Slide_for_object.getscoreimage("door"));
                        score4.setText("" + Slide_for_object.getscoreimage("picture"));
                        score5.setText("" + Slide_for_object.getscoreimage("stair"));

                        TextView credit1 = (TextView) vie.findViewById(R.id.credit1);
                        credit1.setText("bed  ");
                        TextView credit2 = (TextView) vie.findViewById(R.id.credit2);
                        credit2.setText("table  ");
                        TextView credit3 = (TextView) vie.findViewById(R.id.credit3);
                        credit3.setText("door  ");
                        TextView credit4 = (TextView) vie.findViewById(R.id.credit4);
                        credit4.setText("picture  ");
                        TextView credit5 = (TextView) vie.findViewById(R.id.credit5);
                        credit5.setText("stair");


                        Button next = (Button) vie.findViewById(R.id.nextDialog);
                        Button repeat = (Button) vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a = builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_object.viewPager.setCurrentItem(1);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i = new Intent(context, niveau1_for_object.class);
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
                        score.setText("" + Slide_for_object.getscoreimage("bed"));
                        score2.setText("" + Slide_for_object.getscoreimage("table"));
                        score3.setText("" + Slide_for_object.getscoreimage("door"));
                        score4.setText("" + Slide_for_object.getscoreimage("picture"));
                        score5.setText("" + Slide_for_object.getscoreimage("stair"));

                        TextView credit1 = (TextView) vie.findViewById(R.id.credit1);
                        credit1.setText("lit  ");
                        TextView credit2 = (TextView) vie.findViewById(R.id.credit2);
                        credit2.setText("table  ");
                        TextView credit3 = (TextView) vie.findViewById(R.id.credit3);
                        credit3.setText("porte  ");
                        TextView credit4 = (TextView) vie.findViewById(R.id.credit4);
                        credit4.setText("image  ");
                        TextView credit5 = (TextView) vie.findViewById(R.id.credit5);
                        credit5.setText("escalier");


                        Button next = (Button) vie.findViewById(R.id.nextDialog);
                        Button repeat = (Button) vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a = builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_object.viewPager.setCurrentItem(1);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i = new Intent(context, niveau1_for_object.class);
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
                final int scoreniv=(Slide_for_object.getscoreimage("bed")+Slide_for_object.getscoreimage("table")+Slide_for_object.getscoreimage("door")+Slide_for_object.getscoreimage("picture")+Slide_for_object.getscoreimage("stair"));

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
                final int scoreniv=(Slide_for_object.getscoreimage("bed")+Slide_for_object.getscoreimage("table")+Slide_for_object.getscoreimage("door")+Slide_for_object.getscoreimage("picture")+Slide_for_object.getscoreimage("stair"));

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
            final   int[] mProgressStatus= {0};
            final int scoreniv=(Slide_for_object.getscoreimage("bed")+Slide_for_object.getscoreimage("table")+Slide_for_object.getscoreimage("door")+Slide_for_object.getscoreimage("picture")+Slide_for_object.getscoreimage("stair"))/5;

       if(scoreniv>=5){
           imageView.setImageResource(R.drawable.deux);

           imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i=new Intent(context,niveau2_for_object.class);
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
                   credit1.setText("chair  ");
                   TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                   credit2.setText("plate  ");
                   TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                   credit3.setText("cup  ");
                   TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                   credit4.setText("box   ");
                   TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                   credit5.setText("bathroom");

                   score.setText(""+Slide_for_object.viewAll("chair"));
                   score2.setText(""+Slide_for_object.viewAll("plate"));
                   score3.setText(""+Slide_for_object.viewAll("cup"));
                   score4.setText(""+Slide_for_object.viewAll("box"));
                   score5.setText(""+Slide_for_object.viewAll("bathromm"));

                   Button next=(Button)vie.findViewById(R.id.nextDialog);
                   Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                   builder.setView(vie);
                   final AlertDialog a=builder.create();
                   a.show();

                   next.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Slide_for_object.viewPager.setCurrentItem(2);
                           a.cancel();
                       }
                   });

                   repeat.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent i=new Intent(context,niveau2_for_object.class);
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
                   credit1.setText("chaise  ");
                   TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                   credit2.setText("assiette  ");
                   TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                   credit3.setText("tasse  ");
                   TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                   credit4.setText("boite  ");
                   TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                   credit5.setText("toilette");

                   score.setText(""+Slide_for_object.viewAll("chair"));
                   score2.setText(""+Slide_for_object.viewAll("plate"));
                   score3.setText(""+Slide_for_object.viewAll("cup"));
                   score4.setText(""+Slide_for_object.viewAll("box"));
                   score5.setText(""+Slide_for_object.viewAll("bathromm"));

                   Button next=(Button)vie.findViewById(R.id.nextDialog);
                   Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                   builder.setView(vie);
                   final AlertDialog a=builder.create();
                   a.show();

                   next.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Slide_for_object.viewPager.setCurrentItem(2);
                           a.cancel();
                       }
                   });

                   repeat.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent i=new Intent(context,niveau2_for_object.class);
                           startActivity(context,i,null);
                       }
                   });

                   // desc.setText("La recherche opérationnelle est un des grands domaines d'application de l'informatique et des mathématiques appliquées dans l'industrie. Elle regroupe un ensemble de méthodes, modèles et outils informatiques et mathématiques permettant, de façon générale, d'optimiser le processus de prise de décisions dans l'Entreprise.");



                   a.show();
               }
           });

       }
            if (startActivity.langue == false) {
                final int scoreniv1=(Slide_for_object.getscoreimage("chair")+Slide_for_object.getscoreimage("plate")+Slide_for_object.getscoreimage("cup")+Slide_for_object.getscoreimage("box")+Slide_for_object.getscoreimage("bathroom"));

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
                final int scoreniv1=(Slide_for_object.getscoreimage("chair")+Slide_for_object.getscoreimage("plate")+Slide_for_object.getscoreimage("cup")+Slide_for_object.getscoreimage("box")+Slide_for_object.getscoreimage("bathroom"));

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
            final   int[] mProgressStatus= {0};
            final int scoreniv1=(Slide_for_object.getscoreimage("chair")+Slide_for_object.getscoreimage("plate")+Slide_for_object.getscoreimage("cup")+Slide_for_object.getscoreimage("box")+Slide_for_object.getscoreimage("bathroom"))/5;
            if (scoreniv1 >= 5) {
                imageView.setImageResource(R.drawable.trois);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveau3_for_object.class);
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
                        score.setText(""+Slide_for_object.getscoreimage("pen"));
                        score2.setText(""+Slide_for_object.getscoreimage("spoon"));
                        score3.setText(""+Slide_for_object.getscoreimage("knife"));
                        score4.setText(""+Slide_for_object.getscoreimage("book"));
                        score5.setText(""+Slide_for_object.getscoreimage("receiver"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("pen ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("spoon ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("knife ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("book");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText(" receiver");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_object.viewPager.setCurrentItem(3);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau3_for_object.class);
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
                        score.setText(""+Slide_for_object.getscoreimage("pen"));
                        score2.setText(""+Slide_for_object.getscoreimage("spoon"));
                        score3.setText(""+Slide_for_object.getscoreimage("knife"));
                        score4.setText(""+Slide_for_object.getscoreimage("book"));
                        score5.setText(""+Slide_for_object.getscoreimage("receiver"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("stylo  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("cuillère  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("couteau ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("livre  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("récepteur");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_object.viewPager.setCurrentItem(3);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau3_for_object.class);
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
                final int scoreniv2=(Slide_for_object.getscoreimage("pen")+Slide_for_object.getscoreimage("spoon")+Slide_for_object.getscoreimage("knife")+Slide_for_object.getscoreimage("book")+Slide_for_object.getscoreimage("receiver"));

                if ((scoreniv2 > 0) && (scoreniv2 <= 10)) {

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
                } else if ((scoreniv2 > 20) && (scoreniv2 <= 30)) {
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
                final int scoreniv2=(Slide_for_object.getscoreimage("pen")+Slide_for_object.getscoreimage("spoon")+Slide_for_object.getscoreimage("knife")+Slide_for_object.getscoreimage("book")+Slide_for_object.getscoreimage("receiver"));

                if ((scoreniv2 > 0) && (scoreniv2 <= 10)) {

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
                } else if ((scoreniv2 > 20) && (scoreniv2 <= 30)) {
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
        }

        if(position==3) {
            final   int[] mProgressStatus= {0};
            final int scoreniv2=(Slide_for_object.getscoreimage("pen")+Slide_for_object.getscoreimage("spoon")+Slide_for_object.getscoreimage("knife")+Slide_for_object.getscoreimage("book")+Slide_for_object.getscoreimage("receiver"))/5;
            if (scoreniv2 >= 5) {
                imageView.setImageResource(R.drawable.quatre);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveau4_for_object.class);
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
                        score.setText(""+Slide_for_object.getscoreimage("ciseaux"));
                        score2.setText(""+Slide_for_object.getscoreimage("pebble"));
                        score3.setText(""+Slide_for_object.getscoreimage("pencil"));
                        score4.setText(""+Slide_for_object.getscoreimage("bottle"));
                        score5.setText(""+Slide_for_object.getscoreimage("glass"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("scissors  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("pebble  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("pencil  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("bottle  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("glass");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_object.viewPager.setCurrentItem(4);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau4_for_object.class);
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
                        score.setText(""+Slide_for_object.getscoreimage("ciseaux"));
                        score2.setText(""+Slide_for_object.getscoreimage("pebble"));
                        score3.setText(""+Slide_for_object.getscoreimage("pencil"));
                        score4.setText(""+Slide_for_object.getscoreimage("bottle"));
                        score5.setText(""+Slide_for_object.getscoreimage("glass"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("ciseaux  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("caillou ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("crayon  ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("bouteille  ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("verre");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Slide_for_object.viewPager.setCurrentItem(4);
                                a.cancel();
                            }
                        });

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau4_for_object.class);
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
               final int scoreniv3=(Slide_for_object.getscoreimage("ciseaux")+Slide_for_object.getscoreimage("pebble")+Slide_for_object.getscoreimage("pencil")+Slide_for_object.getscoreimage("bottle")+Slide_for_object.getscoreimage("glass"));

                if ((scoreniv3 > 0) && (scoreniv3 <= 10)) {

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
                                    if ((scoreniv3 > 0) && (scoreniv3 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv3 > 10) && (scoreniv3 <= 20)) {
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
                                    if ((scoreniv3 > 10) && (scoreniv3 <= 15)) {
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
                } else if ((scoreniv3 > 20) && (scoreniv3 <= 30)) {
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
                                    if ((scoreniv3 > 20) && (scoreniv3 <= 25)) {
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
                } else if ((scoreniv3 > 30) && (scoreniv3 <= 40)) {
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
                                    if ((scoreniv3 > 30) && (scoreniv3 <= 35)) {
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
                } else if ((scoreniv3 > 40) && (scoreniv3 <= 50)) {
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

                                    if ((scoreniv3 >= 40) && (scoreniv3 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv3 > 45) && (scoreniv3 <= 47)) {
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
                final int scoreniv3=(Slide_for_object.getscoreimage("ciseaux")+Slide_for_object.getscoreimage("pebble")+Slide_for_object.getscoreimage("pencil")+Slide_for_object.getscoreimage("bottle")+Slide_for_object.getscoreimage("glass"));

                if ((scoreniv3 > 0) && (scoreniv3 <= 10)) {

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
                                    if ((scoreniv3 > 0) && (scoreniv3 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv3 > 10) && (scoreniv3 <= 20)) {
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
                                    if ((scoreniv3 > 10) && (scoreniv3 <= 15)) {
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
                } else if ((scoreniv3 > 20) && (scoreniv3 <= 30)) {
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
                                    if ((scoreniv3 > 20) && (scoreniv3 <= 25)) {
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
                } else if ((scoreniv3 > 30) && (scoreniv3 <= 40)) {
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
                                    if ((scoreniv3 > 30) && (scoreniv3 <= 35)) {
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
                } else if ((scoreniv3 > 40) && (scoreniv3 <= 50)) {
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

                                    if ((scoreniv3 >= 40) && (scoreniv3 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv3 > 45) && (scoreniv3 <= 47)) {
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
            final   int[] mProgressStatus= {0};
            final int scoreniv3=(Slide_for_object.getscoreimage("ciseaux")+Slide_for_object.getscoreimage("pebble")+Slide_for_object.getscoreimage("pencil")+Slide_for_object.getscoreimage("bottle")+Slide_for_object.getscoreimage("glass"))/5;
            if (scoreniv3 >= 5) {
                imageView.setImageResource(R.drawable.niveaucinq);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, niveau5_for_object.class);
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
                        score.setText(""+Slide_for_object.getscoreimage("clock"));
                        score2.setText(""+Slide_for_object.getscoreimage("rubber"));
                        score3.setText(""+Slide_for_object.getscoreimage("ruler"));
                        score4.setText(""+Slide_for_object.getscoreimage("lock"));
                        score5.setText(""+Slide_for_object.getscoreimage("calculator"));

                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("clock  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("rubber  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("ruler ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("lock ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("calculator");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau5_for_object.class);
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
                        score.setText(""+Slide_for_object.getscoreimage("clock"));
                        score2.setText(""+Slide_for_object.getscoreimage("rubber"));
                        score3.setText(""+Slide_for_object.getscoreimage("ruler"));
                        score4.setText(""+Slide_for_object.getscoreimage("lock"));
                        score5.setText(""+Slide_for_object.getscoreimage("calculator"));


                        TextView  credit1=(TextView)vie.findViewById(R.id.credit1);
                        credit1.setText("horloge  ");
                        TextView  credit2=(TextView)vie.findViewById(R.id.credit2);
                        credit2.setText("gomme  ");
                        TextView  credit3=(TextView)vie.findViewById(R.id.credit3);
                        credit3.setText("ruler ");
                        TextView  credit4=(TextView)vie.findViewById(R.id.credit4);
                        credit4.setText("verrou ");
                        TextView  credit5=(TextView)vie.findViewById(R.id.credit5);
                        credit5.setText("calculatrice");


                        Button next=(Button)vie.findViewById(R.id.nextDialog);
                        Button repeat=(Button)vie.findViewById(R.id.repeatDialog);
                        builder.setView(vie);
                        final AlertDialog a=builder.create();
                        a.show();

                        repeat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent i=new Intent(context,niveau5_for_object.class);
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
              final int scoreniv4=(Slide_for_object.getscoreimage("clock")+Slide_for_object.getscoreimage("rubber")+Slide_for_object.getscoreimage("ruler")+Slide_for_object.getscoreimage("lock")+Slide_for_object.getscoreimage("calculator"));

                if ((scoreniv4 > 0) && (scoreniv4 <= 10)) {

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
                                    if ((scoreniv4 > 0) && (scoreniv4 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv4 > 10) && (scoreniv4 <= 20)) {
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
                                    if ((scoreniv4 > 10) && (scoreniv4 <= 15)) {
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
                } else if ((scoreniv4 > 20) && (scoreniv4 <= 30)) {
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
                                    if ((scoreniv4 > 20) && (scoreniv4 <= 25)) {
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
                } else if ((scoreniv4 > 30) && (scoreniv4 <= 40)) {
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
                                    if ((scoreniv4 > 30) && (scoreniv4 <= 35)) {
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
                } else if ((scoreniv4 > 40) && (scoreniv4 <= 50)) {
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

                                    if ((scoreniv4 >= 40) && (scoreniv4 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv4 > 45) && (scoreniv4 <= 47)) {
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
                final int scoreniv4=(Slide_for_object.getscoreimage("clock")+Slide_for_object.getscoreimage("rubber")+Slide_for_object.getscoreimage("ruler")+Slide_for_object.getscoreimage("lock")+Slide_for_object.getscoreimage("calculator"));

                if ((scoreniv4 > 0) && (scoreniv4 <= 10)) {

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
                                    if ((scoreniv4 > 0) && (scoreniv4 <= 5))
                                        nj1.setImageResource(R.drawable.star_half);
                                    else
                                        nj1.setImageResource(R.drawable.star);
                                }
                            });
                        }
                    }).start();

                    mProgressStatus[0]--;
                } else if ((scoreniv4 > 10) && (scoreniv4 <= 20)) {
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
                                    if ((scoreniv4 > 10) && (scoreniv4 <= 15)) {
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
                } else if ((scoreniv4 > 20) && (scoreniv4 <= 30)) {
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
                                    if ((scoreniv4 > 20) && (scoreniv4 <= 25)) {
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
                } else if ((scoreniv4 > 30) && (scoreniv4 <= 40)) {
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
                                    if ((scoreniv4 > 30) && (scoreniv4 <= 35)) {
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
                } else if ((scoreniv4 > 40) && (scoreniv4 <= 50)) {
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

                                    if ((scoreniv4 >= 40) && (scoreniv4 <= 45)) {
                                        nj1.setImageResource(R.drawable.star);
                                        nj2.setImageResource(R.drawable.star);
                                        nj3.setImageResource(R.drawable.star);
                                        nj4.setImageResource(R.drawable.star);
                                    } else if ((scoreniv4 > 45) && (scoreniv4 <= 47)) {
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
