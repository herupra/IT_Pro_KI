package com.example.test;





import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;

public class Main extends Activity {
	MediaPlayer  mp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(Main.this, R.raw.startup);
        mp.start();
        LOADING100();
    }
    ProgressDialog progressBar;
   	private int progressBarStatus = 0;
   	private Handler progressBarHandler = new Handler();
   	int fileSize = 0;
       public void LOADING100() {
   		progressBar = new ProgressDialog(this);
   		progressBar.setCancelable(true);
   		progressBar.setMessage("Process Opening...");// STYLE_SPINNER
   		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
   		progressBar.setProgress(0);
   		progressBar.setMax(100);
   		progressBar.show();
   		progressBarStatus = 0;
   		
   		
   		new Thread(new Runnable() {
   			public void run() {
   				while (progressBarStatus < 100) {
   					// process some tasks
   					progressBarStatus = doSomeTasks();
   					// your computer is too fast, sleep 1 second
   					try {Thread.sleep(1000);} 
   					catch (InterruptedException e) {e.printStackTrace();}
   					// Update the progress bar
   					progressBarHandler.post(new Runnable() {
   						public void run() {progressBar.setProgress(progressBarStatus);}});}
   				// ok, file is downloaded,
   				if (progressBarStatus >= 100) {
   					// sleep 2 seconds, so that you can see the 100%
   					try {Thread.sleep(2000);} 
   					catch (InterruptedException e) {e.printStackTrace();}
   					progressBar.dismiss();
   					 setSplash();
   				}}}).start();
   	}		
   	// file download simulator... a really simple
   	public int doSomeTasks() {
   		while (fileSize <= 1000000) {
   		fileSize++;
   			if (fileSize == 100000) {return 10;} 
   			else if (fileSize == 200000) {return 20;} 
   			else if (fileSize == 300000) {return 30;}
   			// ...add your own
   		}
   		return 100;
   	}	
       public void setSplash(){
          	new Thread() { 
       	  public void run() { 
       	     try{Thread.sleep(5000);} 
       	     catch (Exception e) {} 
       	  Intent i = new Intent(Main.this, menu.class); //menu
	           Main.this.finish();
	           //i.putExtra("wall", "default");
	           startActivity(i);  
       	       //    try{mp.stop();}
       	       //    catch(Exception rr){}
       	    } }.start();  
       	}
   //============================================================================ 
       public void LOADINGSLEEP(){
          	new Thread() { 
       	  public void run() { 
       	     try{Thread.sleep(1000);} 
       	     catch (Exception e) {} 
       	           Intent i = new Intent(Main.this, menu.class); //menu
       	           Main.this.finish();
       	         //  i.putExtra("wall", "default");
       	           startActivity(i);  
       	     //      try{mp.stop();}
       	      //     catch(Exception rr){}
       	    } }.start();  
       	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
