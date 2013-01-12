package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class proses extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proses);
    
    ImageView  btnpeper=(ImageView)findViewById(R.id.menuGbrper);
    btnpeper.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View arg0) {
    			Intent  i= new Intent(proses.this, list.class);
     			startActivity(i);
    			
    }});
    
    
    ImageView  btnhelp=(ImageView)findViewById(R.id.menuGbrHelp);
    btnhelp.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View arg0) {
    			Intent  i= new Intent(proses.this, listhelp.class);
     			startActivity(i);
    			
    }});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
