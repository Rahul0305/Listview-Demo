package com.android.ToDoListNew;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
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

public class ToDoListNew extends Activity implements OnClickListener {

	public ArrayList<String> items=new ArrayList<String>();
	Button add,edit;
	EditText edtv;
	ListView lv;
	int index;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        add= (Button) findViewById(R.id.adbtn);
        edit=(Button) findViewById(R.id.edbtn);
        edtv=(EditText) findViewById(R.id.edt1);
        lv=(ListView) findViewById(R.id.lst1);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1));
        
        add.setOnClickListener(this);
        edit.setOnClickListener(this);
      //  registerForContextMenu(lv);

    }
	//@Override
	public void onClick(View v) {
		
		if(v == add)
		{
			String a=edtv.getText().toString();
			items.add(""+a);
			edtv.setText("");
			
		}
		else if(v == edit)
		{
			String a=edtv.getText().toString();
			items.remove(a);
			//items.add("" +a);
			edtv.setText("");
			add.setEnabled(true);
			edit.setEnabled(true);
			
		}
		lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items));

	}/*
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		if(v.getId()== R.id.lst1)
		{
			menu.setHeaderIcon(R.drawable.sp_4);
			menu.setHeaderTitle("Select one");

			menu.add(0, 1, Menu.NONE,"Edit Selected Items");
			menu.add(0, 2, Menu.NONE,"Delete Selected Items");
			menu.add(0, 3, Menu.NONE,"Exit");
		}
	}
	@Override
	public boolean onContextItemSelected(MenuItem i) {

		int temp=i.getItemId();
		if(temp== 1)
		{
			AdapterContextMenuInfo menuinfo;
			menuinfo=(AdapterContextMenuInfo) i.getMenuInfo();
			index=menuinfo.position;
			add.setEnabled(false);
			edit.setEnabled(true);
			edititems(index);
		}
		else if(temp ==2)
		{
			AdapterView.AdapterContextMenuInfo menuinfo;
			menuinfo=(AdapterContextMenuInfo) i.getMenuInfo();
			index=menuinfo.position;
			removeitem(index);
		}
		
		else
		{
			Toast.makeText(this, "nothing to be selected", Toast.LENGTH_LONG).show();
		}
		return false;
	}
	
	
	private void removeitem(int index1) {

		items.remove(index1);
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
		
	}
	private void edititems(int index2) {
		// TODO Auto-generated method stub
		String edittext1=items.get(index2);
		edtv.setText(""+edittext1);
	}*/
}