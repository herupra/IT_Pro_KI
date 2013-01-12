package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;



public class list extends Activity implements AdapterView.OnItemClickListener{
  	  private ListView listView1;
  	  int pilih=0;
  	  String wall;

	  listheader []listheader_data;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list);
	    	        
	        Intent i = this.getIntent();
	        wall=i.getStringExtra("wall");
	        
	         listheader_data = new listheader[]{
	            new listheader(R.drawable.icon, "Beach"),
	            new listheader(R.drawable.icon, "Board"),
	            new listheader(R.drawable.icon, "Snow"),
	            new listheader(R.drawable.icon, "Hell"),
	            new listheader(R.drawable.icon, "Mark"),
	            new listheader(R.drawable.icon, "Mountain"),
	            new listheader(R.drawable.icon, "Art"),
	            new listheader(R.drawable.icon, "Building"),
	        };
	       
	        listitem adapter = new listitem(this,R.layout.listitem, listheader_data);
	        listView1 = (ListView)findViewById(R.id.listView1);

	        View header = (View)getLayoutInflater().inflate(R.layout.listheader, null);
	        listView1.addHeaderView(header);
	        listView1.setAdapter(adapter);
	        listView1.setOnItemClickListener((OnItemClickListener) this);
	       
	        TextView  txtMarquee=(TextView)findViewById(R.id.txtHeader);
	        txtMarquee.setSelected(true);
	        String kata="Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu ||Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || Wallpaper Menu || ";
	        String POLA =getString(R.string.marquee); 
	        String kalimat=String.format(POLA,TextUtils.htmlEncode(kata));
	        txtMarquee.setText(Html.fromHtml(kalimat));  	        
}



		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			this.pilih=position;
			gantiYN();
		}
	    		
		public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
            	Intent  i= new Intent(list.this, inputrumus.class);
    			i.putExtra("wall", wall);
    			startActivity(i);   
    			finish();
                    return true;
            }
        return super.onKeyDown(keyCode, event);
}

	
		 public void gantiYN(){
				AlertDialog.Builder ad=new AlertDialog.Builder(list.this);
			        	ad.setTitle("Konfirmasi");
			        	ad.setMessage("Apakah benar ingin mengganti wallpaper?");
			        	
			        	ad.setPositiveButton("YA",new OnClickListener(){
			   			@Override
						public void onClick(DialogInterface dialog, int which) {
			   				Toast.makeText(list.this, "Ubah Wallpaper...."+pilih, Toast.LENGTH_LONG).show();	
			   				Intent  i= new Intent(list.this, inputrumus.class);
			   				i.putExtra("wall", String.valueOf(pilih));
			   				startActivity(i);   
			   				finish();
							}});
			        	
			        	ad.setNegativeButton("Tidak",new OnClickListener(){
			    			public void onClick(DialogInterface arg0, int arg1) {
			    			}});
			        	
			        	ad.show();
			}

		 
}