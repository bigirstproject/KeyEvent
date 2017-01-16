package com.duowan.keyevent;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.duowan.util.LogCat;
import com.duowan.util.ToastShowUtil;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CustomViewPager extends android.support.v4.view.ViewPager {
	private boolean isCanScroll = true;

	public CustomViewPager(Context context) {
		super(context);
	}

	public CustomViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setScanScroll(boolean isCanScroll) {
		this.isCanScroll = isCanScroll;
	}

	@Override
	public void scrollTo(int x, int y) {
		// LogCat.d("scrollTo  x = " + x + "   Y = " + y);
		if (isCanScroll) {
			super.scrollTo(x, y);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		LogCat.d("onTouchEvent  " + ev.getAction());
		// ToastShowUtil.showMsgShort(getContext(), "onTouchEvent");
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:

			break;
		case MotionEvent.ACTION_MOVE:

			break;
		case MotionEvent.ACTION_UP:

			break;
		default:
			break;
		}
		
		if (isCanScroll) {
			return super.onTouchEvent(ev);
		}
		return false;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		LogCat.d("onInterceptTouchEvent  " + ev.getAction());
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// return true;
			break;
		case MotionEvent.ACTION_MOVE:
			// return true;
			break;
		case MotionEvent.ACTION_UP:
			// return true;
			break;
		default:
			break;
		}

		// ToastShowUtil.showMsgShort(getContext(), "onInterceptTouchEvent");
		if (isCanScroll) {
			return super.onInterceptTouchEvent(ev);
		}
		return false;
	}

	@Override
	public boolean beginFakeDrag() {

		LogCat.d("beginFakeDrag ");
		return true;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent ev) {

		ToastShowUtil.showMsgShort(getContext(), "dispatchKeyEvent");
		LogCat.d("dispatchKeyEvent  " + ev.getAction());
		if (isCanScroll) {
			return super.dispatchKeyEvent(ev);
		}
		switch (ev.getAction()) {
		case KeyEvent.ACTION_DOWN:

			break;
		case KeyEvent.ACTION_UP:

			break;
		default:
			break;
		}
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		ToastShowUtil.showMsgShort(getContext(), "onKeyDown");
		if (isCanScroll) {
			return super.onKeyDown(keyCode, event);
		}
		return false;
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		ToastShowUtil.showMsgShort(getContext(), "onKeyLongPress");
		if (isCanScroll) {
			return super.onKeyLongPress(keyCode, event);
		}
		return false;
	}
}
