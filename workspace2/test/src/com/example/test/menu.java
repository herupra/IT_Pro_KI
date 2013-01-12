package com.example.test;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends Activity {
	ImageView robot;
	TextView txthasil;
	EditText edFormula;
	String wall;

	int jr=7;
	String[]arNama=new String[jr];
	String[]arRumus=new String[jr];
	String[]arDef=new String[jr];
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    
        robot=(ImageView)findViewById(R.id.menurobot);
        txthasil=(TextView)findViewById(R.id.menuTeksHasil);
        txthasil.setVisibility(View.GONE);
      
        
        Intent i = this.getIntent();
        wall=i.getStringExtra("wall");
        
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
    	arDef[4]="S=size,s=side";
    	
    	arNama[5]="Cube";
    	arRumus[5]="S=s*s*s";
    	arDef[5]="S=size,s=side";
    	
    	arNama[6]="Triangle";
    	arRumus[6]="S=(f*h)/2";
    	arDef[6]="S=size,f=floor,h=height";
    	

    edFormula=(EditText)findViewById(R.id.menuTeksedit);
    //edFormula.setText("=5+5");
    //edFormula.setText("=(5-3)+4");
    //edFormula.setText("=(5*3/2);
    //edFormula.setText("=(2-3+4);
    //edFormula.setText("=(5*3/3)+(2-3+4)-(9/3))*2");
    edFormula.setText("=((5*2)+(2-3+4)-(6/3))*2");
    
    ImageView  menuGbrCari=(ImageView)findViewById(R.id.gbrgo);
    menuGbrCari.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View arg0) {
    			String dti=edFormula.getEditableText().toString();
    			if(dti.indexOf("=")==0){
	    			robot.setVisibility(View.GONE);
	    			txthasil.setVisibility(View.VISIBLE);
	    		
	    			dti=dti.substring(1,dti.length());	//=9+3
	    			
	    			InfixPostfixEvaluator eval = new InfixPostfixEvaluator();
	    			String postfix = eval.convert2Postfix(dti);
	    			
	    			String hsl=String.valueOf(eval.evaluatePostfix(postfix));
	    			Toast.makeText(menu.this, "CALCULATOR @"+dti+"=>"+hsl, Toast.LENGTH_LONG).show(); 
	    			txthasil.setText(dti+"\n="+hsl); 
    			}
    			else{
					String dti2=dti.toLowerCase();//force
    				int ja=0;
					for(int j=0;j<jr;j++){
						String dcr=arNama[j].toLowerCase();
    					if(dcr.indexOf(dti2)>=0){
    						Toast.makeText(menu.this, "Cari Rumus "+dti, Toast.LENGTH_LONG).show(); 
    						Intent  i= new Intent(menu.this, listrumus.class);
    		    			i.putExtra("cariRumus", dti);
    		    			i.putExtra("wall", wall);
    		    			startActivity(i);   
    		    			ja=ja+1;
    						break;
    					} 
    					
    				}
					
					if(ja==0){
						Toast.makeText(menu.this, "Maaf, data "+dti+" Tidak ditemukan !", Toast.LENGTH_LONG).show();
						
					}
	    			bersih();
    				
    			}
    }});
   
    txthasil.setOnClickListener(new View.OnClickListener() {
		public void onClick(View arg0) {
			bersih();
	}});
    
    ImageView  menugbrFormula=(ImageView)findViewById(R.id.widget36);
    menugbrFormula.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View arg0) {
    			Intent  i= new Intent(menu.this, listrumus.class);
    			i.putExtra("cariRumus", "all");
    			i.putExtra("wall", wall);
    			startActivity(i);    			
    }});
    

    
    
    ImageView  btnhelp=(ImageView)findViewById(R.id.widget31);
    btnhelp.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View arg0) {
    			Intent  i= new Intent(menu.this, listhelp.class);
     			startActivity(i);
    			
    }});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    void bersih(){
    	txthasil.setText("");
		edFormula.setText("");
		robot.setVisibility(View.VISIBLE);
		txthasil.setVisibility(View.GONE);
    }
    
    public void selesai(){
    	new AlertDialog.Builder(this)
		.setTitle("Hasil Rumus ")
		.setMessage("Hasil proses")
		.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dlg, int sumthin) {
			}})
		.show();
    }

    
}
