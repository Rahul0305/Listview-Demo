package com.rahul.lazylistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter{

	protected Object imageLoader;
	private Activity activity;
    private String[] data;
    private static LayoutInflater inflater=null;

	
	public LazyAdapter(Activity a, String[] d) {
        activity = a;
        data = d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity);
    }
	
	 public int getCount() {
	        return data.length;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }
	    
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View vi=convertView;
	        if(convertView==null)
	            vi = inflater.inflate(R.layout.item, null);

	        TextView text=(TextView)vi.findViewById(R.id.text);;
	        ImageView image=(ImageView)vi.findViewById(R.id.image);
	        text.setText("item "+position);
	        ((ImageLoader) imageLoader).DisplayImage(data[position], image);
	        return vi;
	    }
	}