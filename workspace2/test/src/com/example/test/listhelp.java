package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class listhelp extends Activity implements AdapterView.OnItemClickListener{
  	  private ListView listView1;

	  listheader []listheader_data;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list);
	    	        
	         listheader_data = new listheader[]{
	            new listheader(R.drawable.icon, "Changing Wallpaper"),
	            new listheader(R.drawable.icon, "Simple Calculation"),
	            new listheader(R.drawable.icon, "Using Copy Result"),
	            new listheader(R.drawable.icon, "Using List Formula"),
	            new listheader(R.drawable.icon, "Using Reset Calculation"),
	            new listheader(R.drawable.icon, "Using Search Formula"),
	            new listheader(R.drawable.icon, "About Us")
	        };
	       
	        listitem adapter = new listitem(this,R.layout.listitem, listheader_data);
	        listView1 = (ListView)findViewById(R.id.listView1);

	        View header = (View)getLayoutInflater().inflate(R.layout.listheader, null);
	        listView1.addHeaderView(header);
	        listView1.setAdapter(adapter);
	        listView1.setOnItemClickListener((OnItemClickListener) this);
	       
	        TextView  txtMarquee=(TextView)findViewById(R.id.txtHeader);
	        txtMarquee.setSelected(true);
	        String kata="Help Menu || Help Menu || Help Menu || Help Menu || Help Menu || Help Menu || Help Menu || Help Menu || Help Menu || Help Menu || Help Menu || ";
	        String POLA =getString(R.string.marquee); 
	        String kalimat=String.format(POLA,TextUtils.htmlEncode(kata));
	         txtMarquee.setText(Html.fromHtml(kalimat));  	        
	  
	         
}



		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			String pilih="";
			position=position-1;
			if(position==0){pilih="Changing Wallpaper";
			Intent  i= new Intent(listhelp.this,changewall.class);
 			startActivity(i);
 			}
			else if(position==1){pilih="Simple Calculation";
			Intent  i= new Intent(listhelp.this,simpcalc.class);
 			startActivity(i);}
			else if(position==2){pilih="Using Copy Result";	
			Intent  i= new Intent(listhelp.this,copres.class);
 			startActivity(i);}
			else if(position==3){pilih="Using List Formula";
			Intent  i= new Intent(listhelp.this,listform.class);
 			startActivity(i);}
			else if(position==4){pilih="Using Reset Calculation";
			Intent  i= new Intent(listhelp.this,rescalc.class);
 			startActivity(i);}
			else if(position==5){pilih="Using Search Formula";
			Intent  i= new Intent(listhelp.this,srcform.class);
 			startActivity(i);}
			else if(position==6){pilih="About Us";
			Intent  i= new Intent(listhelp.this,aboutus.class);
 			startActivity(i);}
			else{
				pilih="Pilih Salah Satu";
				}
	    		
		}	
}