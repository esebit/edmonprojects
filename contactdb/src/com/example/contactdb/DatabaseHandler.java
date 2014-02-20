package com.example.contactdb;

import com.example.contactdb.MainActivity.Contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
	//create a variable for the database version 
	private static final int DATABASE_VERSION = 1; 
	
	//Database Name variable
	private static final String DATABASE_NAME = "ContactsManager"; 
	
	//Contact table name variable that is inside the database
	private static final String TABLE_CONTACTS = "contacts"; 
	
	//contacts table columns names 
	private static final String KEY_ID = "id"; 
	private static final String KEY_NAME = "name"; 
	private static final String KEY_PH_NO = "phone_number"; 
	
	
	
	public DatabaseHandler(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/*	Create a function that would create the table in the database
		this function would create the table with the column names inside it when called
		The SQL queries is creating the table column and their datatypes
	*/
	@Override 
	public void onCreate(SQLiteDatabase db)
	{
		String CREATE_CONTACTS_TABLE = "CREATE TABLE" + TABLE_CONTACTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+  KEY_PH_NO + " TEXT" + ")"; 
		db.execSQL(CREATE_CONTACTS_TABLE); 
	}
	
	/*
	 	Create a function that would delete and update existing tables if you already have tables there.
	 */
	@Override 
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROB TABLE IF EXISTS " + TABLE_CONTACTS); 
		
		//create the table again
		onCreate(db); 
	}
	
	/*
	 create a function that would add new contacts to the database 
	 pass in the contact variable as object
	 */
	public void addContact(Contact contact)
	{
		SQLiteDatabase db = this.getWritableDatabase(); 
		
		ContentValues values = new ContentValues(); 
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPhoneNumber()); 
		
		//insert new rows to in tables
		db.insert(TABLE_CONTACTS, null, values); 
		//close the database after inserting 
		db.close();
	}
	
	
	/*
	 	Create a function that would read data from the database
	 */
	public int getContactsCount()
	{
		String countQuery = "SELECT * FROM " + TABLE_CONTACTS; 
		SQLiteDatabase db = this.getReadableDatabase(); 
		Cursor cursor = db.rawQuery(countQuery, null); 
		cursor.close(); 
		
		//return the variable count
		return cursor.getCount(); 
	}
	
	
}

