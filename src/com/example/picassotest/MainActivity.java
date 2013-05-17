package com.example.picassotest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockActivity;

public class MainActivity extends SherlockActivity {
	
	public static final String POSITION = "start_position";

	static final int page_limit = 0;	
	int mStartPosition = 0;

	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getSupportActionBar().setHomeButtonEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		
		mViewPager = new ViewPager(this);
		mViewPager.setOffscreenPageLimit(page_limit);

		setContentView(mViewPager);
		
		if(savedInstanceState != null)
			mStartPosition = savedInstanceState.getInt(POSITION);

		createAdapter();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putInt(POSITION, mViewPager.getCurrentItem());
	}

	void createAdapter() {
		ViewerAdapter adapter = new ViewerAdapter();
		mViewPager.setAdapter(adapter);
		mViewPager.setCurrentItem(mStartPosition);		
	}
}
