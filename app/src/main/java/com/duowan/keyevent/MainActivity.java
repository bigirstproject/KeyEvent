package com.duowan.keyevent;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.duowan.util.LogCat;
import com.duowan.util.ToastShowUtil;
import com.sunsun.keyevent.R;

public class MainActivity extends Activity implements OnClickListener {

	private Button mButton1;
	private Button mButton2;
	private CustomViewPager mViewPager;
	private ViewPagerAdapter mAdapter;
	private boolean isCanScroll = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton1 = (Button) findViewById(R.id.button1);
		mButton2 = (Button) findViewById(R.id.button2);
		mViewPager = (CustomViewPager) findViewById(R.id.viewpager);
		mViewPager.setOffscreenPageLimit(2);// 设置viewPager不进行预加载
		mViewPager.setScanScroll(true);// 设置可以滑动
		mButton1.setOnClickListener(this);
		mButton2.setOnClickListener(this);
		customView();
	}

	public void customView() {
		mAdapter = new ViewPagerAdapter(this);
		mViewPager.setAdapter(mAdapter);

		List<View> resList = new ArrayList<View>();
		View layout1 = getLayoutInflater()
				.inflate(R.layout.viewpager_one, null);
		resList.add(layout1);
		View layout2 = getLayoutInflater()
				.inflate(R.layout.viewpager_two, null);
		resList.add(layout2);
		resList.add(new View(this));
		mAdapter.updateDatasource(resList);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:

			break;
		case R.id.button2:
			ToastShowUtil.showMsgShort(this, "R.id.button2");
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// ToastShowUtil.showMsgShort(this, "onTouchEvent");
		LogCat.d(" MainActivity  onTouchEvent  " + ev.getAction());
		if (isCanScroll) {
			return super.onTouchEvent(ev);
		}
		return false;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// ToastShowUtil.showMsgShort(this, "dispatchTouchEvent");
		LogCat.d(" MainActivity  dispatchTouchEvent  " + ev.getAction());
		// return true;

		if (isCanScroll) {
			return super.dispatchTouchEvent(ev);
		}
		return false;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		ToastShowUtil.showMsgShort(this, "MainActivity  dispatchKeyEvent  "
				+ event.getAction());
		if (isCanScroll) {
			return super.dispatchKeyEvent(event);
		}
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		ToastShowUtil.showMsgShort(this,
				"MainActivity  onKeyDown   " + event.getAction());
		if (isCanScroll) {
			return super.onKeyDown(keyCode, event);
		}
		return false;
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		ToastShowUtil.showMsgShort(this, "MainActivity  onKeyLongPress  "
				+ event.getAction());
		if (isCanScroll) {
			return super.onKeyLongPress(keyCode, event);
		}
		return false;
	}

}
