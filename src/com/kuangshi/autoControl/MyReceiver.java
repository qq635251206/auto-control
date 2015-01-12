package com.kuangshi.autoControl;

import com.kuangshi.autoControl.util.LogUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.ViewDebug.FlagToString;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "onReceive", Toast.LENGTH_LONG).show();
		Intent i = new Intent(context, MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
	}

}
