package nl.seds.interceptme;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class UserNotify {
    private String title;
    private String content;
    private String pkgName;
    private Context ctx = App.context.getApplicationContext();

    public UserNotify(String title, String content, String pkgName){
        this.title = title;
        this.content = content;
        this.pkgName = pkgName;
    }

    public void sendNotification(View view) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this.ctx)
                .setSmallIcon(R.drawable.ic_launcher_background) /* TODO: Add custom icon */
                .setContentTitle(this.title)
                .setContentText(this.content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Drawable pkg_icon;
        try {
            pkg_icon = this.ctx.getPackageManager().getApplicationIcon(this.pkgName);
            Bitmap bitmap = ((BitmapDrawable) pkg_icon).getBitmap();
            mBuilder.setLargeIcon(bitmap);
        }
        catch (PackageManager.NameNotFoundException e){
            ;;
        }

        /* Get an instance of the NotificationManager service */
        NotificationManager mNotificationManager =
                (NotificationManager) ctx.getSystemService(this.ctx.NOTIFICATION_SERVICE);

        mNotificationManager.notify(001, mBuilder.build());
    }
}
