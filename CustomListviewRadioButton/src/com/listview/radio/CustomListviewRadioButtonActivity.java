package com.listview.radio;
  
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
 
 

public class CustomListviewRadioButtonActivity extends Activity implements OnItemClickListener{
	
	 
	//private ImageAdapter  adapter; 
	
	private static String month[] = {"January","February","March","April","May",  
        "June","July","August","September",  
        "October","November","December"};  
	 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    	ListView lstvw = (ListView) findViewById(R.id.listView);
    	 
    	 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, month);

    	
    	 //adapter = new ImageAdapter(this, month);  
    	 lstvw.setAdapter(adapter);  
    	  
    	 lstvw.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    	 
    	 lstvw.setOnItemClickListener(this);
    	  
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		// TODO Auto-generated method stub
		
		  Toast.makeText(this, "Title => "+month[position], Toast.LENGTH_SHORT).show();
	}
 
	 
}