package com.kuangshi.autoControl;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.kuangshi.autoControl.ReceiverReader.OnLoadProgressListener;
import com.kuangshi.autoControl.bean.IntentFilterInfo;
import com.kuangshi.autoControl.test.R;
import com.kuangshi.autoControl.util.LogUtils;

public class MainActivity extends Activity {
	String TAG = "MainActivityByJane";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        new Thread(){
        	public void run() {
        		ReceiverReader rr = new ReceiverReader(getApplicationContext(), new OnLoadProgressListener() {
					
					public void onProgress(ArrayList<IntentFilterInfo> currentState,
							float progress) {
						LogUtils.d(TAG, "currentState.size = "+ currentState.size() +", progress:"+progress);
					}
				});
        		ArrayList<IntentFilterInfo> arrayList = rr.load();
        		LogUtils.d(TAG, "arrayList.size = "+ arrayList.size());
        		for (int i = 0; i < arrayList.size(); i++) {
					IntentFilterInfo info = arrayList.get(i);
					if(info.componentInfo.packageInfo.packageName.equals("com.kuangshi.autoControl")){
//						Intent intent = new Intent(getApplicationContext(), ToggleService.class);
//						intent.putExtra("component", info.componentInfo);
//						intent.putExtra("state", false);
//						startService(intent);
						LogUtils.d(TAG, info.toString());
					}
				}
        	}
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
