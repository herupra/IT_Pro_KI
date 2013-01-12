package com.calculabot.ui;

import com.calculabot.R;
import com.calculabot.R.layout;
import com.calculabot.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable.Creator;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashScreen extends Activity {
    
    
    private final int SPLASH_DISPLAY_LENGHT = 1000;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
   		
   		
   		
   	// file download simulator... a really simple
    new Handler().postDelayed(new Runnable(){
        @Override
        public void run() {
            /* Create an Intent that will start the Menu-Activity. */
            Intent mainIntent = new Intent(SplashScreen.this,Home.class);
            SplashScreen.this.startActivity(mainIntent);
            SplashScreen.this.finish();
        }
    }, SPLASH_DISPLAY_LENGHT);
       	}
   //============================================================================ 
       

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash_screen, menu);
		return true;
	}

}
