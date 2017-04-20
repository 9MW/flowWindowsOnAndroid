package com.mycompany.myapp;
import android.widget.*;
import android.view.*;
import android.content.pm.*;
import java.util.*;
import android.app.*;
import android.content.*;
import android.graphics.drawable.*;
import android.graphics.*;
import android.view.View.*;
import android.os.*;
import android.util.*;

public class listadapter extends BaseAdapter 
	{

		@Override
		Context cnt;
		@Override
		ArrayList<iconHstring>  is;
		View listview;
		List netapp;
		listadapter(ArrayList<iconHstring> is,Context cnt)
			{
				this.cnt=cnt;
				this.is=is;
			}
		@Override
		public int getCount()
			{
				// TODO: Implement this method
				return is.size();
			}

		@Override
		public Object getItem(int p1)
			{
				// TODO: Implement this method
				return is.get(p1);
			}

		@Override
		public long getItemId(int p1)
			{
				// TODO: Implement this method
				return p1;
			}
		@Override
		public View getView(int p1, View p2, ViewGroup p3)
			{
				Log.d("只配器","p1是"+p1);
			    listview= View.inflate(cnt,R.layout.activity_item_generals_,null);
				ImageView im=(ImageView)listview.findViewById(R.id.ivThumb);
				TextView tv=(TextView)listview.findViewById(R.id.appName);
				TextView ntspd=(TextView)listview.findViewById(R.id.netSpeed);
				iconHstring ihs=is.get(p1);
				im.setImageDrawable(ihs.getDrawable());
				tv.setText(ihs.getString());
				ntspd.setText(ihs.getSpd()+"kb");
				//im=pi.applicationInfo.loadIcon(cnt.getPackageManager());
				// TODO: Implement this method
				return listview;
			}
		protected void makeviewlist(){
			
				
			}

	}
	 class iconHstring implements Comparable
	{

		@Override
		public String toString()
			{
				// TODO: Implement this method
				return this.spd+"";
			}
		
		public int compareTo(iconHstring p1)
			{
				iconHstring p=p1;
				int cha=(int)this.spd-(int)p.spd;
				// TODO: Implement this method
				return cha;
			}
		@Override
		public int compareTo(Object p1)
			{
				iconHstring p=(iconHstring)p1;
				int cha=(int)this.spd-(int)p.spd;
				// TODO: Implement this method
				return cha;
			}

		Drawable dwe;
		String apnm;
		long spd;
		int uid;
		iconHstring(){}
		iconHstring(Drawable im,String appnm,int uid){
			this.uid=uid;
			dwe=im;
			apnm=appnm;
		}
		public Drawable getDrawable(){
			return dwe;
		}
		public String getString(){
				return apnm;
			}
		public void setSpd(int spd){
			this.spd=spd;
		}
		public long getSpd(){
			return spd;
		}
	}
