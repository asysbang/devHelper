package com.example.devhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

	private ListView mList;

	private static final int ITEM_CANVAS = 0;
	private static final int ITEM_RTSP = 1;
	private static final int ITEM_INFO = 2;
	private static final int ITEM_RES = 3;
	private static final int ITEM_ROTATED = 4;
	private static final int ITEM_BEAUTIFIED_UI = 5;
	private static final int ITEM_USB_HOST = 6;
	private static final int ITEM_PHONE = 7;
	private static final int ITEM_TITLE = 8;
	private static final int ITEM_CROP = 9;
	private static final int ITEM_CAMERA = 10;
	private static final int ITEM_NETWORK = 11;
	private static final int ITEM_LIST_SEEK = 12;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mList = (ListView) findViewById(R.id.main_list);
		mList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(
				R.array.main_items)));
		mList.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		switch (pos) {
		case ITEM_CANVAS:
			startActivity(new Intent(this, CanvasActivity.class));
			break;
		case ITEM_RTSP:
			startActivity(new Intent(this, OpenRtspActivity.class));
			break;
		case ITEM_INFO:
			startActivity(new Intent(this, SystemInfoActivity.class));
			break;
		case ITEM_RES:
			startActivity(new Intent(this, ResourceActivity.class));
			break;
		case ITEM_ROTATED:
			startActivity(new Intent(this, ShowRotatedPictureActivity.class));
			break;
		case ITEM_BEAUTIFIED_UI:
			startActivity(new Intent(this, BeautifiedUIActivity.class));
			break;
		case ITEM_USB_HOST:
			startActivity(new Intent(this, UsbHostDemo.class));
			break;
		case ITEM_PHONE:
			startActivity(new Intent(this, PhoneActivity.class));
			break;
		case ITEM_TITLE:
			startActivity(new Intent(this, TitleActivity.class));
			break;
		case ITEM_CROP:
			startActivity(new Intent(this, ImageCropActivity.class));
			break;
		case ITEM_CAMERA:
			startActivity(new Intent(this, CameraActivity.class));
			break;
		case ITEM_NETWORK:
			startActivity(new Intent(this, NetworkStateReceiver.class));
			break;
		case ITEM_LIST_SEEK:
			startActivity(new Intent(this, ListViewDemo.class));
			break;
		default:
			break;
		}
	}

}
