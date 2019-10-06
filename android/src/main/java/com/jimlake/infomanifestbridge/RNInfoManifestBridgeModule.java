package com.jimlake.infomanifestbridge;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Locale;
import java.util.HashMap;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class RNInfoManifestBridgeModule extends ReactContextBaseJavaModule {
  public static final String TAG = "RNInfoManifestBridgeModule";

  private final ReactApplicationContext reactContext;

  public RNInfoManifestBridgeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNInfoManifestBridge";
  }

  @Override
  public @Nullable Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();

    try {
      final ApplicationInfo ai = reactContext.getPackageManager().getApplicationInfo(reactContext.getPackageName(),PackageManager.GET_META_DATA);
      final Bundle bundle = ai.metaData;
      for (String key : bundle.keySet()) {
        final String value = bundle.get(key).toString();
        constants.put(key,value);
      }

      final int labelId = ai.labelRes;
      final String displayName = labelId == 0 ? ai.nonLocalizedLabel.toString() : reactContext.getString(labelId);
      constants.put("displayName",displayName);
      constants.put("bundleName",displayName);
    } catch (final Exception e) {
      Log.e(TAG,"Failed to pull things from manifest",e);
    }

    try {
      final PackageInfo pInfo = reactContext.getPackageManager().getPackageInfo(reactContext.getPackageName(),0);
      final String versionCode = String.valueOf(pInfo.versionCode);
      constants.put("bundleIdentifier",pInfo.packageName);
      constants.put("shortVersion",pInfo.versionName);
      constants.put("version",versionCode);
      constants.put("androidVersionCode",versionCode);
    } catch (final Exception e) {
      Log.e(TAG,"Failed to pull from package info",e);
    }

    final String deviceName = _getDeviceName();
    final String language = Locale.getDefault().getLanguage().toLowerCase();
    final String country = _getCountry();
    constants.put("androidVersion",Build.VERSION.RELEASE);
    constants.put("androidDeviceName",deviceName);
    constants.put("language",language);
    constants.put("country",country);

    return constants;
  }

  private String _getDeviceName() {
    final String brand = Build.BRAND; //= "motorola"
    final String model = Build.MODEL; //= "XT1053"

    String deviceType = "";
    if (model.startsWith(brand)) {
      deviceType = model;
    } else {
      deviceType = brand + " " + model;
    }
    return deviceType;
  }

  private String _getCountry() {
    String country = Locale.getDefault().getCountry();

    try {
      final TelephonyManager tm = (TelephonyManager)reactContext.getSystemService(Context.TELEPHONY_SERVICE);
      final String simCountry = tm.getSimCountryIso();
      if (simCountry != null && simCountry.length() == 2) {
        country = simCountry;
      } else {
        final String networkCountry = tm.getNetworkCountryIso();
        if (networkCountry != null && networkCountry.length() == 2) {
          country = networkCountry;
        }
      }
    } catch(final Exception e) {
      Log.e(TAG,"getCountry: get network country failed",e);
    }
    return country.toUpperCase();
  }

}
