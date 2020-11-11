package com.example.acer.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class ChatFragmentmultijoueur extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button sendButton;
    static Button finishButton;


    boolean boto =true;
    boolean boto2 =true;
    boolean x=false;
    boolean f=false;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText mInputMessageView;
    private RecyclerView mMessagesView;
    private OnFragmentInteractionListener mListener;
    private List<MessageMultijoueur> mMessages = new ArrayList<MessageMultijoueur>();
    private RecyclerView.Adapter mAdapter;

    private Socket socket;
    {
        String c= enter_ip_add.adresse;
        try{
            socket = IO.socket(""+c+""+":5000");
        }catch(URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

    public  ChatFragmentmultijoueur newInstance(String param1, String param2) {
        ChatFragmentmultijoueur fragment = new ChatFragmentmultijoueur();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ChatFragmentmultijoueur() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        socket.connect();
        socket.on("message", handleIncomingMessages);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_chatmultijoueur, container, false);
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mAdapter = new MessageAdapterMultijoueur( mMessages);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMessagesView = (RecyclerView) view.findViewById(R.id.messages);
        mMessagesView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMessagesView.setAdapter(mAdapter);

        sendButton = (Button) view.findViewById(R.id.send_button);
        finishButton = (Button) view.findViewById(R.id.finish);
       // mInputMessageView = (EditText) view.findViewById(R.id.message_input);



        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(x==false)
                sendMessage();


            }
        });

        finishButton.setVisibility(View.INVISIBLE);



    }

    private void sendMessage(){
        String message = login_activite.nom+"  :  vous invite a jouer";
       // mInputMessageView.setText("");
        addMessage(message);
        JSONObject sendText = new JSONObject();
        try{
            sendText.put("text",message);
            socket.emit("message", sendText);
        }catch(JSONException e){

        }

    }
    private void sendMessagekaka(){
        String message = login_activite.nom+"  :  a accepte votre invitation";
     //   mInputMessageView.setText("");
        addMessage(message);
        JSONObject sendText = new JSONObject();
        try{
            sendText.put("text",message);
            socket.emit("message", sendText);
        }catch(JSONException e){

        }

    }

    private void sendMessagefinish(){
        String message = ""+ MainActivitymultijoueur.scoremulti;
//        mInputMessageView.setText("");
        addMessage(message);
        JSONObject sendText = new JSONObject();
        try{
            sendText.put("text",message);
            socket.emit("message", sendText);
        }catch(JSONException e){

        }

    }
    private void sendMessageok(){
        String message = ""+ MainActivitymultijoueur.scoremulti*100;
      //  mInputMessageView.setText("");
        addMessage(message);
        JSONObject sendText = new JSONObject();
        try{
            sendText.put("text",message);
            socket.emit("message", sendText);
        }catch(JSONException e){

        }
        finishButton.setVisibility(View.INVISIBLE);
        MainActivitymultijoueur.b2.setVisibility(View.VISIBLE);

    }

    public void sendImage(String path)
    {
        JSONObject sendData = new JSONObject();
        try{
            sendData.put("image", encodeImage(path));
            Bitmap bmp = decodeImage(sendData.getString("image"));
            addImage(bmp);
            socket.emit("message",sendData);

        }catch(JSONException e){

        }
    }

    private void addMessage(String message) {

        mMessages.add(new MessageMultijoueur.Builder(MessageMultijoueur.TYPE_MESSAGE)
                .message(message).build());

        mAdapter = new MessageAdapterMultijoueur( mMessages);
        mAdapter.notifyItemInserted(0);
        scrollToBottom();
    }

    private void addImage(Bitmap bmp){
        mMessages.add(new MessageMultijoueur.Builder(MessageMultijoueur.TYPE_MESSAGE)
                .image(bmp).build());
        mAdapter = new MessageAdapterMultijoueur( mMessages);
        mAdapter.notifyItemInserted(0);
        scrollToBottom();
    }
    private void scrollToBottom() {
        mMessagesView.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    private String encodeImage(String path)
    {
        File imagefile = new File(path);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(imagefile);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        Bitmap bm = BitmapFactory.decodeStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;

    }

    private Bitmap decodeImage(String data)
    {
        byte[] b = Base64.decode(data, Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(b,0,b.length);
        return bmp;
    }

    private Emitter.Listener handleIncomingMessages = new Emitter.Listener(){
        @Override
        public void call(final Object... args){
            getActivity().runOnUiThread(new Runnable() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    final String message;
                    String imageText;
                    try {
                        message = data.getString("text").toString();
                        if (message.indexOf("vous invite a jouer")!=-1) {
                            sendButton.setOnClickListener(new View.OnClickListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public void onClick(View view) {
                                    if (x == false) {
                                        sendMessagekaka();
                                        MainActivitymultijoueur.b1.setEnabled(true);
                                        MainActivitymultijoueur.b2.setEnabled(true);
                                    }
                                    x = true;
                                    f = false;

                                }
                            });
                            finishButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    sendMessageok();
                                    MainActivitymultijoueur.b1.setEnabled(false);
                                    boto2=false;
                                }


                            });
                        }
                        if (message.indexOf("a accepte votre invitation")!=-1) {
                            MainActivitymultijoueur.b1.setEnabled(true);
                            MainActivitymultijoueur.b2.setEnabled(true);
                            x = true;
                            f = false;
                            finishButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                        sendMessagefinish();
                                        MainActivitymultijoueur.b1.setEnabled(false);
                                        MainActivitymultijoueur.b2.setVisibility(View.VISIBLE);
                                        finishButton.setVisibility(View.INVISIBLE);

                                        boto=false;

                                }
                            });
                        }

                        if (message.equals("1") || message.equals("2") || message.equals("3") || message.equals("4") || message.equals("5") || message.equals("6") || message.equals("7") || message.equals("8") || message.equals("9") || message.equals("10") ||
                                message.equals("11") || message.equals("12") || message.equals("13") || message.equals("14") || message.equals("15") || message.equals("16") || message.equals("17") || message.equals("18") || message.equals("19") || message.equals("20") ||
                                message.equals("21") || message.equals("22") || message.equals("23") || message.equals("24") || message.equals("25") || message.equals("26") || message.equals("27") || message.equals("28") || message.equals("29") || message.equals("30") ||
                                message.equals("31") || message.equals("32") || message.equals("33") || message.equals("34") || message.equals("35") || message.equals("36") || message.equals("37") || message.equals("38") || message.equals("39") || message.equals("40") ||
                                message.equals("41") || message.equals("42") || message.equals("43") || message.equals("44") || message.equals("45") || message.equals("46") || message.equals("47") || message.equals("48") || message.equals("49") || message.equals("50")) {

                            if(MainActivitymultijoueur.count==5&&boto2==false){
                            if(Integer.parseInt(message)< MainActivitymultijoueur.scoremulti){
                                mMessagesView.setBackgroundResource(R.drawable.win);
                            }
                            else if(Integer.parseInt(message)== MainActivitymultijoueur.scoremulti){
                                mMessagesView.setBackgroundResource(R.drawable.agalite);
                            }else if(Integer.parseInt(message)> MainActivitymultijoueur.scoremulti){
                                mMessagesView.setBackgroundResource(R.drawable.lost);

                            }}

                            finishButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if(Integer.parseInt(message)< MainActivitymultijoueur.scoremulti){
                                        mMessagesView.setBackgroundResource(R.drawable.win);
                                    }
                                    else if(Integer.parseInt(message)== MainActivitymultijoueur.scoremulti){
                                        mMessagesView.setBackgroundResource(R.drawable.agalite);
                                    }else if(Integer.parseInt(message)> MainActivitymultijoueur.scoremulti){
                                        mMessagesView.setBackgroundResource(R.drawable.lost);

                                    }
                                    sendMessageok();
                                    MainActivitymultijoueur.b1.setEnabled(false);}


                            });


                        }
                        if(message.equals("100")||message.equals("200")||message.equals("300")||message.equals("400")||message.equals("500")||message.equals("600")||message.equals("700")||message.equals("800")||message.equals("900")||message.equals("1000")||
                                message.equals("1100")||message.equals("1200")||message.equals("1300")||message.equals("1400")||message.equals("1500")||message.equals("1600")||message.equals("1700")||message.equals("1800")||message.equals("1900")||message.equals("2000")||
                                message.equals("2100")||message.equals("2200")||message.equals("2300")||message.equals("2400")||message.equals("2500")||message.equals("2600")||message.equals("2700")||message.equals("2800")||message.equals("2900")||message.equals("3000")||
                                message.equals("3100")||message.equals("3200")||message.equals("3300")||message.equals("3400")||message.equals("3500")||message.equals("3600")||message.equals("3700")||message.equals("3800")||message.equals("3900")||message.equals("4000")||
                                message.equals("4100")||message.equals("4200")||message.equals("4300")||message.equals("4400")||message.equals("4500")||message.equals("4600")||message.equals("4700")||message.equals("4800")||message.equals("4900")||message.equals("5000")){

                            if(MainActivitymultijoueur.count==5&&boto==false){
                            if((Integer.parseInt(message)/100)< MainActivitymultijoueur.scoremulti){
                                mMessagesView.setBackgroundResource(R.drawable.win);
                            }
                            else if((Integer.parseInt(message)/100)== MainActivitymultijoueur.scoremulti){
                                mMessagesView.setBackgroundResource(R.drawable.agalite);
                            }else if((Integer.parseInt(message))/100> MainActivitymultijoueur.scoremulti){
                                mMessagesView.setBackgroundResource(R.drawable.lost);

                            }}
                            finishButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if((Integer.parseInt(message)/100)< MainActivitymultijoueur.scoremulti){
                                        mMessagesView.setBackgroundResource(R.drawable.win);
                                    }
                                    else if((Integer.parseInt(message)/100)== MainActivitymultijoueur.scoremulti){
                                        mMessagesView.setBackgroundResource(R.drawable.agalite);
                                    }else if((Integer.parseInt(message))/100> MainActivitymultijoueur.scoremulti){
                                        mMessagesView.setBackgroundResource(R.drawable.loss);

                                    }

                                    sendMessagefinish();
                                    MainActivitymultijoueur.b1.setEnabled(false);
                                    finishButton.setVisibility(View.INVISIBLE);
                                    MainActivitymultijoueur.b2.setVisibility(View.VISIBLE);
                                }


                            });

                        }

                        addMessage(message);

                    } catch (JSONException e) {

                    }
                    try {
                        imageText = data.getString("image");
                        addImage(decodeImage(imageText));
                    } catch (JSONException e) {

                    }

                }
            });
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        socket.disconnect();
    }


}