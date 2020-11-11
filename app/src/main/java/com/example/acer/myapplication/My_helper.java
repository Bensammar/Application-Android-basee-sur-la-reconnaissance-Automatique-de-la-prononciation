package com.example.acer.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ETS HS on 11/04/2018.
 */

public class My_helper extends SQLiteOpenHelper {

    public static final int version =1;
    public static final String DATA_NAME = "categorie.db";
    public static String lg;
    public static String difuculte;


    public My_helper(Context context) {
        super(context, DATA_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE CATEGORIE (id INTEGER,name TEXT primary key unique,description TEXT,imagestar INTEGER )");
        sqLiteDatabase.execSQL("CREATE TABLE user (nomuser TEXT primary key unique,password TEXT )");
        sqLiteDatabase.execSQL("CREATE TABLE image (nomimage text primary key unique,idimage INTEGER )");
        sqLiteDatabase.execSQL("CREATE TABLE niveau (nomniveau TEXT primary key unique )");
        sqLiteDatabase.execSQL("CREATE TABLE jouer (langue text,nivdif text,nomuser text ,name  Text,score integer,CONSTRAINT UC_Person UNIQUE (langue,nivdif,nomuser,name) )");
        sqLiteDatabase.execSQL("CREATE TABLE jouerimage (langue text,nivdif text,nomuser text ,nomimage  Text,score integer,CONSTRAINT UC_Person UNIQUE (langue,nivdif,nomuser,nomimage) )");
        sqLiteDatabase.execSQL("CREATE TABLE jouerniveau (langue text,nivdif text,nomuser text ,nomniveau  Text,score integer,CONSTRAINT UC_Perso UNIQUE (langue,nivdif,nomuser,nomniveau) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CATEGORIE");
        onCreate(sqLiteDatabase);

    }
    public String insertData(categorie c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",c.getImageid());
        contentValues.put("name",c.getTitle());
        contentValues.put("description",c.getDescription());
        contentValues.put("imagestar",c.getImagestar());
//        db.insert("CATEGORIE",null ,contentValues);
        db.insertWithOnConflict("CATEGORIE", null, contentValues,SQLiteDatabase.CONFLICT_IGNORE);

        return c.getTitle();
    }
    public String insertimage(image c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nomimage",c.getTitle());
        contentValues.put("idimage",c.getImageid());

//        db.insert("CATEGORIE",null ,contentValues);
        db.insertWithOnConflict("image", null, contentValues,SQLiteDatabase.CONFLICT_IGNORE);

        return c.getTitle();
    }
    public String insertniveau(niveau c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nomniveau",c.getNomniv());

//        db.insert("CATEGORIE",null ,contentValues);
        db.insertWithOnConflict("niveau", null, contentValues,SQLiteDatabase.CONFLICT_IGNORE);

        return c.getNomniv();
    }

    /*
 * Creating a user
 */
    public String createuser(user user, String[] name,String[] images,String[] niveau,String langue,String nivdif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nomuser", user.getNom());
        values.put("password", user.getPassword());

        // insert row

        db.insertWithOnConflict("user", null, values,SQLiteDatabase.CONFLICT_IGNORE);
        String user_id = user.getNom();

        // assigning tags to user
        for (String tag_id : name) {
            createuserTag(langue,nivdif,user_id, tag_id);
        }
        for (String tag_i : images) {
            createuserimage(langue,nivdif,user_id, tag_i);
        }
        for (String tag : niveau) {
            createuserniveau(langue,nivdif,user_id, tag);
        }

        return user_id;
    }

    public long createuserTag(String langue,String nivdif, String user_id, String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("langue", langue);
        values.put("nivdif", nivdif);
        values.put("nomuser", user_id);
        values.put("name", id);

        long idj = db.insertWithOnConflict("jouer", null, values,SQLiteDatabase.CONFLICT_IGNORE);

        return idj;
    }
    public long createuserimage(String langue,String nivdif,String user_id, String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("langue", langue);
        values.put("nivdif", nivdif);
        values.put("nomuser", user_id);
        values.put("nomimage", id);
        values.put("score",0);

        long idj = db.insertWithOnConflict("jouerimage", null, values,SQLiteDatabase.CONFLICT_IGNORE);

        return idj;
    }
    public long createuserniveau(String langue, String nivdif, String user_id, String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("langue", langue);
        values.put("nivdif", nivdif);
        values.put("nomuser", user_id);
        values.put("nomniveau", id);

        long idj = db.insertWithOnConflict("jouerniveau", null, values,SQLiteDatabase.CONFLICT_IGNORE);

        return idj;
    }

    public Cursor getAllData(String sahit,String lg,String nivdif) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT categorie.id, categorie.name,jouer.score ,categorie.imagestar FROM categorie,jouer where categorie.name=jouer.name and jouer.nomuser = '"+sahit+"' and langue ='"+lg+"' and nivdif='"+nivdif+"'",null);
        return res;
    }
    public Cursor getAllDatajouer(String cat) {
        SQLiteDatabase db = this.getWritableDatabase();

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
        Cursor res = db.rawQuery("select score from jouerimage where nomimage='"+cat+"' and nomuser='"+login_activite.nom+"'"+"and langue='"+lg+"' and nivdif='"+difuculte+"'",null);
        return res;
    }

    public Cursor getAllDatajouerniv(String cat) {
        SQLiteDatabase db = this.getWritableDatabase();

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
        Cursor res = db.rawQuery("select score from jouerniveau where nomniveau='"+cat+"' and nomuser='"+login_activite.nom+"'"+"and langue='"+lg+"' and nivdif='"+difuculte+"'",null);
        return res;
    }

    public Cursor getAllDatajouerCat(String cat) {
        SQLiteDatabase db = this.getWritableDatabase();

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
        Cursor res = db.rawQuery("select score from jouer where name='"+cat+"' and nomuser='"+login_activite.nom+"'"+"and langue='"+lg+"' and nivdif='"+difuculte+"'",null);
        return res;
    }
    public void getAllDatauser() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from user",null);
        if(res.moveToFirst()){
            db.execSQL("");
        }
    }

    public boolean updateData(String name,String nomuser ,int description,String langue,String nivdif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues1 = new ContentValues();
        contentValues.put("score",description);
        //contentValues1.put("description",description);
        db.update("jouerimage", contentValues, "nomimage = ? and  nomuser =? and langue =? and nivdif=?",new String[] { name,nomuser,langue,nivdif });
        // db.update("categorie", contentValues1, "name = ? ",new String[] { name });
        return true;
    }
    public boolean updateDataNiv(String name,String nomuser ,int description,String langue,String nivdif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues1 = new ContentValues();
        contentValues.put("score",description);
        //contentValues1.put("description",description);
        db.update("jouerniveau", contentValues, "nomniveau = ? and  nomuser =? and langue =? and nivdif =?",new String[] { name,nomuser,langue,nivdif });
        // db.update("categorie", contentValues1, "name = ? ",new String[] { name });
        return true;
    }
    public boolean updateDataCategorie(String name,String nomuser ,int description,String langue,String nivdif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues1 = new ContentValues();
        contentValues.put("score",description);
        //contentValues1.put("description",description);
        db.update("jouer", contentValues, "name= ? and  nomuser =? and langue =? and nivdif =?",new String[] { name,nomuser,langue,nivdif });
        return true;
    }
    public  void closedv(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        if(sqLiteDatabase!=null&&sqLiteDatabase.isOpen())
            sqLiteDatabase.close();
    }

    public boolean userExists(String emailid,String password){
        //;
        SQLiteDatabase db;
        db = this.getReadableDatabase();
        String fetchuser = "Select nomuser,password from user";
        Cursor cursor = db.rawQuery(fetchuser, null);
        String a,b = "not found";
        Log.d("received emailid", emailid);
        Log.d("Cursor count", String.valueOf(cursor.getCount()));
        if(cursor.moveToFirst()){
            Log.d("Select " , " clause");
            do{
                a= cursor.getString(0);
                Log.d("a " , a);
                if (a.equals(emailid)){
                    Log.d("emailid  If loop" , a);
                    b = cursor.getString(1);
                    Log.d("b " , b);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        if (b.equals(password)) {
            Log.d("Returning "," true");
            return true;
        }
        else return false;
    }




    public ArrayList<String> getUserName(String emailid){
        SQLiteDatabase db;
        db = this.getReadableDatabase();
        String fetchuser = "Select nomuser,name from jouer";
        Cursor cursor = db.rawQuery(fetchuser, null);
        String a,b = "not found";
        ArrayList<String> list = new ArrayList<String>();
        Log.d("received emailid", emailid);
        Log.d("Cursor count", String.valueOf(cursor.getCount()));

        if(cursor.moveToFirst()){
            Log.d("Select " , " clause");
            do{
                a= cursor.getString(0);
                Log.d("a " , a);
                if (a.equals(emailid)){
                    Log.d("emailid  If loop" , a);
                    list.add(cursor.getString(1));

                    Log.d("b " , a);

                }
            }
            while(cursor.moveToNext());
        }
        return list;

    }

}
