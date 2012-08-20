package com.list;

//import com.auto.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListviewActivity extends ListActivity
{
    //private static final String[] USERS = null;
    static final String[] USERS = new String[] {"RAHUL","KRUNAL","MANIT","ABC","PQR"
    };
    //String[] USERS = getResources().getStringArray(R.array.countries_array);
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 //       setContentView(R.layout.main);
        
        setListAdapter(new ArrayAdapter<String>(this, R.layout.main,USERS));
      
        ListView listView=getListView();
        listView.setTextFilterEnabled(true);
        
        listView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int i,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),((TextView)view).getText(),Toast.LENGTH_SHORT).show();
			}
		});
    }
}