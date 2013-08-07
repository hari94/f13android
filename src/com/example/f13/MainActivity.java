package com.example.f13;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity {
	
	List<Fragment> fragments = new Vector<Fragment>();

	private PagerAdapter mPagerAdapter;
	ViewPager pager;
	Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pager= (ViewPager) super.findViewById(R.id.viewpager);
		// initialize the pager
		this.initialisePaging();
		
		/**b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Aila");
			}
		});**/
		/**b.setOnDragListener(new View.OnDragListener() {
			
			@Override
			public boolean onDrag(View v, DragEvent event) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
				return false;
			}
		});**/
	
	}
	
	/**
	* Initialize the fragments to be paged
	*/
	void initialisePaging() {
	
		//List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, SecondFragment.class.getName()));
		fragments.add(Fragment.instantiate(this, FirstFragment.class.getName()));
		fragments.add(Fragment.instantiate(this, ThirdFragment.class.getName()));
		this.mPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);
		
		//ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
		
		pager.setAdapter(this.mPagerAdapter);
		pager.setCurrentItem(1);
		
		//b=FirstFragment.mButton;
		/**b=(Button)FirstFragment.buttId;
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b.setText("finally!");
		    	System.out.println("hola");
			}
		});**/
		
		/**b=(Button)pager.findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Aila");
			}
		});**/
		
		
		/**b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(MainActivity.this, "High", Toast.LENGTH_LONG).show();
				List<Fragment> fragments = new Vector<Fragment>();
				fragments.add(Fragment.instantiate(MainActivity.this, SecondFragment.class.getName()));
				fragments.add(Fragment.instantiate(MainActivity.this, FirstFragment.class.getName()));
				fragments.add(Fragment.instantiate(MainActivity.this, ThirdFragment.class.getName()));
				MainActivity.this.mPagerAdapter = new MyPagerAdapter(MainActivity.this.getSupportFragmentManager(), fragments);
		
				ViewPager pager = (ViewPager) MainActivity.this.findViewById(R.id.viewpager);
		
		
		
				pager.setAdapter(MainActivity.this.mPagerAdapter);
				pager.setCurrentItem(1);
				System.out.println("hi");
			}
		});**/

	}


}