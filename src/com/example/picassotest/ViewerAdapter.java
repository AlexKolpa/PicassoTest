package com.example.picassotest;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.squareup.picasso.Picasso;

public class ViewerAdapter extends PagerAdapter {

	// credit to reddit.com/r/earthporn
	String[] urls = new String[] {
			"http://pcdn.500px.net/34102694/dac718069d325000baded2cdefe0d99cef2f5828/5.jpg",
			"http://i.imgur.com/F21IZqc.jpg",
			"http://cdn.theatlantic.com/static/infocus/bhutan111811/b04_21999870.jpg",
			"http://i.imgur.com/gjD9A24h.jpg",
			"http://i.imgur.com/ljNbVfn.jpg", "http://i.imgur.com/uOkdtte.jpg",
			"http://i.imgur.com/u93TaOt.jpg", "http://i.imgur.com/yr7N5dG.jpg" };

	@Override
	public int getCount() {
		return urls.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (View) arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);

		Picasso.with(container.getContext()).cancelRequest((ImageView) object);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return (position + "/" + getCount());
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView photo = new ImageView(container.getContext());
		photo.setScaleType(ScaleType.FIT_START);

		Picasso.with(container.getContext()).load(urls[position]).into(photo);

		container.addView(photo);

		return photo;
	}
}
