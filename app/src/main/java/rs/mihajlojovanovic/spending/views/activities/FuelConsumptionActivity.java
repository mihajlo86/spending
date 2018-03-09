package rs.mihajlojovanovic.spending.views.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import rs.mihajlojovanovic.spending.R;
import rs.mihajlojovanovic.spending.views.fragments.FuelConsumptionFragment;
import rs.mihajlojovanovic.spending.views.adapters.SideMenuItem;
import rs.mihajlojovanovic.spending.views.adapters.SideMenuItemAdapter;
import rs.mihajlojovanovic.spending.views.adapters.SideMenuItemClickListener;

public class FuelConsumptionActivity extends AppCompatActivity {

    private static final String TAG = "Class " + FuelConsumptionActivity.class.getSimpleName();
    private DrawerLayout drawerLayout;
    private ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_consumption);
        Log.d(TAG, "onCreate");
        initializeDrawerMenu();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new FuelConsumptionFragment()).commit();


    }

    private void initializeDrawerMenu() {
        final String[] labels = {getString(R.string.fuel_consumption), getString(R.string.cash_flow)};
        final int[] icons = {R.drawable.notification_circle, 0};
        drawerList = findViewById(R.id.leftDrawer);
        ArrayList<SideMenuItem> sideMenuItems = new ArrayList<>();
        for (int i = 0; i < labels.length; i++) {
            SideMenuItem sideMenuItem = new SideMenuItem();
            sideMenuItem.setLabel(labels[i]);
            sideMenuItem.setIcon(icons[i]);
            sideMenuItems.add(sideMenuItem);
        }
        SideMenuItemAdapter adapter = new SideMenuItemAdapter(this, R.layout.drawer_item, sideMenuItems);
        drawerList.setAdapter(adapter);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList.setOnItemClickListener(new SideMenuItemClickListener(this, drawerList, drawerLayout));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name,
                R.string.app_name);
        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorAccent));
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerLayout.isDrawerOpen(drawerList))
            drawerLayout.closeDrawer(drawerList);
        else
            drawerLayout.openDrawer(drawerList);
        return true;

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
