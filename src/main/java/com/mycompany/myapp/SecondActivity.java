package com.mycompany.myapp;
import android.app.*;
import android.view.*;
import android.os.*;
import android.view.SurfaceHolder.*;
import android.graphics.*;
import android.util.*;
import java.util.*;
import android.content.*;

public class SecondActivity extends Activity implements SurfaceHolder.Callback
{
	Timer time;
	static String TAG="调试";
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3)
	{
// TODO Auto-generated method stub

	}
	@Override
	public void surfaceCreated(SurfaceHolder arg0)
	{
// TODO Auto-generated method stub
//当surfaceView创建的时候执行
		init_background();//初始化绘图界面
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0)
	{
// TODO Auto-generated method stub

	}

	private void init_background()
	{
		time=new Timer();
		
		//Log.d(TAG, "执行init_background" + Thread.currentThread().getName());
	  	Canvas canvas=null;
		canvas = holder.lockCanvas();//获取目标画图区域
		canvas.drawColor(Color.argb(5,2,3,43));//画布背景颜色  
		/*测试用代码段
		int z,x;
		z=7;x=4;
		//test(z,x);
		Log.d(TAG,"tst外z="+z+"x="+x);
		*/
		holder.unlockCanvasAndPost(canvas); //解除锁定并显示 
		time.schedule(new MyThread(this),1000,17);
	}
	void test(int a,int b){
		int t;
		t=a;
		a=b;b=t;
		
	}
	Paint p=new Paint();
		Canvas canvas=null;
	private class MyThread extends TimerTask
	{
		Context ct;
		int length;
		int ox,oy,x,y;
		int[] Yarray;
		boolean isStart;
		MyThread(Activity ct){
					this.ct=ct;
			isStart=true;
				
		}
		Drawlib dlb;
		public void run()
		{
			
			if(isStart){
					WindowManager manager = (WindowManager) ct 
						.getSystemService(Context.WINDOW_SERVICE);
					int width = manager.getDefaultDisplay().getWidth(); // 屏幕宽度（像素）
					 length=width;
					Yarray = new int[length];
					ox=0;
				oy=400;
					while(ox < length)
						{
							double tmp=Math.sin(ox* (3.14/180 ));
							Log.d(TAG, "ox是" + ox );
							y=(int)( tmp*10+ 400);
							Yarray[ox] = y;
							ox++;
							Log.d(TAG, "Yarray中第" + ox + "个元素是" + y+"sin(x)是"+tmp);
						}
					//Log.d(TAG, "Yarray中第一个元素是" + Yarray[0]);//证明超过200个log时，之前的将被覆盖
					ox = 0;
					x=0;
					isStart=false;
				
			}
			
			p.setColor(Color.GREEN);
			p.setStrokeWidth(5); 
			
			canvas = holder.lockCanvas();//获取目标画图区域，无参数表示锁定的是全部绘图区
			canvas.drawColor(Color.RED);//画布背景颜色设置
		//	canvas.drawCircle(100, 100, 50, p);//以(100,100)为圆心，画一个半径为50像素的圆
			draw(canvas);
			dlb=new Drawlib(canvas);
			//dlb.coordinate((2,p);
			dlb.DRellipse(5,4,500,p);
			//for(i=0;i<
			holder.unlockCanvasAndPost(canvas); //解除锁定并显示 
		}   
		void draw(Canvas canvas)
		{
			
			
			Log.d(TAG, "length是" + length);
		
			if(x<length)
			{
				int inc=x;
				while(inc!=0){
						y = Yarray[inc];
						canvas.drawLine(ox, oy, inc, y, p);
						ox=inc;oy=y;
						inc--;
				}
				x+=2;
			}
			else{
isStart=true;
				}
			
		}
    }
	SurfaceHolder holder=null;
	SurfaceView sc=null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
        setContentView(R.layout.surface);
		sc = (SurfaceView)findViewById(R.id.tstSurfaceView); 
		holder = sc.getHolder();
		holder.addCallback(this);

	}
}
