package com.example.devhelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStateReceiver extends BroadcastReceiver {

	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		System.out.println("=========onReceive=====");
		ConnectivityManager cm = (ConnectivityManager) arg0.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		NetworkInfo info1 = (NetworkInfo) arg1.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
		System.out.println("==========="+info1.getState());
		System.out.println("============="+info);

	}

}
