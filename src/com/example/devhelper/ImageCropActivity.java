package com.example.devhelper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;

public class ImageCropActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(MotionEvent.ACTION_UP == event.getAction()){
			
			Intent i = new Intent("com.android.camera.action.CROP");
			i.setDataAndType(Uri.parse("file:///sdcard/1.jpg"), "image/*");
			i.putExtra("crop", "true");
			i.putExtra("aspectX", 1.3);
			i.putExtra("aspectY", 1);
			i.putExtra("outputX", 440);
			i.putExtra("outputY", 440); 
			i.putExtra("return-data", false);
			startActivityForResult(i, 111);
			
			return true;
		}
		return super.onTouchEvent(event);
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		System.out.println("=====requestCode========"+requestCode);
		System.out.println("=====resultCode========"+resultCode);
		System.out.println("=====data========"+data.getData());
		super.onActivityResult(requestCode, resultCode, data);
	}

}
