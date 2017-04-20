package com.mycompany.myapp;
import android.content.*;

public class BootCompletedReceiver extends BroadcastReceiver{
	public void onReceive(Context context, Intent intent) {
		if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
			Intent newIntent = new Intent(context,microwindow.class);
			context.startService(newIntent);
		}
	}
} 
