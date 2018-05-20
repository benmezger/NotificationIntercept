package nl.seds.interceptme;

import java.io.Serializable;
import java.util.Calendar;


public class NotificationData implements Serializable {
    private String title;
    private String text;
    private String packageName;
    private String appName;
    private String date;

    public NotificationData(String title, String text, String packageName, String appName){
        this.title = title;
        this.text = text;
        this.packageName = packageName;
        this.appName = appName;
        this.date = Calendar.getInstance().getTime().toString(); /* TODO: Get date from notification somehow */
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle(){
        return this.title;
    }

    public String getText(){
        return this.text;
    }

    public String getPackageName(){
        return this.packageName;
    }

    public String getAppName(){
        return this.appName;
    }
}
