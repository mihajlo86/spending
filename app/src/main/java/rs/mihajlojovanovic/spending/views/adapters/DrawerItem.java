package rs.mihajlojovanovic.spending.views.adapters;

import android.util.Log;

public class DrawerItem {

    private static final String TAG = "Class " + DrawerItem.class.getSimpleName();
    private int icon;
    private String label;
    private String notification;

    public int getIcon() {
        return icon;
    }

    public String getLabel() {
        return label;
    }

    String getNotification() {
        return notification;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    int getNotificationsCount() {
        int count = 0;
        try {
            if (null != notification) {
                count = Integer.parseInt(notification);
            }
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        return count;
    }

}
