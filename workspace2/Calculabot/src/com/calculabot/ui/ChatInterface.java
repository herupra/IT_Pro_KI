package com.calculabot.ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import com.calculabot.controller.ChatController;
import com.calculabot.formulas.BasicFormula;
import com.calculabot.model.Bubble;
import com.calculabot.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

/**
 * @author Zeed
 *
 */
public class ChatInterface extends Activity implements OnClickListener, OnEditorActionListener {
	ImageButton gobutton;
	ImageButton resetbutton;
	ImageButton copybutton;
	ImageButton listbutton;
	TextView text;
	
	ScrollView scroller;
	ChatController cont;
	PrintWriter out;
	
	
	int calt = 0; // current calculation type
	ArrayList<String> curQue = new ArrayList<String>(); //Current Question
	ArrayList<String> answers = new ArrayList<String>();
	ArrayList<Bubble> chatLog = new ArrayList<Bubble>();
	BasicFormula method;
	int phase = 0;
	int qn = 0; //question number
	
	String result ="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v("sadas", "index=");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat_interface);
		
		cont = new ChatController();
		
		gobutton = (ImageButton) findViewById(R.id.go);
		gobutton.setOnClickListener(this);
		
		resetbutton = (ImageButton) findViewById(R.id.reset);
		resetbutton.setOnClickListener(this);
		
		copybutton = (ImageButton) findViewById(R.id.copy);
		copybutton.setOnClickListener(this);
		
		listbutton = (ImageButton) findViewById(R.id.list);
		listbutton.setOnClickListener(this);
		
		scroller = (ScrollView) findViewById(R.id.scrollbar);
		
		text = (TextView) findViewById(R.id.TextPut);
		text.setOnEditorActionListener(this);
		
		recreateChat();
		
		
		
		String FILENAME = "chathistory";
		String splitSign = "`";

		
		
		try {
			//Log.e("READ", "aaaaaa");
			BufferedReader read = new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
			
			String line = read.readLine();
			String[] temp;
			while(line != null){
				temp = line.split(splitSign);
				//Log.e("READ", "Line: " + line);
				if(temp.length==2){
					popchat(temp[0], Integer.parseInt(temp[1]));
				}
				line = read.readLine();
			}
			read.close();
		} catch (FileNotFoundException e) {
			Log.e("READ", "Bzzr");
			
		} catch (IOException e) {
			Log.e("READ", "Bzzr");
		}/*catch(Exception e){
			Log.e("READ", "Bzza");
		}*/
		finally{
			
		}
		
		try {
			//Log.e("READ", "bbbbb");
			out = new PrintWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
			
			
		} catch (FileNotFoundException e) {
			if (out != null)
	            out.close();
			Log.e("READ", "Bzzx");
		}
		
		Intent i = this.getIntent();
		@SuppressWarnings("unused")
		String iname = i.getStringExtra("name");
		@SuppressWarnings("unused")
		String iwall = i.getStringExtra("wall");
		
		deploy(iname);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_chat_interface, menu);
		
		return true;
	}
	
	@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putBooleanArray("mydata", myData);
    }
	
	
	//----------------------------------------------------------------------------
	
	public void popchat(String text, int type){
		if(type==0){
			userPost(text);
		}else{
			botPost(text);
		}
	}
	
	public void userPost(String message){
		text.setText("");
		LinearLayout content = (LinearLayout)findViewById(R.id.chatview);
		
		
		View right = getLayoutInflater().inflate(R.layout.chat_item_right, content, false);
		TextView m = (TextView) right.findViewById(R.id.message);
		
		m.setText(message);
		
		
		content.addView(right);
		scroller.fullScroll(ScrollView.FOCUS_DOWN);
		
		chatLog.add(new Bubble(message, 0));
		out.println(message+"`0");
	}
	
	public void botPost(String message){
		
		LinearLayout content = (LinearLayout)findViewById(R.id.chatview);
		
		View right = getLayoutInflater().inflate(R.layout.chat_item_left, content, false);
		TextView m = (TextView) right.findViewById(R.id.message);
		
		m.setText(message);
		
		
		content.addView(right);
		scroller.fullScroll(ScrollView.FOCUS_DOWN); 
		
		chatLog.add(new Bubble(message, 1));
		out.println(message+"`1");
	}

	@Override
	public void onClick(View clicked) {
		// TODO Auto-generated method stub
		switch (clicked.getId()){
		case R.id.go:
			goClick();
			break;
		case R.id.reset:
			resetCalc();
			break;
		case R.id.copy:
			copyResult();
			break;
		case R.id.list:
			listClick();
			break;
		}
		
	}
	
	// Start of go click listener and the algorithm to get the answer
	public void goClick(){
		//Phase check
		if(phase==0){
			phase0();
		}else if(phase==1){
			phase1();
		}else if(phase==2){
			
		}else if(phase==3){
			
		}
	}
	
	public void phase0(){
		String in = text.getText().toString();
		
		userPost(in);
		String[] r = in.split(" "); //input in array
		if(r.length>1){
			int p = 0; //pointer
			boolean flag = false;
			for(p=0, flag = false; p<r.length-1; p++){
				if(r[p].equalsIgnoreCase("search")
						|| r[p].equalsIgnoreCase("searching")
						|| r[p].equalsIgnoreCase("calculate")
						|| r[p].equalsIgnoreCase("do")){
					if(r.length > 1){
						deploy(in);
					}
				}
			}
		}
		
	}
	
	public void deploy(String in){

		calt = cont.checkType(in);
		
		if (calt > 0){
			botPost("Available, Starting calculation");
			try {
				curQue = cont.getQuetion(in);
				phase = 1;
				changeTyper();
				askQ();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				botPost("An error in finding class");
			}
		}else{botPost("Try Again");}
	}
	
	public void phase1(){
		String in = text.getText().toString();
		userPost(in);
		if(calt==1){
			if(isNumber(in)){
				answers.add(in);
				qn++;
				
			}else{botPost("The input is not a number");}
		}else{
			answers.add(in);
			qn++;}
		
		askQ();
	}
	
	//start random just for fun
	public String randomQ(String oriQ){
		Random gen = new Random();
		int t = gen.nextInt(4);
		if(t==0){
			oriQ = "Please insert " + oriQ + "!";
		}else if(t==1){
			oriQ = "Insert the " + oriQ + "!";
		}else if(t==2){
			oriQ = "How much the " + oriQ + "?";
		}else if(t==3){
			oriQ = "You goddamn stupid, I said insert the " + oriQ + "!";
		}
		return oriQ;
	}
	public String randomA(String oriQ){
		Random gen = new Random();
		int t = gen.nextInt(4);
		if(t==0){
			oriQ = "Aaaaaand the answeeer iiiiissss " + oriQ + "!";
		}else if(t==1){
			oriQ = "For you, it's " + oriQ + " friends!";
		}else if(t==2){
			oriQ = "Beep beep beep: " + oriQ;
		}else if(t==3){
			oriQ = "Burp, it's " + oriQ;
		}
		return oriQ;
	}
	
	//end just for fun
	
	public void calculate(){
		result = cont.sendAnswer(answers);
		botPost(randomA(result));
		answers = new ArrayList<String>();
	}
	//end of go click listener
	
	public void resetCalc(){
		if(phase==0){
			botPost("Redo calculation");
			phase = 1;
			qn = 0;
			if(!curQue.isEmpty()){
				askQ();
				changeTyper();
			}
			answers = new ArrayList<String>();
			
		}else if (phase==1){
			botPost("Resetting Calculation");
			qn = 0;
			answers = new ArrayList<String>();
			if(!curQue.isEmpty()){
				askQ();
			}
		
		}
		
		
	}
	
	//asking Question
	public void askQ(){
		if (curQue.size()>qn){
			botPost(randomQ(curQue.get(qn)));
		}else{
			calculate();
			phase=0;
			qn = 0;
			changeTyper();
		}
	}
	
	public void changeTyper(){
		if (phase ==0){
			text.setInputType(0x00000001);
		}else{
			if(calt == 1){
				text.setInputType(0x00000002);
			}else if (calt==2){
				text.setInputType(0x00000001);
				
			}
		}
	}
	
	@SuppressLint("NewApi")
	public void copyResult(){
		/*clipboard.setText(result);*/
		if(result.equals("")){
			Toast.makeText(ChatInterface.this, "No data that can be copied", Toast.LENGTH_SHORT).show();
		}else{
			
		
		
			int currentapiVersion = android.os.Build.VERSION.SDK_INT;
			if (currentapiVersion >= android.os.Build.VERSION_CODES.HONEYCOMB){
			     android.content.ClipboardManager clipboard =  (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
			        ClipData clip = ClipData.newPlainText("result", result);
			        clipboard.setPrimaryClip(clip); 
			} else{
			    android.text.ClipboardManager clipboard = (android.text.ClipboardManager)getSystemService(CLIPBOARD_SERVICE); 
			    clipboard.setText(result);
			}
			Toast.makeText(ChatInterface.this, "Result saved to clipboard", Toast.LENGTH_SHORT).show();	
		}
	}
	
	public void listClick(){
		Intent  i= new Intent(ChatInterface.this, ListFormula.class);
		i.putExtra("fSearch", "all");
		i.putExtra("wall", "");
		startActivity(i); 
	}
	
	public void homeClick(){
		
	}
	
	public boolean isNumber(String ring){
		boolean b = true;
		try{
			Double.parseDouble(ring);
		}catch(Exception e){
			b = false;
		}
		
		return b;
	}
	
	//recreate condition
	public void repost(){
		
	}
	
	public void recreateChat(){
		if(!chatLog.isEmpty()){
			for(Bubble x : chatLog ){
				if(x.getType()==0){
					userPost(x.getInput());
				}else if(x.getType()==1){
					botPost(x.getInput());
				}
			}
		}
		
	}

	@Override
	public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
		// TODO Auto-generated method stub
		goClick();
		return false;
	}
}
