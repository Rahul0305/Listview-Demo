package com.rahul.optionmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionmenuActivity extends Activity {
    /** Called when the activity is first created. */
	/*private int group1Id = 1;

	int homeId = Menu.FIRST;
	int profileId = Menu.FIRST +1;
	int searchId = Menu.FIRST +2;
	int dealsId = Menu.FIRST +3;
	int helpId = Menu.FIRST +4;
	int contactusId = Menu.FIRST +5;
*/	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
    	
    	MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //return super.onCreateOptionsMenu(menu);
    	
        menu.add("hello").setIcon(R.drawable.ic_launcher);
        menu.add("patel").setIcon(R.drawable.ic_launcher);
        menu.add("abc").setIcon(R.drawable.ic_launcher);
        menu.add("hello").setIcon(R.drawable.ic_launcher);
        menu.add("").setIcon(R.drawable.ic_launcher);
        menu.add("").setIcon(R.drawable.ic_launcher);
        
    	/*menu.add(group1Id, homeId, homeId, "hello").setIcon(R.drawable.ic_launcher);
        menu.add(group1Id, profileId, profileId, "patel").setIcon(R.drawable.ic_launcher);
        menu.add(group1Id, searchId, searchId, "abc").setIcon(R.drawable.ic_launcher);
        menu.add(group1Id, dealsId, dealsId, "hello").setIcon(R.drawable.ic_launcher);
        menu.add(group1Id, helpId, helpId, "").setIcon(R.drawable.ic_launcher);
        menu.add(group1Id, contactusId, contactusId, "").setIcon(R.drawable.ic_launcher);
        */
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
        case R.id.feeds:
        	Toast msg = Toast.makeText(OptionmenuActivity.this, "feeds", Toast.LENGTH_LONG);
      	    msg.show();
      	    return true;
        
        case R.id.friends:
        	Toast msg1 = Toast.makeText(OptionmenuActivity.this, "friends", Toast.LENGTH_LONG);
      	    msg1.show();
      	    return true;
        case R.id.about:
        	Toast msg2 = Toast.makeText(OptionmenuActivity.this, "about", Toast.LENGTH_LONG);
      	    msg2.show();
      	    return true;
         
        case 2:
        	
          	 Toast msg3 = Toast.makeText(OptionmenuActivity.this, "Menu 1", Toast.LENGTH_LONG);
          	    msg3.show();
          	    return true;
              
        }
        return true;
    }
}