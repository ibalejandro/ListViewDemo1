package com.example.listviewdemo1;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.Menu;
import android.view.View;

public class MainActivity extends ListActivity {

	String[] countries;
	String country;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		countries = getResources().getStringArray(R.array.countries);
		this.setListAdapter(new ArrayAdapter<String>(
				this,  //en qué actividad se va a utilizar
				R.layout.list_element,   //cuál es la vista asociada a esa actividad
				R.id.countryName,    //cual es el elemento base para de ahí generar la lista
				countries  //qué información va a contener la lista
				));
		
		ListView listView = getListView();
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View clickView, int position,
					long id) {
				// TODO Auto-generated method stub
				country = countries[position];
				Toast.makeText(MainActivity.this, String.format("%s was chosen.", country), 
				Toast.LENGTH_SHORT).show();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
