package rs.mihajlojovanovic.spending.views.adapters;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import rs.mihajlojovanovic.spending.views.activities.CashFlowActivity;
import rs.mihajlojovanovic.spending.views.activities.FuelConsumptionActivity;

public class SideMenuItemClickListener implements AdapterView.OnItemClickListener {

    private static final String TAG = "Class " + SideMenuItemClickListener.class.getSimpleName();
    private FragmentActivity activity;
    private ListView drawerList;
    private DrawerLayout drawerLayout;

    public SideMenuItemClickListener(FragmentActivity activity, ListView drawerList, DrawerLayout drawerLayout) {
        this.activity = activity;
        this.drawerList = drawerList;
        this.drawerLayout = drawerLayout;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent i = new Intent(activity, activity.getClass());
        switch (position) {
            case 0:
                if (activity.getClass().getSimpleName().equals(FuelConsumptionActivity.class.getSimpleName()))
                    break;
                activity.startActivity(i);
                break;
            case 1:
                if (activity.getClass().getSimpleName().equals(CashFlowActivity.class.getSimpleName()))
                    break;
                activity.startActivity(i);
            default:
                break;
        }
        if (activity != null) {

            drawerLayout.closeDrawer(drawerList);

        }

    }

}
