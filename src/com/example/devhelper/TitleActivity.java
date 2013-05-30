package com.example.devhelper;

import android.app.Activity;
import android.app.AlarmManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class TitleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewGroup rootView = (ViewGroup) getWindow().getDecorView();
		int childCount = rootView.getChildCount();
		System.out.println("==============="+childCount);
		ViewGroup l1 = (ViewGroup) rootView.getChildAt(0);
		int i = l1.getChildCount();
		System.out.println("==============="+i);
		View v = l1.getChildAt(0);
		String str = v.getClass().getSimpleName();
		System.out.println("============"+str);
		if ("ActionBarContainer".equals(str)){
			System.out.println("========equal=====");
			v.setBackgroundColor(Color.RED);
		}
		
		
	}
	

}
