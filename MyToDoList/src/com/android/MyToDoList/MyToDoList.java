package com.android.MyToDoList;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MyToDoList extends Activity implements OnClickListener {

	ArrayList<String> items=new ArrayList<String>();
	Button add1,edit1;
	EditText edtxt;
	ListView lstvw;
	int index;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        add1=(Button) findViewById(R.id.add);
        edit1=(Button) findViewById(R.id.edit);
        edtxt=(EditText) findViewById(R.id.edittxt);
        lstvw=(ListView) findViewById(R.id.listvw);
        add1.setOnClickListener(this);
        edit1.setOnClickListener(this);
       registerForContextMenu(lstvw);
    }




//	@Override
	public void onClick(View v) {

		if(v== add1)
		{
			String a=edtxt.getText().toString();
			if(a.length()>0)
			{
			items.add(a);
			edtxt.setText("");
			}
			else
			{
				Toast.makeText(getApplicationContext(), "enter some text", Toast.LENGTH_SHORT).show();
			}
		}
		else if(v== edit1)
		{
			String a=edtxt.getText().toString();
			if(a.length()>0)
			{	
				if(items.contains(a)){
					items.remove(a);	
				}
				else{
					Toast.makeText(getApplicationContext(), "not", Toast.LENGTH_SHORT).show();
				}
				
				//items.add(""+a);
				
				edtxt.setText("");
				add1.setEnabled(true);
				edit1.setEnabled(true);
			/*	if(a.equals(items)){
								
					}
					else{
						Toast.makeText(getApplicationContext(), "not avilable", Toast.LENGTH_SHORT).show();
						}*/
				
			}else{
				Toast.makeText(getApplicationContext(), "pls choose data that u want 2 delete", Toast.LENGTH_SHORT).show();
			}
			
		}
		lstvw.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
	}




	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		if(v.getId() == R.id.listvw)
		{
			
			menu.setHeaderIcon(R.drawable.icon);
			menu.setHeaderTitle("Select one");
			menu.add(0, 1, Menu.NONE, "Edit");
			menu.add(0, 2, Menu.NONE, "Delete");
			menu.add(0, 3, Menu.NONE, "Exit");
			
		}

	}




	@Override
	public boolean onContextItemSelected(MenuItem i) {
		// TODO Auto-generated method stub
		//return super.onContextItemSelected(item);
		int temp=i.getItemId();
		
		if(temp==1)
		{
			AdapterContextMenuInfo menuinfo;
			menuinfo=(AdapterContextMenuInfo) i.getMenuInfo();
			index=menuinfo.position;
			add1.setEnabled(false);
			edit1.setEnabled(true);
			edititem(index);
		}

		else if(temp==2)
		{
			AdapterView.AdapterContextMenuInfo menuinfo;
			menuinfo=(AdapterContextMenuInfo) i.getMenuInfo();
			index=menuinfo.position;
			removeitem(index);
		}
		else
		{
			Toast.makeText(this,"not selected any option",Toast.LENGTH_LONG).show();
		}

		return false;
	}

	private void removeitem(int index1) {
		// TODO Auto-generated method stub
		
		items.remove(index1);
		lstvw.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
	}




	private void edititem(int index2) {
		// TODO Auto-generated method stub
		String str = items.get(index2);
		edtxt.setText(""+str);
	}
}