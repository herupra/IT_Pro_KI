package com.calculabot.ui;

import com.calculabot.R;
import com.calculabot.R.layout;
import com.calculabot.R.menu;
import com.calculabot.controller.HelpController;
import com.calculabot.model.HelpData;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class HelpPage extends Activity {

	TextView title;
	TextView text;
	HelpController helpC;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_page);
		
		title=(TextView)findViewById(R.id.helptitle);
		text=(TextView)findViewById(R.id.helptext);
		
		Intent i = this.getIntent();
		String name = i.getStringExtra("name");
		
		helpC = new HelpController(this);
		
		HelpData help = helpC.searchGetData(name);
		
		title.setText(help.getTitle());
		text.setText(help.getDescription().replace("\\n", "\n"));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_help_page, menu);
		return true;
	}

}
