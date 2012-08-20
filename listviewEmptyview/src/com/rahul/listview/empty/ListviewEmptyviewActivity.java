package com.rahul.listview.empty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewEmptyviewActivity extends Activity implements OnItemClickListener{
	ListView lview;  
    private final static String month[] = {"January","February","March","April","May",  
        "June","July","August","September","October","November","December"};  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
  
        lview = (ListView) findViewById(R.id.listViewFriends);  
        lview.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,month));  
        lview.setOnItemClickListener(this);  
       //add only this line for Emptyview activity
        //add text view in main.xml
        lview.setEmptyView(findViewById(R.id.empty));  
    }  
  
    public void onItemClick(AdapterView arg0, View arg1, int position, long id) {  
        // TODO Auto-generated method stub  
        Toast.makeText(this,"Item clicked => "+month[position], Toast.LENGTH_SHORT).show();  
    }

}