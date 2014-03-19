package com.example.viewpager_test;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	ViewPager viewPager;
	MyPageAdapter pageAdapter;
	ArrayList<String> picsDB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		picsDB = new ArrayList<String>();
		
		pushDB();

		List<Fragment> fragments = getFragments();
		pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);

		viewPager = (ViewPager) findViewById(R.id.main_viewpager);
		viewPager.setAdapter(pageAdapter);

	}
	
	public void pushDB(){
		
		for(int i=1;i<6;i++){
			picsDB.add("pic"+i);
		}
	}

	private List<Fragment> getFragments() {
		List<Fragment> fList = new ArrayList<Fragment>();
		
		for (int i = 0; i < picsDB.size(); i++) {
			fList.add(MainActivity_Fragment.newInstance(picsDB.get(i)));
		}
		return fList;
	}

	private class MyPageAdapter extends FragmentPagerAdapter {
		private List<Fragment> fragments;

		public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}

		@Override
		public Fragment getItem(int position) {
			return this.fragments.get(position);
		}

		@Override
		public int getCount() {
			return this.fragments.size();
		}
	}

}
