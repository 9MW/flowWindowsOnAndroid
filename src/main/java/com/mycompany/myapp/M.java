package com.mycompany.myapp;
import android.content.*;
import android.net.*;
import android.net.wifi.*;
import android.database.*;
import android.app.*;
import android.os.*;
import android.content.pm.*;

import android.graphics.*;
import android.widget.*;

public class M extends IntentService 
{
	ConnectivityManager connectMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
	NetworkInfo nf=connectMgr.getActiveNetworkInfo();
	@Override
	protected void onHandleIntent(Intent p1)
	{
		// TODO: Implement this method
		
	}
	
	
	public M(){
		super("M");
	}
	
	

	
	
	public String[] info(){
		if(nf.isConnected()){
			String nettyp = nf.getTypeName();
			String netspeed =nf.getReason();
		 String[] s={nettyp,netspeed};
		 return s;
		}
		return new String[]{"无网络"};
	}
}
