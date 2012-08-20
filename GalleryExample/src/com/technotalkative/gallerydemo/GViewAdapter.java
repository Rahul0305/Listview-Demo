package com.technotalkative.gallerydemo;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GViewAdapter extends BaseAdapter
{
    private Activity activity;
    //private int itemBackground;

	public GViewAdapter(Activity activity) 
    {
        this.activity = activity;
        //---setting the style---
        
       /* TypedArray a = activity.obtainStyledAttributes(R.styleable.Gallery1);
        itemBackground = a.getResourceId(
            R.styleable.Gallery1_android_galleryItemBackground, 0);
        a.recycle();    */                
    }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageIDs.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public static class ViewHolder
	{
		public ImageView imgViewFlag;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder view;
		LayoutInflater inflator = activity.getLayoutInflater();
		
		if(convertView==null)
		{
			view = new ViewHolder();
			convertView = inflator.inflate(R.layout.gallery_row, null);
			
			view.imgViewFlag = (ImageView) convertView.findViewById(R.id.imageView1);
			
			convertView.setTag(view);
		}
		else
		{
			view = (ViewHolder) convertView.getTag();
		}
		
		view.imgViewFlag.setImageResource(imageIDs[position]);
		
		return convertView;
	}
	
	 public static final Integer[] imageIDs = {
	            R.drawable.india,
	            R.drawable.brazil,
	            R.drawable.canada,
	            R.drawable.china,
	            R.drawable.france,
	            R.drawable.germany,
	            R.drawable.iran,
	            R.drawable.italy,
	            R.drawable.japan,
	            R.drawable.korea,
	            R.drawable.mexico,
	            R.drawable.netherlands,
	            R.drawable.portugal,
	            R.drawable.russia,
	            R.drawable.saudi_arabia,
	            R.drawable.spain,
	            R.drawable.turkey,
	            R.drawable.united_kingdom,
	            R.drawable.united_states};

}
