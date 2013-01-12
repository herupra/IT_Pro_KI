package com.example.test;



import android.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class inputrumus extends Activity {
	int jr=7;
	int ja=0;
	String[]arNama=new String[jr];
	String[]arRumus=new String[jr];
	String[]arDef=new String[jr];

	String[]aF;
	String[]aD;
	
	int n=5;
	int u=1;
	ImageView[] g=new ImageView[n];	
	TextView[] t=new TextView[n];
	ImageView[] j=new ImageView[n];
	EditText[] e=new EditText[n];
	ImageView btnGo;
int position=0;	
int jd=10;
int i=0;
String wall,nama;
LinearLayout bgrl;	
/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputrumus);
        
        arNama[0]="Force";
    	arRumus[0]="F=m.a";
    	arDef[0]="F=Force,m=Mass,a=Acceleration";
    	
    	arNama[1]="Torrent";
    	arRumus[1]="I=V/r";
    	arDef[1]="I=Torrent,V=Voltage,r=resistance";

    	arNama[2]="Acceleration";
    	arRumus[2]="a=F/m";
    	arDef[2]="F=Force,m=Mass,a=Acceleration";

    	arNama[3]="Mass";
    	arRumus[3]="m=F/a";
    	arDef[3]="F=Force,m=Mass,a=Acceleration";

    	arNama[4]="Square";
    	arRumus[4]="S=s*s";
    	arDef[4]="S=sizes,s=side";
    	
    	arNama[5]="Cube";
    	arRumus[5]="S=s*s*s";
    	arDef[5]="S=sizes,s=side";
    	
    	arNama[6]="Triangle";
    	arRumus[6]="S=(f*h)/2";
    	arDef[6]="S=size,f=floor,h=height";
    	
    	btnGo=(ImageView)findViewById(R.id.btnGo);
    	btnGo.setOnClickListener(new View.OnClickListener() {
     		public void onClick(View arg0) {
     			  try{lihat();}
	               catch(Exception e){}			
     }});
     
    	
    	
    	g[0]=(ImageView)findViewById(R.id.hGTanya1);
        g[1]=(ImageView)findViewById(R.id.hGTanya2);
        g[2]=(ImageView)findViewById(R.id.hGTanya3);
        g[3]=(ImageView)findViewById(R.id.hGTanya4);
        g[4]=(ImageView)findViewById(R.id.hGTanya5);
        
        j[0]=(ImageView)findViewById(R.id.hGJawab1);
        j[1]=(ImageView)findViewById(R.id.hGJawab2);
        j[2]=(ImageView)findViewById(R.id.hGJawab3);
        j[3]=(ImageView)findViewById(R.id.hGJawab4);
        j[4]=(ImageView)findViewById(R.id.hGJawab5);
        
        t[0]=(TextView)findViewById(R.id.hTTanya1);
        t[1]=(TextView)findViewById(R.id.hTTanya2);
        t[2]=(TextView)findViewById(R.id.hTTanya3);
        t[3]=(TextView)findViewById(R.id.hTTanya4);
        t[4]=(TextView)findViewById(R.id.hTTanya5);
        
        e[0]=(EditText)findViewById(R.id.hEJawab1);
        e[1]=(EditText)findViewById(R.id.hEJawab2);
        e[2]=(EditText)findViewById(R.id.hEJawab3);
        e[3]=(EditText)findViewById(R.id.hEJawab4);
        e[4]=(EditText)findViewById(R.id.hEJawab5);
        
 
        
    	bgrl=(LinearLayout)findViewById(R.id.bgrIR);
        Intent i = this.getIntent();
        wall=i.getStringExtra("wall");
        nama=i.getStringExtra("nama");

    	TextView hJudul=(TextView)findViewById(R.id.hJudul);
    	hJudul.setText(nama);
    	TextView hketerangan=(TextView)findViewById(R.id.hketerangan);    	
    	

    	
            for(int k=0;k<jr;k++){
        	if(arNama[k].equalsIgnoreCase(nama)){
        		position=k;
        		break;
        	}
        }
            
    	String pilih=arDef[position]+",";
		String[]arData=pilih.split(",");
		
		hketerangan.setText(arRumus[position]);
		
		ja=arData.length;
		aF=new String[ja];
		aD=new String[ja];
		for(int k=0;k<ja;k++){
			arData[k]=arData[k]+"=";
			String[]mb=new String[2];
			mb=arData[k].split("=");
			aF[k]=mb[0];
			aD[k]=mb[1];
		}		
//-----------------------------------------------------------------------------        
		              		
    for(int k=0;k<n;k++){
    	g[k].setVisibility(View.GONE);
    	j[k].setVisibility(View.GONE);
    	t[k].setVisibility(View.GONE);
    	e[k].setVisibility(View.GONE);
    }
    
  
    
        if(wall.equalsIgnoreCase("1")){bgrl.setBackgroundResource(R.drawable.beach);}
        else if(wall.equalsIgnoreCase("2")){bgrl.setBackgroundResource(R.drawable.board);}
        else if(wall.equalsIgnoreCase("3")){bgrl.setBackgroundResource(R.drawable.snow);}
        else if(wall.equalsIgnoreCase("4")){bgrl.setBackgroundResource(R.drawable.hell);}
        else if(wall.equalsIgnoreCase("5")){bgrl.setBackgroundResource(R.drawable.mark);}
        else if(wall.equalsIgnoreCase("6")){bgrl.setBackgroundResource(R.drawable.mountain);}
        else if(wall.equalsIgnoreCase("7")){bgrl.setBackgroundResource(R.drawable.art);}
        else if(wall.equalsIgnoreCase("8")){bgrl.setBackgroundResource(R.drawable.bg6);}
        else {bgrl.setBackgroundResource(R.drawable.background);}
        
        
        
        
    ImageView  btnpeper=(ImageView)findViewById(R.id.ImageView03);
    btnpeper.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View arg0) {
    			Intent  i= new Intent(inputrumus.this, list.class);
     			startActivity(i);
    			
    }});
    
    ImageView  btnlistrms=(ImageView)findViewById(R.id.ImageView01);
    btnlistrms.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View arg0) {
    			Intent  i= new Intent(inputrumus.this, listrumus.class);
    			i.putExtra("cariRumus", "all");
    			startActivity(i);    	
    			finish();
    }});
    
    ImageView  btnmenu=(ImageView)findViewById(R.id.ImageView02);
    btnmenu.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View arg0) {
    			Intent  i= new Intent(inputrumus.this, menu.class);
     			startActivity(i);
     			finish();
    }});
    
   lihat();
    }
    
    
void lihat(){
	if(u > ja){selesai();}
	else{
		Toast.makeText(inputrumus.this, nama+" Index "+u+" dikerjakan....", Toast.LENGTH_LONG).show(); 	
	g[u].setVisibility(View.VISIBLE);
	j[u].setVisibility(View.VISIBLE);
	t[u].setVisibility(View.VISIBLE);t[u].setText("Masukkan besaran "+aF[u]+" ("+aD[u]+")");
	e[u].setVisibility(View.VISIBLE);
	u=u+1;
	}
	
	
}    
    
public void selesai(){
	new AlertDialog.Builder(this)
	.setTitle("Hasil Rumus "+nama)
	.setMessage("Hasil proses: "+arDef[position])
	.setNeutralButton("OK", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dlg, int sumthin) {
		}})
	.show();
}

}