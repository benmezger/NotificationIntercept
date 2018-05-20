package nl.seds.interceptme;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import java.util.HashMap;

public class InterceptNotification extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        HashMap<String, NotificationData> notificationData = new HashMap<>();
        for (StatusBarNotification sbm : this.getActiveNotifications()) {
            String title = sbm.getNotification().extras.getCharSequence(Notification.EXTRA_TITLE).toString();
            String text = sbm.getNotification().extras.getCharSequence(Notification.EXTRA_TEXT).toString();

            String pkgName =  sbm.getPackageName();
            String appName = AppPackageNames.getPkgName(pkgName);
            Object date = sbm.getNotification().extras.getSerializable("when");

            NotificationData tmp = new NotificationData(title, text, pkgName, appName);
            notificationData.put(title, tmp);
        }

        Intent intent = new Intent("nl.seds.interceptme");
        intent.putExtra("notification_data", notificationData);

        sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }


    private AppPackageCodes matchNotificationCode(String package_name) {

        if (package_name.equals(AppPackageNames.FACEBOOK_MESSENGER_PACK_NAME) ||
                package_name.equals(AppPackageNames.FACEBOOK_PACK_NAME)) {
            return AppPackageCodes.FACEBOOK_CODE;
        }

        if (package_name.equals(AppPackageNames.INSTAGRAM_PACK_NAME)) {
            return AppPackageCodes.INSTAGRAM_CODE;
        }

        if (package_name.equals(AppPackageNames.WHATSAPP_PACK_NAME)) {
            return AppPackageCodes.WHATSAPP_CODE;
        }

        if (package_name.equals(AppPackageNames.SIGNAL_PACK_NAME)) {
            return AppPackageCodes.SIGNAL_CODE;
        }

        if (package_name.equals(AppPackageNames.ANDROID_PACK_NAME)) {
            return AppPackageCodes.ANDROID;
        }
        return AppPackageCodes.OTHER_NOTIFICATIONS_CODE;
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn){
        // Implement what you want here
    }
}

