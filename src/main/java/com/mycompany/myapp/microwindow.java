package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.view.View.*;
import java.util.*;
import android.net.*;
import android.content.pm.*;
import android.util.*;
import android.view.InputDevice.*;
import android.graphics.drawable.*;
import org.apache.http.impl.*;
import java.sql.*;
import java.lang.System;
import android.widget.RelativeLayout.*;
import java.security.acl.*;
import java.util.concurrent.locks.*;
import android.widget.AdapterView.*;
import android.test.*;
import java.lang.annotation.*;
public class microwindow extends Service implements click,OnItemClickListener
	{

		@Override
		public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
			{
				onClick(p1.getId());
				// TODO: Implement this method
			}

		@Override
		ArrayList<iconHstring> ichs;
		public void iconHstring(ArrayList<iconHstring> lih)
			{
				ichs=lih;
				listadapter lsapt = new listadapter(lih, cnt);
				lv.setAdapter(lsapt);
				lsapt.notifyDataSetChanged();
				Log.d(TAG, "线程为" + Thread.currentThread().toString());
				// TODO: Implement this methodl
			}
		String TAG="悬浮窗实现类";
		followfinger fl;
		@Override

		public void onClick(int id)//View p1)
			{
				Log.d(TAG, "线程为" + Thread.currentThread().toString());
				if (id == 0)
					{
						/*
						 synchronized(tm){
						 try
						 {
						 tm.wait();
						 }
						 catch (InterruptedException e)
						 {}
						 }*/
						wManager.removeView(btv);
						creatlv();
						gs.changemod(getspd.islist,ichs);
						
					}
				else
					{
						
						wManager.removeView(ll);
						creatbtn("等");
						gs.changemod(getspd.isbtn,null);
					}
				//wManager.removeView(p1);
				//creatwd("waitting");

				// TODO: Implement this method
			}
		static Button btv;
		private WindowManager wManager;// 窗口管理者
		private WindowManager.LayoutParams mParams;// 窗口的属性
		@Override
		public IBinder onBind(Intent p1)
			{
				// TODO: Implement this method
				return null;
			}
		@Override
		public void onCreate()
			{
				cnt = this;
				// TODO Auto-generated method stub
				wManager = (WindowManager) getApplicationContext().getSystemService(
					Context.WINDOW_SERVICE);
				mParams = new WindowManager.LayoutParams();
				mParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;// 系统提示window
				mParams.format = PixelFormat.TRANSLUCENT;// 支持透明
				//mParams.format = PixelFormat.RGBA_8888;
				mParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;// 焦点
				//	Toast.makeText(getApplicationContext(), "服务!", Toast.LENGTH_SHORT).show();
				fl = new followfinger(mParams, wManager, this);
			}
		ListView lv;
	    View ll;
		void creatlv()
			{//创建一个列表窗口
				mParams.width = 300 ;//窗口的宽和高
				mParams.height = 600;
			    ll=View.inflate(this, R.layout.netspeedlist, null);
		        
				lv = (ListView) ll.findViewById(R.id.netlv);
				lv.setOnItemClickListener(this);
				getNetApp gn=new getNetApp(this);
				gn.run();
				/*
				 this.stopSelf();
				 Intent i=new Intent(this,MainActivity.class);
				 i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				 startActivity(i);*/
				wManager.addView(ll, mParams);
			}
		listadapter lsap;
		void creatbtn(String dpy)
			{

				mParams.width = 160 ;//窗口的宽和高
				mParams.height = 80;
				btv = new Button(this);
				btv.setText(dpy);    
				btv.setWidth(14);
				btv.setHeight(33);
			    btv.setId(0);
				Log.d("按钮id", "" + btv.getId());
				wManager.addView(btv, mParams);
				btv.setOnTouchListener(fl);
			}
		Timer tm;
		rehdl hd;
		getspd gs;
		@Override
		public int onStartCommand(Intent intent, int flags, int startId)
			{

				 hd=new rehdl(this);
				 gs=new getspd(hd);
			    tm = new Timer();

				creatbtn("xfc");
				Log.d(TAG, "线程" + Thread.currentThread().toString());
				//Toast.makeText(getApplicationContext(), "开始>了!", Toast.LENGTH_SHORT).show();
				tm.schedule(gs, 1000, 1000);
				// TODO: Implement -this method
				return super.onStartCommand(intent, flags, startId);
			}

		@Override
		public void onDestroy()
			{


				// TODO: Implement this method
				super.onDestroy();
			}

		@Override
		public void onTaskRemoved(Intent rootIntent)
			{
				//Toast.makeText(getApplicationContext(), "服务终止", Toast.LENGTH_SHORT).show();
				Intent newIntent = new Intent(this, microwindow.class);
				startService(newIntent);
				// TODO: Implement this method
				super.onTaskRemoved(rootIntent);
			}

		//interval:更新间隔
		void UpdateSpeed(int interval)
			{

			}
		ListView lsve;
		void appspeedlist()
			{
				//lsve=new ArrayList<ListView>();;
			}
	}
class getNetApp implements Runnable
	{
		Message msg;
		Handler hd;
		click recipient;
		public boolean isObtain=false;
		public static ArrayList<iconHstring> NetApp;
		Context ctt; 
		iconHstring ish;
		List lsPI;
		getNetApp(click recipient)
			{
				this.recipient = recipient;
				ctt = recipient.cnt;
				NetApp = new ArrayList<iconHstring>();
			}
		public void  getAppTrafficList()
			{  
				lsPI = new ArrayList<PackageInfo>();
				//获取所有的安装在手机上的应用软件的信息，并且获取这些软件里面的权限信息  
				PackageManager pm= ctt.getPackageManager();//获取系统应用包管理  
				//获取每个包内的androidmanifest.xml信息，它的权限等等  
				List<PackageInfo> pinfos=pm.getInstalledPackages
				(PackageManager.GET_UNINSTALLED_PACKAGES | PackageManager.GET_PERMISSIONS);  
				//遍历每个应用包信息  
				for (PackageInfo info:pinfos)
					{  
						//请求每个程序包对应的androidManifest.xml里面的权限  
						String[] premissions=info.requestedPermissions;  
						if (premissions != null && premissions.length > 0)
							{  
								//int c=0;
								//找出需要网络服务的应用程序  
								for (String premission : premissions)
									{  
										if ("android.permission.INTERNET".equals(premission))
											NetApp.add
											(new iconHstring(info.applicationInfo.loadIcon(pm), info.applicationInfo.loadLabel(pm).toString(),info.applicationInfo.uid));
										/*msg.what=c;
										 c++;
										 msg.sendToTarget();*/
										//lsPI.add(info);

										//获取每个应用程序在操作系统内的进程id  

										/*int uId=info.applicationInfo.uid;  /*
										 //如果返回-1，代表不支持使用该方法，注意必须是2.2以上的  
										 long rx=TrafficStats.getUidRxBytes(uId);  
										 //如果返回-1，代表不支持使用该方法，注意必须是2.2以上的  
										 long tx=TrafficStats.getUidTxBytes(uId);  

										 if(rx<0 || tx<0){  
										 continue;  
										 }else{  
										 Toast.makeText(this, info.applicationInfo.loadLabel(pm)+"消耗的流量--"+  
										 Formatter.formatFileSize(this, rx+tx), Toast.LENGTH_SHORT);  
										 }  */
									}
							}  
					}  
			}  


		@Override
		public void run()
			{

				getAppTrafficList();
				recipient.iconHstring(NetApp);
				isObtain = true;
				// TODO: Implement this method

			}

	}
//此类用于计算网速
class getspd extends TimerTask
	{
		static int isbtn=0;
		static int islist=1;
		Message msg;
		int flag=0;
		Map<Integer,Long[]> mp=new HashMap<Integer,Long[]>();
		ArrayList<iconHstring> alst;
		private Handler mhad;
		private long lastTotalRxBytes = 0; 
		private long lastTimeStamp = 0;
		getspd(Handler mhad)
			{
				this.mhad = mhad;
			}
		Long[] l;
		void changemod(int m,ArrayList<iconHstring> alst)
			{
				this.flag = m;
				if(alst!=null){
			    l=new Long[2];
				l[0]=0l;
				l[1]=System.currentTimeMillis();
				for(iconHstring i : alst){
					mp.put(i.uid,l);
				}
				this.alst=alst;
				}else{
					lastTotalRxBytes=0;
					lastTimeStamp=0;
				}
			}
		//total:全部的
		private long getTotalRxBytes() 
			{ 
				return TrafficStats.getTotalRxBytes(); //.getUidRxBytes(getApplicationInfo().uid)==TrafficStats.UNSUPPORTED ? 0 :(TrafficStats.getTotalRxBytes()/1024);//转为KB
			}
		getNetApp gn;
		@Override
		public void run()
			{
				if (flag == isbtn)
					{
						caculatesped();
						Log.d("计算数据","按钮");
					}
				else
					{
       整合计算数据(alst);

						Log.d("计算数据","整合计算数据");
					}
				// TODO: Implement this method
			}
			void 整合计算数据(ArrayList<iconHstring> ay){
				for(iconHstring is : ay){
					is.spd=caculatespeed(is.uid);
							
				}
				lastTotalRxBytes=System.currentTimeMillis();
				new sort(ay);
				msg=mhad.obtainMessage(2,ay);
				mhad.sendMessage(msg);
			}
		long caculatespeed(int uid)
			{
				l=new Long[2];
				if(mp.get(uid)[0]==0){
						l[0]=TrafficStats.getUidRxBytes(uid);
						l[1]=System.currentTimeMillis();
						mp.put(uid,l);
						return 0;
				}
				long  nowTotalRxBytes=TrafficStats.getUidRxBytes(uid);
				long nowTimeStamp = System.currentTimeMillis(); 
				long speed = ((nowTotalRxBytes - mp.get(uid)[0])*1000/1024)/ (nowTimeStamp - mp.get(uid)[1]);
				lastTotalRxBytes = nowTotalRxBytes;
				l[0]=nowTotalRxBytes;
				l[1]=nowTimeStamp;
				mp.put(uid,l);
				
				return speed;
			}
		void caculatesped()
			{
				long nowTotalRxBytes = getTotalRxBytes(); 
				long nowTimeStamp = System.currentTimeMillis(); 
				long speed = ((nowTotalRxBytes - lastTotalRxBytes) * 1000 / (nowTimeStamp - lastTimeStamp));//毫秒转换
				lastTimeStamp = nowTimeStamp;
				lastTotalRxBytes = nowTotalRxBytes;
				msg = mhad.obtainMessage(1, speed / 1024 + "kb");
				mhad.sendMessage(msg);
			}
	}
class followfinger implements OnTouchListener
	{
		WindowManager wManager;
		WindowManager.LayoutParams mParams;
		click cl;
		followfinger(WindowManager.LayoutParams wmp, WindowManager wmg, click i)
			{
				mParams = wmp;
				wManager = wmg;
				cl = i;
				ux = -9;
				uy = ux;
			}

		int lastX, lastY;  
		int paramX, paramY,dx,dy,ux,uy;
		int i;
		public boolean onTouch(View v, MotionEvent event)
			{  
				switch (event.getAction())
					{  
					    case MotionEvent.ACTION_UP:
							ux = (int)event.getRawX();
							uy = (int)event.getRawY();
							Log.d("ACTION_BUTTON_PRESS", "");
							break;
						case MotionEvent.ACTION_DOWN:  
							lastX = (int) event.getRawX();  
							lastY = (int) event.getRawY();  
							paramX = mParams.x;  
							paramY = mParams.y;  
							break;  
						case MotionEvent.ACTION_MOVE:  
							Log.d("ACTION_MOVE", "");
							dx = (int) event.getRawX() - lastX;  
							dy = (int) event.getRawY() - lastY;  
							mParams.x = paramX + dx;  
							mParams.y = paramY + dy;  
							// 更新悬浮窗位置  
							wManager.updateViewLayout(v, mParams);  
							break;  

					}  
				i++;
				Log.d("参数", lastX + " " + lastY + " " + paramX + " " + paramY + "i" + i);
				if (lastX == ux && lastY == uy)
					{
						cl.onClick(v.getId());
					}
				return true;  
			}  
	}
interface click
	{
		Context cnt;
		void onClick(int id)
		void iconHstring(ArrayList<iconHstring> lih);
	}
