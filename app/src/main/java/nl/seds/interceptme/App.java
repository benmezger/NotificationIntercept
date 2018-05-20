package nl.seds.interceptme;

import android.app.Application;
import android.content.Context;

/**
 * App: Returns the main application context.
 * This is a cleaner way instead of passing the Context around as an argument
 */
public class App extends Application {
    public static Context context;

    @Override public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
