package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import org.w3c.dom.*;
import android.view.View.*;
import android.content.*;
import android.util.*;
import java.util.*;
public class MainActivity extends Activity implements OnClickListener
	{
		@Override
		public void onClick(View p1)
			{
				Log.d("点击","id"+p1.getId());
				switch (p1.getId())
					{
						case R.id.sv : 
							Intent isv=new Intent(this, SecondActivity.class);
							startActivity(isv);
							break;
						case R.id.mb:
							Intent imb=new Intent(this, microwindow.class);
	         				startService(imb);
							this.finish();
					break;
							}
				
				//Intent i=new Intent(this,SecondActivity.class);
				//startActivity(i);
				// TODO: Implement this method
			}
		MainActivity n=this;
		RadioButton isBoot;
		microwindow mw;
		Button t;//悬浮窗
		Button sv;//跳转到画画视图
		void RegisterBoot()//动态注册是否自启
			{
				IntentFilter f= new IntentFilter();
				f.addCategory("android.intent.action.BOOT_COMPLETED");
				registerReceiver(new BootCompletedReceiver(), f);
			}
		static	int i=0;
		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				
				super.onCreate(savedInstanceState);
				if(i!=0){
						setContentView(R.layout.netspeedlist);
				}else{
				setContentView(R.layout.main);
				sv = (Button)findViewById(R.id.sv);
				sv.setOnClickListener(this);
				t = (Button)findViewById(R.id.mb); 
				isBoot = (RadioButton)findViewById(R.id.dxk);

				t.setOnClickListener(this);}
				//M ms = new M();
				//t.setText(ms.info()[0]);
				i++;
			}



	}
	/*
	event code
		new OnClickListener(){


		@Override
		public void onClick(View p1)
			{
				Toast.makeText(getApplicationContext(), "按钮按下!", Toast.LENGTH_SHORT).show();
				//Intent intent = new Intent("om.mycompany.myapp.microwindow");
				//为Intent设置Component属性"om.mycompany.myapp.microwindow"
				Intent newIntent = new Intent(n, microwindow.class);
				startService(newIntent);
				// TODO: Implement this method
			}
						});
						
						*/
