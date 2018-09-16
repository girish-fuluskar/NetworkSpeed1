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



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class NetworkSpeed1 extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        } else if(action.equals("startServiceNow")) {
            this.startServiceNow();
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void startServiceNow(){
        ISMService ismService = new ISMService();
        final Intent ismServiceIntent = new Intent(this,ismService.class);
        ismServiceIntent.setPackage(this.getPackageName());

        startService(ismServiceIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mHelper == null) return;

        // Pass on the activity result to the helper for handling
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        final Intent ismServiceIntent = new Intent(this, ISMService.class);
        ismServiceIntent.setPackage(this.getPackageName());

        //Switch meterSwitch = (Switch) findViewById(R.id.meter_switch);

        /*Get meter state so that we'll know if it's enabled/disabled by user upon start*/
        //SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.shared_pref), Context.MODE_PRIVATE);
        //int state = sharedPref.getInt(getString(R.string.meter_state), 1);
        //if (state == 1) {
        //    meterSwitch.setChecked(true);
        //}

        //final SharedPreferences.Editor editor = sharedPref.edit();

        // meterSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        //     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //         if (isChecked) {
        //             editor.putInt(getString(R.string.meter_state), 1);
        //             editor.commit();
        //             startService(ismServiceIntent);
        //         } else {
        //             editor.putInt(getString(R.string.meter_state), 0);
        //             editor.commit();
        //             stopService(ismServiceIntent);
        //         }
        //     }
        // });

        startService(ismServiceIntent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // very important:
        if (mHelper != null) {
            mHelper.disposeWhenFinished();
            mHelper = null;
        }
    }

}
