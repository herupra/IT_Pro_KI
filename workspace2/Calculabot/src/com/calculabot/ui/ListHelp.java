package com.calculabot.ui;

import java.util.ArrayList;
import java.util.HashMap;

import com.calculabot.R;
import com.calculabot.R.layout;
import com.calculabot.R.menu;
import com.calculabot.controller.HelpController;
import com.calculabot.model.HelpData;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ListHelp extends ListActivity {
	
	HelpController helpc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_help);
		
		helpc = new HelpController(this);
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		
		int count=1;
		for(HelpData h : helpc.getHelpDatas()){
			HashMap<String, String> map = new HashMap<String, String>();
			
			map.put("id", String.valueOf(count));
			map.put("name", h.getTitle());
        	mylist.add(map);	
		}
		
		

	ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.list_help_item, new String[] { "name" }, 
	new int[] { R.id.txtListMain });
	setListAdapter(adapter);
	
	final ListView lv = getListView();
	lv.setTextFilterEnabled(true);	
	lv.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        	
			HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
			/*String pos=o.get("id");*/
			
			Intent  i= new Intent(ListHelp.this, HelpPage.class);
			i.putExtra("name", helpc.getHelpDatas().get(position).getTitle());//Force
			startActivity(i);   
			}
		}
	);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list_help, menu);
		return true;
	}

}
