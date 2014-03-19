package com.example.viewpager_test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity_Fragment  extends Fragment{

	private static Context context;
	String pics;

	public static final MainActivity_Fragment newInstance(String pics) {

		MainActivity_Fragment f = new MainActivity_Fragment();
		Bundle bdl = new Bundle();
		bdl.putString("pics", pics);

		f.setArguments(bdl);
		return f;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity.getApplicationContext();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		pics = getArguments().getString("pics");
		View v = inflater.inflate(R.layout.main_fragment, container, false);
		ImageView pics_iv = (ImageView) v.findViewById(R.id.pics);
		int resID = getResources().getIdentifier(pics, "drawable",context.getPackageName());
		pics_iv.setImageResource(resID);
		return v;
	}

}