package com.rahul.customlistview;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CustomlistviewActivity extends Activity implements OnItemClickListener{
	
	private ArrayList<String> listCountry;
	private ArrayList<Integer> listFlag;
	
	ListView lview3;  
	private ListviewAdapter adapter; 
  
    /*private static String month[] = {"January","February","March","April","May",  
        "June","July","August","September",  
        "October","November","December"};  
  
    private static String desc[] = {"Month - 1","Month - 2","Month - 3",  
        "Month - 4","Month - 5","Month - 6","Month - 7",  
        "Month - 8","Month - 9","Month - 10","Month - 11","Month - 12"};  
  */
	private static String month[] = {"Add","Delete","Down","Information","Help",  
        "Download","Mail","Search","Settings"};  
  
    private static String desc[] = {"Add desc","Delete desc","Down desc",  
        "Information desc","Help desc","Download desc","Mail desc",  
        "Search desc","Settings desc"};  
  
    private static int icons[] = {R.drawable.ic_add, R.drawable.ic_delete,  
        R.drawable.ic_down, R.drawable.ic_info, R.drawable.ic_help,  
        R.drawable.ic_download, R.drawable.ic_mail,  
        R.drawable.ic_search, R.drawable.ic_settings};  
	
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
  
        lview3 = (ListView) findViewById(R.id.listView3);  
        
        adapter = new ListviewAdapter(this, month, desc, icons);  
        lview3.setAdapter(adapter);  
        lview3.setOnItemClickListener(this);
        
        //for context menu
        registerForContextMenu(lview3);
        
    }
    
    //start from here context menu//
    
    @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("select");
		menu.add(0, v.getId(), 0, "Action 1");
		menu.add(0, v.getId(), 0, "Action 2");
		menu.add(0, v.getId(), 0, "Action 3");
	}
    
   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
        ContextMenuInfo menuInfo) {
      if (v.getId()==R.id.listView3) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle(month[info.position]);
        String[] menuItems = getResources().getStringArray(R.array.menu);
        for (int i = 0; i<menuItems.length; i++) {
          menu.add(Menu.NONE, i, i, menuItems[i]);
        }
      }
    }*/
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
	}
	
	//complete context menu//
		
	@Override  
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {  
        // TODO Auto-generated method stub  
        Toast.makeText(this, "Title => "+month[position]+" n Description => "+desc[position], Toast.LENGTH_SHORT).show();  
    }  
}  