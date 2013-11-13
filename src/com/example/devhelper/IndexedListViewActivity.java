package com.example.devhelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class IndexedListViewActivity extends Activity  {

	 public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.index_list_main);  
	        ListView list = (ListView) findViewById(R.id.myListView);  
	        ArrayList<String> stringList = InitListViewData();  
	        IndexListAdapter adapter = new IndexListAdapter(this, stringList);  
	        list.setAdapter(adapter);  
	        SideBar indexBar = (SideBar) findViewById(R.id.sideBar);  
	        indexBar.setListView(list);  
	    }  
	    private ArrayList<String> InitListViewData() {  
	        ArrayList<String> stringList = new ArrayList<String>();  
	        stringList.add("aback");  
	        stringList.add("abash");  
	        stringList.add("abbey");  
	        stringList.add("abhor");  
	        stringList.add("abide");  
	        stringList.add("abuse");  
	        stringList.add("candidate");  
	        stringList.add("capture");  
	        stringList.add("careful");  
	        stringList.add("catch");  
	        stringList.add("cause");  
	        stringList.add("celebrate");  
	        stringList.add("forever");  
	        stringList.add("fable");  
	        stringList.add("fidelity");  
	        stringList.add("fox");  
	        stringList.add("funny");  
	        stringList.add("fail");  
	        stringList.add("jail");  
	        stringList.add("jade");  
	        stringList.add("jailor");  
	        stringList.add("january");  
	        stringList.add("jasmine");  
	        stringList.add("jazz");  
	        stringList.add("zero");  
	        stringList.add("zoo");  
	        stringList.add("zeus");  
	        stringList.add("zebra");  
	        stringList.add("zest");  
	        stringList.add("zing");  
	        return stringList;  
	    }  
}
