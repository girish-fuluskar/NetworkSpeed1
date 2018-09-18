package cordova.plugin.networkspeed1;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.Locale;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class NetworkSpeed1 extends CordovaPlugin {

    private final int mNotificationId = 1;
    private Handler mHandler;
    private Notification.Builder mBuilder;
    private NotificationManager mNotifyMgr;
    private String mDownloadSpeedOutput;
    private String mUnits;
    private boolean mDestroyed = false;


    @Override
    public boolean execute(String action,Context context, CallbackContext callbackContext) throws JSONException {
        if(action.equals("startServiceNow")) {
            this.startServiceNow(context);
            return true;
        }
        return false;
    }

    //Initiate Service
    private void startServiceNow(Context context){
        console.Log("Initiate Plugin Service");
        initializeNotification(context);
    }

    //Initialize Notification
    private void initializeNotification(Context context){
        console.Log("Initializing Notifications with context: " + context);

    }
}
