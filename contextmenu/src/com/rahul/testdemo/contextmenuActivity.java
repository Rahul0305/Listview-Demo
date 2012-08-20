package com.rahul.testdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class contextmenuActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// button long press open context menu
		Button btn = (Button) findViewById(R.id.button1);
		registerForContextMenu(btn);
		
		
		// listview context menu
		
		ListView lv = (ListView) this.findViewById(R.id.listView);
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), 
    												android.R.layout.simple_list_item_1,
    												new String[] {"List Item 1", "List Item 2",
    																"List Item 3", "List Item 4",
    																"List Item 5", "List Item 6",
    																"List Item 7", "List Item 8"});
    	lv.setAdapter(adapter);
    	registerForContextMenu(lv);
		
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Delete/Rename");
		menu.add(0, v.getId(), 0, "Delete");
		menu.add(0, v.getId(), 0, "Rename");
		menu.add(0, v.getId(), 0, "Send Mail");
	}
	public boolean onContextItemSelected(MenuItem item) {  
	    if(item.getTitle()=="Delete"){
	            AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
	            delete(info.id);
	    }   

	    else if(item.getTitle()=="Rename"){
	            AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
	          //  rename(info.id);
	    } 
	    else if(item.getTitle()=="Send Mail"){
	            AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
	           // sendMail(info.id);
	    }

	    else {return false;}  
	    return true;  
	}  
	 private void delete(final long rowId) {
		   if (rowId>=0) {
		       new AlertDialog.Builder(this)
		        .setTitle("Delete File..")
		        .setMessage("Are you sure you want to Delete it!")
		        .setPositiveButton("Yes",
		        		 new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								
							}
		        }
		   
		   );
	 	}
	 }   
/*
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if (item.getTitle() == "Action 1") {
			function1(item.getItemId());
		} else if (item.getTitle() == "Action 2") {
			function2(item.getItemId());
		} else {
			return false;
		}
		return true;
	}

	public void function1(int id) {
		Toast.makeText(this, "function 1 called", Toast.LENGTH_SHORT).show();
	}

	public void function2(int id) {
		Toast.makeText(this, "function 2 called", Toast.LENGTH_SHORT).show();
	}*/
}