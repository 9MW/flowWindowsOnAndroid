package com.mycompany.myapp;

import android.os.*;
import android.util.*;
import android.widget.Button;
import java.util.*;

public class rehdl extends Handler
	{
		microwindow m;
		rehdl(microwindow mw){
			m=mw;
		}
		ArrayList<iconHstring> ms;
		@Override
		public void handleMessage(Message msg)
			{

				if (msg.what == 1)
					{
						microwindow.btv.setText(msg.obj.toString());
					}
				else
					{
						ms=(ArrayList<iconHstring>)msg.obj;
						m.iconHstring(ms);
						Log.i("msg",ms.get(0).spd+""+"tostg"+ms.toString());
					}
				// TODO: Implement this method
				super.handleMessage(msg);
			}



	}
class sort<u extends Comparable>
	{
		int ci=0;
		sort(List<u> k)
			{
				sort(k);
			}
		List<u> sort(List<u> k)
			{	
				ci++;

				if (k.size() > 1)
					{
						int js=0;
						List<u> t;
						int xs=0;
						u kn;
						u bailment=k.get(0);
						for (int n=1;n < k.size();n++)
							{
								kn = k.get(n);
								if (bailment.compareTo(kn) < 0)
									{
										swop(k, js, n);
										js++;
									}
								else
									{
										continue;
									}
							}
						xs = k.size() - js - 1;
						k.set(js, bailment);
						t = new ArrayList<u>(js);
						t.addAll(k.subList(0, js));
						sort(t);
						t = new ArrayList<u>(xs);
						t.addAll(k.subList(js + 1, k.size()));
						t = sort(t);
						return k;
					}
				else
					{
						return k;
					}
			}
		List<u> swop(List<u> l, int e1, int e2)
			{
				u i=l.get(e1);
				l.set(e1, l.get(e2));
				l.set(e2, i);
				return l;
			}
		void sort(List<u> l, int e1, int e2)
			{
				u i=l.get(e1);
				l.set(e1, l.get(e2));
				l.set(e2, i);
			}
	}
