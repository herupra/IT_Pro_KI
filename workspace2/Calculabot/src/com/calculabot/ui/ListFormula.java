package com.calculabot.ui;

import java.util.ArrayList;
import java.util.HashMap;

import com.calculabot.model.FormulaBase;

import com.calculabot.R;
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



public class ListFormula  extends ListActivity{
	String wall,fsearch;

	//The searched 
	ArrayList<String> fNames;
	ArrayList<Integer> fTypes;
	ArrayList<String> fInfo;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_formula);

        Intent i = this.getIntent();
        fsearch=i.getStringExtra("fSearch");
        wall=i.getStringExtra("wall");
        
        
        
        FormulaBase base = new FormulaBase();
        ArrayList<String> ArrayBase = base.getNames();
        int jab=ArrayBase.size();
       
	ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
	
	if(fsearch.equals("all")){
		fNames = ArrayBase;
		fTypes = base.getTypes();
		fInfo = base.getInfo();
	}
	else{
		fNames = new ArrayList<String>();
		fTypes = new ArrayList<Integer>();
		fInfo = new ArrayList<String>();
		
		ArrayList<String> lInfo = base.getInfo();
		ArrayList<Integer> lType = base.getTypes();
		for(int j=0;j<ArrayBase.size();j++){
			String dn=ArrayBase.get(j).toLowerCase();
			String dc=fsearch.toLowerCase();
			if(dn.indexOf(dc)>=0){
				fNames.add(ArrayBase.get(j));	
				fTypes.add(lType.get(j));
				fInfo.add(lInfo.get(j));
			} 
		}
	}
	
	for(int n=0;n<fNames.size();n++){
					HashMap<String, String> map = new HashMap<String, String>();	
					int m=n+1;
					String name=fNames.get(n);
					String types= typer(fTypes.get(n));
					String info= fInfo.get(n);
					
					String gab=name+" :";
					map.put("id", String.valueOf(m));
		        	map.put("formula", gab);
		        	map.put("info", info);
		        	mylist.add(map);	
	}

ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.listitemrumus, new String[] { "formula", "info" }, 
new int[] { R.id.txtListMain, R.id.txtListItem });
setListAdapter(adapter);

final ListView lv = getListView();
lv.setTextFilterEnabled(true);	
lv.setOnItemClickListener(new OnItemClickListener() {
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        	
		HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
		String pos=o.get("id");
		
		Toast.makeText(ListFormula.this, "Formula :"+ fNames.get(position) + " has choosen", Toast.LENGTH_LONG).show(); 
		Intent  i= new Intent(ListFormula.this, ChatInterface.class);
		i.putExtra("wall", wall);
		i.putExtra("name", fNames.get(position));//Force
		startActivity(i);
		
		
		ListFormula.this.finish();
	}});
}	       
    public String typer(int in){
    	if(in==1){
    		return "Number";
    	}else if(in==2){
    		return "String";
    	}
    	return "";
    	
    }
    

}