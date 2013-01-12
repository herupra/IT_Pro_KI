package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class listrumus  extends ListActivity{
	String wall,cariRumus;
	int jr=7;
	int ja=0;
	String[]arNama=new String[jr];
	String[]arRumus=new String[jr];
	String[]arDef=new String[jr];
	
	String[]arNama3=new String[jr];
	String[]arRumus3=new String[jr];
	String[]arDef3=new String[jr];
	
	String[]arNama2;
	String[]arRumus2;
	String[]arDef2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmain);

       Intent i = this.getIntent();
        cariRumus=i.getStringExtra("cariRumus");
        wall=i.getStringExtra("wall");

	ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
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
	
	
	if(cariRumus.equals("all")){
		ja=jr;
		arNama2=new String[ja];
		arRumus2=new String[ja];
		arDef2=new String[ja];
		for(int k=0;k<ja;k++){
			arNama2[k]=arNama[k];
			arDef2[k]=arDef[k];
			arRumus2[k]=arRumus[k];
		  }
	}
	else{
		ja=0;
		for(int j=0;j<jr;j++){
			String dn=arNama[j].toLowerCase();
			String dc=cariRumus.toLowerCase();
			if(dn.indexOf(dc)>=0){
				arNama3[ja]=arNama[j];
				arRumus3[ja]=arRumus[j];
				arDef3[ja]=arDef[j];
				ja=ja+1;	
			} 
		}
	
	arNama2=new String[ja];
	arRumus2=new String[ja];
	arDef2=new String[ja];
	for(int k=0;k<ja;k++){
		arNama2[k]=arNama3[k];
		arDef2[k]=arDef3[k];
		arRumus2[k]=arRumus3[k];
	  }
	}
	
	
	for(int n=0;n<ja;n++){
					HashMap<String, String> map = new HashMap<String, String>();	
					int m=n+1;
					String nama=arNama2[n];
					String rumus=arRumus2[n];
					String definisi=arDef2[n];
					
					String gab=nama+" :"+rumus;
					map.put("id", String.valueOf(m));
		        	map.put("Formula", gab);
		        	map.put("Def", definisi);
		        	mylist.add(map);	
	}

ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.listitemrumus, new String[] { "Formula", "Def" }, 
new int[] { R.id.txtListMain, R.id.txtListItem });
setListAdapter(adapter);

final ListView lv = getListView();
lv.setTextFilterEnabled(true);	
lv.setOnItemClickListener(new OnItemClickListener() {
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        	
		HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
		String pos=o.get("id");
		
		Toast.makeText(listrumus.this, "Rumus :"+ arNama2[position] + " telah dipilih....", Toast.LENGTH_LONG).show(); 
		Intent  i= new Intent(listrumus.this, inputrumus.class);
		i.putExtra("wall", wall);
		i.putExtra("nama", arNama2[position]);//Force
		startActivity(i);   
		
	}});
}	       
    

}