package com.listview.radio;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter{

	public String title[];  
    public String description[];  
    public Activity context;  
    public LayoutInflater inflater;
	  
    public ImageAdapter(Activity context,String[] title) {  
        super();  
  
        this.context = context;  
        this.title = title;  
         
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
    }  
  
    @Override  
    public int getCount() {  
        // TODO Auto-generated method stub  
        return title.length;  
    }  
  
    @Override  
    public Object getItem(int position) {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    @Override  
    public long getItemId(int position) {  
        // TODO Auto-generated method stub  
        return 0;  
    }  
  
    public static class ViewHolder  
    {  
        
        TextView txtViewTitle;  
        
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        // TODO Auto-generated method stub  
  
        ViewHolder holder;  
        if(convertView==null)  
        {  
            holder = new ViewHolder();  
            convertView = inflater.inflate(R.layout.listitem, null);  
     
          //  holder.txtViewTitle = (TextView) convertView.findViewById(R.id.lstvw_textView);  
            convertView.setTag(holder);  
        }  
        else  
            holder=(ViewHolder)convertView.getTag();  
            
        holder.txtViewTitle.setText(title[position]);  
   
        return convertView;  
    }   
  
}