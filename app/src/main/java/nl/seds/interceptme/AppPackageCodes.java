package nl.seds.interceptme;

public enum AppPackageCodes {
    OTHER_NOTIFICATIONS_CODE, FACEBOOK_CODE, WHATSAPP_CODE, INSTAGRAM_CODE, SIGNAL_CODE, ANDROID;

    public static boolean contains(AppPackageCodes code) {
        for (AppPackageCodes c : AppPackageCodes.values()) {
            if (c.equals(code)) {
                return true;
            }
        }
        return false;
    }
}
