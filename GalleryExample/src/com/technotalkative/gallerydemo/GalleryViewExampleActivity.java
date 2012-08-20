package com.technotalkative.gallerydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryViewExampleActivity extends Activity {
    /** Called when the activity is first created. */
	
    private Gallery gallery;
    private ImageView imgSelected;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        gallery = (Gallery) findViewById(R.id.gallery1);
        imgSelected = (ImageView) findViewById(R.id.imageView1);
        
        gallery.setAdapter(new GViewAdapter(this));        
        gallery.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, 
            View v, int position, long id) 
            {                
            	imgSelected.setImageResource(GViewAdapter.imageIDs[position]);
            }
        });
    }
}