package com.example.app_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.EditText;

public class DisplayMessageActivity extends Activity {

	@SuppressLint("NewApi")
	@Override 
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Intent intent = getIntent(); 
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); 
		
		setContentView(R.layout.activity_display_message); 
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		{
			getActionBar().setDisplayHomeAsUpEnabled(true); 
			
		}
	}

	public boolean onOptionItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this); 
			return true; 
		}
		return super.onOptionsItemSelected(item); 
	}
	

	

}
