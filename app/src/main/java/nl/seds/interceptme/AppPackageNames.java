package nl.seds.interceptme;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public final class AppPackageNames {
    public static final String FACEBOOK_PACK_NAME = "com.facebook.katana";
    public static final String FACEBOOK_MESSENGER_PACK_NAME = "com.facebook.orca";
    public static final String WHATSAPP_PACK_NAME = "com.whatsapp";
    public static final String INSTAGRAM_PACK_NAME = "com.instagram.android";
    public static final String SIGNAL_PACK_NAME = "org.thoughtcrime.securesms";
    public static final String ANDROID_PACK_NAME = "android";

    public static final String getPkgName(String pkgname){
        PackageManager pm = App.context.getPackageManager();
        ApplicationInfo ai;

        try {
            ai = pm.getApplicationInfo(pkgname, 0);
        }
        catch (PackageManager.NameNotFoundException e){
            ai = null;
        }

        return (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");
    }

}
