package com.rahul.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckboxActivity extends Activity {

	 CheckBox chkBoxCycling;
	 CheckBox chkBoxTeaching;
	 CheckBox chkBoxBlogging;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initialUISetup();
	}

	public void initialUISetup() {
		chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
		chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
		chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
		
		 chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChnageClicker());
		 chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChnageClicker());
		 chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChnageClicker());
	}

	 class myCheckBoxChnageClicker implements CheckBox.OnCheckedChangeListener  
     {  
  
        @Override  
        public void onCheckedChanged(CompoundButton buttonView,  
                boolean isChecked) {  
            // TODO Auto-generated method stub  
  
         // Toast.makeText(CheckBoxCheckedDemo.this, "Checked => "+isChecked, Toast.LENGTH_SHORT).show();  
  
	          if(isChecked)  
	          {  
	           if(buttonView==chkBoxBlogging)  
	            {  
	                showTextNotification("Blogging");  
	            }  
	  
	            if(buttonView==chkBoxCycling)  
	            {  
	                showTextNotification("cycling");  
	            }  
	  
	            if(buttonView==chkBoxTeaching)  
	            {  
	                showTextNotification("Teachng");  
	            }  
	          }  
  
        }
 
     }  

	
	public void getHobbyClick(View v) {
		String strMessage = "";

		if (chkBoxCycling.isChecked()) {
			strMessage += "Cycling ";
		}

		if (chkBoxTeaching.isChecked()) {
			strMessage += "Teaching ";
		}

		if (chkBoxBlogging.isChecked()) {
			strMessage += "Blogging ";
		}

		showTextNotification(strMessage);
	}

	public void showTextNotification(String msgToDisplay) {
		if (msgToDisplay.length() == 0) {
			Toast.makeText(this, "u are not select any option",
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
		}
	}

}