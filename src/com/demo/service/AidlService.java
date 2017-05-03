package com.demo.service;

import com.demo.aidl.IMyAidl;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AidlService extends Service {

	private String TAG = "Dylan_AIDL";
	// 声明AIDL
	private MyBind mBind;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		init();
	}

	private void init() {
		// 创建MyBind
		mBind = new MyBind();
		Log.e(TAG, "****init创建MyBind");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.e(TAG, "****onUnbind");
		return super.onUnbind(intent);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.e(TAG, "****onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.e(TAG, "****onBind");
		return mBind;
	}

	/**定义在服务端的方法**/
	private void play() {
		Log.e(TAG, "****AidlService中定义的play方法");
	}

	private void pause() {
		Log.e(TAG, "****AidlService中定义的play方法");
	}

	/** MyBind继承自IMyAidl.Stub(aidl.Stub) **/
	private class MyBind extends IMyAidl.Stub {

		@Override
		public void play() throws RemoteException {
			// TODO Auto-generated method stub
			AidlService.this.play();
		}

		@Override
		public void pause() throws RemoteException {
			// TODO Auto-generated method stub
			AidlService.this.pause();
		}
	}
}
