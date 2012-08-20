package com.gloscon.dashboard;

import com.gloscon.dashboard.activity.FirstActivity;
import com.gloscon.dashboard.activity.SecondActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashBoardDemoActivity extends BaseActivity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        setHeader(this, "Dashboard");
    }
    
    public void btnHome(View v)
    {
    	Intent intent = new Intent(this, FirstActivity.class);
    	startActivity(intent);
    }
    
    public void btnAboutUs(View v)
    {
    	Intent intent = new Intent(this, SecondActivity.class);
    	startActivity(intent);
    }
    
    public void btnFacebook(View v)
    {
    	
    }
    
    public void btnTwitter(View v)
    {
    	
    }
}