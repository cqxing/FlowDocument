package com.cndatacom.flowdocument.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by staring on 16-11-16.
 */

public class HeartBeatReceiver extends BroadcastReceiver {

    private Context context;

    public HeartBeatReceiver(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_TIME_TICK)) {
            //now heartBeat
            Log.e("staring", "Beat");
            Toast.makeText(context, "Beat", Toast.LENGTH_LONG).show();
        }
    }
}
