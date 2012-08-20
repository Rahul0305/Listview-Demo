package com.gloscon.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public abstract class BaseActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	public void onClickHome(View v)
	{
		Intent intent = new Intent(getApplicationContext(), DashBoardDemoActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
	
	public void onClickAbout(View v)
	{
		
	}
	
	public void setHeader(Activity activity, String title)
	{
		activity.findViewById(R.id.ViewStubHeader).setVisibility(View.VISIBLE);
		View view = activity.findViewById(R.id.header);
		
		TextView txtTitle = (TextView) view.findViewById(R.id.txtViewActivityTitle);
		txtTitle.setText(title);
	}
}
