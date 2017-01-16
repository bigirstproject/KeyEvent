package com.duowan.keyevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;

import com.duowan.util.LogCat;
import com.duowan.util.ToastShowUtil;

public class CustomButton extends Button {
	private boolean isCanScroll = true;

	public CustomButton(Context context) {
		super(context);
	}

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void setScanScroll(boolean isCanScroll) {
		this.isCanScroll = isCanScroll;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		LogCat.d("CustomButton : onTouchEvent  " + ev.getAction());
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
	public boolean dispatchKeyEvent(KeyEvent ev) {

		ToastShowUtil.showMsgShort(getContext(), "dispatchKeyEvent");
		LogCat.d("CustomButton : dispatchKeyEvent  " + ev.getAction());
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
