package com.example.devhelper;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class SystemInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DisplayMetrics outMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		System.out.println("=============="+outMetrics.densityDpi);
		System.out.println("=============="+outMetrics.xdpi);
		System.out.println("=============="+outMetrics.ydpi);
		System.out.println("=============="+outMetrics.widthPixels);
		System.out.println("=============="+outMetrics.heightPixels);
	}

	
}
