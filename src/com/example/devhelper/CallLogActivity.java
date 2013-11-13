package com.example.devhelper;

import java.util.Random;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.TextView;

public class CallLogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calllog_main);
	}

	public void addCalllog(View v) {
		Random ran = new Random();
		for (int i = 0; i < 20; i++) {
			ContentValues values = new ContentValues();
			values.put(CallLog.Calls.TYPE, ran.nextInt(3) + 1);
			values.put(CallLog.Calls.NUMBER, "13823699999");
			values.put(CallLog.Calls.DATE, System.currentTimeMillis() - (ran.nextInt(4) * 24 * 3600 * 1000));
			values.put(CallLog.Calls.NEW, "0");
			getContentResolver().insert(CallLog.Calls.CONTENT_URI, values);
		}

	}
}
