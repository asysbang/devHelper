package com.example.devhelper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;

public class OpenRtspActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (MotionEvent.ACTION_DOWN == event.getAction()) {
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.addCategory(Intent.CATEGORY_DEFAULT);
			i.addCategory(Intent.CATEGORY_BROWSABLE);
			i.setData(Uri.parse("rtsp://live.3gv.ifeng.com/live/2128"));
			startActivity(i);
			return true;
		}
		return super.onTouchEvent(event);
	}

}
