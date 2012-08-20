package com.listview.demo;

import java.util.ArrayList;

import org.w3c.dom.NameList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewDemoActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    Button submit;
    EditText txtName;
    
    ListView lsName;
    private static class EfficientAdapter extends BaseAdapter{
    	private LayoutInflater mInflater;
    	
    	public EfficientAdapter(Context context){
    		mInflater = LayoutInflater.from(context);
    	}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listContent.size();
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

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if(convertView == null){
				convertView = mInflater.inflate(R.layout.list_item, null);
				holder = new ViewHolder();
				holder.txtName = (TextView)convertView.findViewById(R.id.txtName);
				convertView.setBackgroundColor((position & 1) == 1 ? Color.WHITE : Color.LTGRAY);
				convertView.setTag(holder);	
			}
			else{
				holder = (ViewHolder)convertView.getTag();
			}
			holder.txtName.setText(listContent.get(position));
			
			return convertView;
		}
    	
		static class ViewHolder{
			TextView txtName;
		}
    }   
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lsName = (ListView)findViewById(R.id.listName);
        
        txtName = (EditText)findViewById(R.id.EditText01);
  
        submit = (Button)findViewById(R.id.btnInsert);
        
        txtName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus == false && txtName.getText().toString().length() == 0){
					txtName.setError("Name sfsfd is required");
				}
				else{
					txtName.setError(null);
				}
				
				
			}
		});
        
        submit.setOnClickListener(this);
        
        lsName.setAdapter(new EfficientAdapter(this));
        ColorDrawable clrBorder = new ColorDrawable(Color.DKGRAY);
        lsName.setDivider(clrBorder);
        lsName.setDividerHeight(2);
        
        lsName.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int pos,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(),"your are select "+listContent.get(pos), Toast.LENGTH_LONG).show();
				//listContent.remove(pos);				
			}
		});
        lsName.setAdapter(new EfficientAdapter(this));
    }
    private static final ArrayList<String> listContent = new ArrayList<String>();
    
    /*private static final String[] EmpName = { "Krunal", "Rahul", "Manit",
    	"Tejas", "Divyaraj", "Darshi", "Priyal"};*/

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == submit)
		{
			if(txtName.getText().toString().length() == 0 ){
				txtName.setError("Name is required");
				
			}
			else{
			listContent.add(txtName.getText().toString());
			lsName.setAdapter(new EfficientAdapter(this));
			txtName.setText("");
			}
		}
	}

}