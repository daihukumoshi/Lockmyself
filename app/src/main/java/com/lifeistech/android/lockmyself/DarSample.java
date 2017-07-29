package com.lifeistech.android.lockmyself;

/**
 * Created by mikikyouka on 2017/07/10.
 */

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 何もしない。
 */
public class DarSample extends DeviceAdminReceiver {

    @Override
    public void onEnabled(Context context, Intent intent) {
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
    }
}