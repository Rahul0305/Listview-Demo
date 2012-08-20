package com.gloscon.dashboard.activity;

import com.gloscon.dashboard.BaseActivity;
import com.gloscon.dashboard.R;
import com.gloscon.dashboard.R.layout;

import android.os.Bundle;

public class SecondActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		setHeader(this, "Second");
	}
}
