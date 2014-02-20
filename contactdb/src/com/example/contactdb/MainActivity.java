package com.example.contactdb;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	EditText name, id, phone_number; 
	Button addcontact, count; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		name  = (EditText) findViewById(R.id.name); 
		id  = (EditText) findViewById(R.id.id); 
		phone_number  = (EditText) findViewById(R.id.phone_number); 
		addcontact = (Button) findViewById(R.id.addcontact); 
		count = (Button) findViewById(R.id.count);
		*/
		
		//The on click listeners creates switching case that would do something 
		//When addcontact and count buttons are pressed
		//addcontact = (Button) findViewById(R.id.bSQLopenView); 
		addcontact.setOnClickListener(this);
		count.setOnClickListener(this);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class Contact
	{
		//private variables 
		int _id; 
		String _name; 
		String _phone_number; 
		
		//Create an empty constructor 
		public Contact()
		{
			
		}
		
		//Create constructor A for getting the id, name and phone number
		public Contact (int id, String name, String _phone_number)
		{
			this._id = id; 
			this._name = name; 
			this._phone_number = _phone_number; 
		}
		//Create constructor B for getting the name and phone number 
		public Contact (String name, String _phone_number)
		{
			this._name = name; 
			this._phone_number = _phone_number; 
		}
		
		//Create a constructor for getting ID
		public int getID()
		{
			return this._id; 
		}
		//Create a constuctor for setting ID
		public void setID(int id)
		{
			this._id = id; 
		}
		
		//Create a constuctor for getting name
		public String getName()
		{
			return this._name; 
		}
		//Create a constructor for setting name
		public String setName(String name)
		{
			return this._name;
		}
		
		//create a constuctor for getting the phone number
		public String getPhoneNumber()
		{
			return this._phone_number; 
		}
		//Create a constuctor for the phone number
		public String setPhoneNumber(String phone_number)
		{
			return this._phone_number = phone_number; 
		}
		
	}
	
	
	public void onClick(View arg0)
	{	/*
		switch (arg0.getId())
		{
			case R.id.addcontact:
				//add user to contact database when addcontact button is pressed 
				break; 
			case R.id.count:
				//count the number of users in database when count button is pressed 
				break; 
		}*/
	}
	
	
}
