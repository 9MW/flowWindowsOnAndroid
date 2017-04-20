package com.mycompany.myapp;
import android.graphics.*;
import android.view.*;
import android.util.*;

//this class is used for support some draw function


public class Drawlib
	{
		WindowManager manager ;
		int ScreenWide, ScreenHight,q,w;
		Canvas canvas;
		Drawlib(Canvas c, WindowManager m)
			{
				canvas = c;
				manager = m;
				ScreenWide = manager.getDefaultDisplay().getWidth();
				ScreenHight = manager.getDefaultDisplay().getHeight();
			}
		Drawlib(Canvas c)
			{
				canvas = c;	
			}
			//zuo biao xi
		int dimension;
		public void coordinate(int... dimension,Paint p){
			Paint pen=new  Paint();
			pen.set(p);
			pen.setDither(true);
				pen.setColor(Color.BLACK);
			             canvas.drawLine(0,0,0,ScreenHight,pen);
						 pen.setColor(Color.WHITE);
						 canvas.drawLine(0,0,ScreenWide,0,pen);
			}
		float[] tmp;
		int i;
		//draw ellipse
		public void DRellipse(float a,float b,int cons,Paint p){
			float y;
		    float[] epe=new float[3599*2];
		int	x=0;
			while(x<3600){
					double ttm=(cons-(x*x/a*a))*(b*b);
					//Log.d("DRAlin",ttm+"it's ttm");
					y=(float) ttm;
					//Log.d("DRAlin",y+"it's y");
					epe[x]=x;
					epe[x+1]=y;
					x+=2;
			}		
			canvas.drawPoints(epe,p);
		} 
		public void test(Paint paint)
			{
				tmp = new float[3600];
				q = w = 0;
				i = 0;
				if (i < 3600)
					{
						float n=(float)Math.asin(i) * 10;
						Log.d(SecondActivity.TAG, "q w i n是个" + q + w + i + n);
						tmp[i] = n + 400;
						i++;
					}
				i = 0;
				//if(i<2000)
					{
						float[] tp={0,0,400,400,555,858,222,58};
						System.arraycopy(tmp, 0, tp, 0, i);
						canvas.drawPoints(tp, paint);
						
					}
				i++;
			}
	}

