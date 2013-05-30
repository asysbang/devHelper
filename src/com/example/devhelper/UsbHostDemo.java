package com.example.devhelper;

import java.util.HashMap;

import android.app.Activity;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;

public class UsbHostDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		System.out.println("====================");
		UsbManager um = (UsbManager) getSystemService(USB_SERVICE);
		System.out.println("==UsbManager======"+um);
		UsbAccessory[] accessoryList = um.getAccessoryList();
		if(accessoryList !=null){
			System.out.println("=====accessoryList======"+accessoryList.length);
		}
		HashMap<String, UsbDevice> hashMap = um.getDeviceList();
		System.out.println("======hashMap===="+hashMap.size());
	}
	

}
