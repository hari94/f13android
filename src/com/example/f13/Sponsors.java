package com.example.f13;



import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Sponsors extends Activity{

	GridView gv;
	boolean change=true;
	Handler mainHandler;
	AlphaAnimation alpha=new AlphaAnimation(0, 1);
	AlphaAnimation alphafade=new AlphaAnimation(1, 0);

	int imageResources[]={R.drawable.main_sponsors,R.drawable.sponsor1,R.drawable.sponsor2,R.drawable.sponsor3,R.drawable.sponsor4,R.drawable.sponsor5,R.drawable.sponsor6jpg};
	CustomListAdapter adp=new CustomListAdapter(imageResources);
	@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.sponsors_main);
			gv=(GridView)findViewById(R.id.gridView1);
			
			adp=new CustomListAdapter(imageResources);
			gv.setAdapter(adp);
			
			
			mainHandler=new Handler();
			Runnable runnable=new Runnable() {
				
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true)
					{		
						mainHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								gv.setAdapter(adp);
							}
						});
						delay();
						//change=!change;
				}
				
				}
				
			};
			
			//new Thread(runnable).start();
		}

		protected void delay() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

		
		class CustomListAdapter extends BaseAdapter{
			String[] types=new String[3];
			int[] ids=new int[7];
				 public CustomListAdapter(int []imageIds)
				 {
					 //types=sponsorCategory;
					 ids=imageIds;
				 }
				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return ids.length;
				}

				@Override
				public Object getItem(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public long getItemId(int arg0) {
					// TODO Auto-generated method stub
					return arg0;
				}

				@Override
				public View getView(int pos, View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					LayoutInflater inflater = getLayoutInflater();
					View row;
					row = inflater.inflate(R.layout.sponsors_cell, parent, false);
					TextView type;
					LinearLayout ll=(LinearLayout)row.findViewById(R.id.ll);
					ImageView iv1,iv2;
					type=(TextView)row.findViewById(R.id.tvSponsor);
					iv1=(ImageView)row.findViewById(R.id.ivSponsor1);
					/*if(change)
					{
						if(pos%3==0)
						{					
							type.setVisibility(View.VISIBLE);
							alpha.setDuration(1000);
							type.setAnimation(alpha);
							type.setText("Check");
							iv1.setVisibility(View.GONE);
						}
						else
						{
							type.setVisibility(View.GONE);
							iv1.setBackgroundResource(ids[pos]);
						}
					}
					else
					{
						if(pos%3==0)
						{					
							type.setVisibility(View.GONE);
							//type.setText("Check");
							iv1.setBackgroundResource(ids[pos]);
						}						
						else
						{
							type.setVisibility(View.VISIBLE);
							type.setText("Check");
							iv1.setVisibility(View.GONE);
						}
					}*/
					
					//iv1.setAlpha(0);
					
					Log.d("GridCell", "alpha");
					alpha.setDuration(500+1000*pos);
					iv1.setAnimation(alpha);
					
					iv1.setBackgroundResource(ids[pos]);
					
					
					return row;
				}	 
			 
			 }

			 
			 
			 /*class Sponsors{
				 private int imageId;
				 private String portfolio;
				 
				 void setPortfolio(String name){
					 portfolio=name; 
				 }
				 String getPortfolio(){
					 return portfolio;
				 }
				 void setImageId(int id){
					 imageId=id;
				 }
				 int getImageId(){
					return imageId; 
				 }
			 }
			 */
		
		

	
	
}
