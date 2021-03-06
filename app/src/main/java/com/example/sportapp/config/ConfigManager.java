package com.example.sportapp.config;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import java.util.Locale;

public class ConfigManager {

    public static void setAppLocale(String localeCode, Context context){
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        resources.updateConfiguration(config, dm);
    }

    public static void setOrientation(Context context, LinearLayout layout){
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // landscape
            layout.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            // portrait
            layout.setOrientation(LinearLayout.VERTICAL);
        }
    }
}
