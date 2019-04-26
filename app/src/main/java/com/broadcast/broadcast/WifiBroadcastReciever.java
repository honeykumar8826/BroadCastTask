package com.broadcast.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

public class WifiBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String TAG = "TAG";
        Log.i(TAG, "onReceive: " + intent);

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "Boot completed Reciever", Toast.LENGTH_LONG).show();
        }
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();
        }
        if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())) {
            Toast.makeText(context, "Power disconnected", Toast.LENGTH_SHORT).show();
        }
        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            NetworkInfo networkInfo = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            Log.i(TAG, "onReceive: " + networkInfo.isConnected());
            if (networkInfo.isConnected()) {
                // Wifi is connected
                Toast.makeText(context, "Wifi is connected", Toast.LENGTH_SHORT).show();

              //  Log.d("Identify", "Wifi is connected: " + String.valueOf(networkInfo));
            } else {
                Toast.makeText(context, "Wifi is disconnected", Toast.LENGTH_SHORT).show();
            }
        }
        String userPack = "com.harsh";
        if (userPack.equals(intent.getAction())) {
            Toast.makeText(context, "On SecondActivity", Toast.LENGTH_SHORT).show();

        }
    }

}
