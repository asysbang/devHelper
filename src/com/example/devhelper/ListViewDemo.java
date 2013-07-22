package com.example.devhelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

public class ListViewDemo extends Activity {

	private ListView mList;

	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			Random r = new Random(System.currentTimeMillis());
			int i = r.nextInt(8);
			i = i % 2;
			int pro = date.get(i).getPro();
			date.get(i).setPro(pro + 2);
			((MyAdapter) mList.getAdapter()).notifyDataSetChanged();
			mHandler.sendEmptyMessageDelayed(0, 999);
		}
	};

	private List<Model> date = new ArrayList<Model>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		date.add(new Model());
		date.add(new Model());
		mList = (ListView) findViewById(R.id.main_list);
		mList.setAdapter(new MyAdapter(this));
		mHandler.sendEmptyMessage(0);
	}

	private class MyAdapter extends BaseAdapter {
		private Context mContext;

		public MyAdapter(Context context) {
			mContext = context;
		}

		@Override
		public int getCount() {
			return date.size();
		}

		@Override
		public Object getItem(int position) {
			return date.get(position);
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int arg0, View convertView, ViewGroup arg2) {
			if (convertView == null) {
				LayoutInflater inflater = LayoutInflater.from(mContext);
				convertView = inflater.inflate(R.layout.list_item, null);
			}
			SeekBar seek = (SeekBar) convertView.findViewById(R.id.seek);
			seek.setProgress(date.get(arg0).getPro());
			return convertView;
		}

	}

	private class Model {
		public int getPro() {
			return pro;
		}

		public void setPro(int pro) {
			this.pro = pro;
		}

		int pro;
	}
}
