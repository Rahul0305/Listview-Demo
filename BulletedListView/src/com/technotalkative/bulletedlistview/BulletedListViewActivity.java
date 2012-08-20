package com.technotalkative.bulletedlistview;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BulletedListViewActivity extends Activity {
    /** Called when the activity is first created. */
	
	ArrayList<String> listCountry;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
            prepareList();
            
            ListView listView = (ListView)findViewById(R.id.listView);
            listView.setAdapter(new ArrayAdapter<String>(
                                this, R.layout.list_item, listCountry));
    }
    
    public void prepareList()
    {
          listCountry = new ArrayList<String>();
          listCountry.add("India");
          listCountry.add("Brazil");
          listCountry.add("Canada");
          listCountry.add("China");
          listCountry.add("France");
          listCountry.add("Germany");
          listCountry.add("Iran");
          listCountry.add("Italy");
          listCountry.add("Japan");
          listCountry.add("Korea");
          listCountry.add("Mexico");
          listCountry.add("Netherlands");
          listCountry.add("Portugal");
          listCountry.add("Russia");
          listCountry.add("Saudi Arabia");
          listCountry.add("Spain");
          listCountry.add("Turkey");
          listCountry.add("United Kingdom");
          listCountry.add("United States");
    }
}

