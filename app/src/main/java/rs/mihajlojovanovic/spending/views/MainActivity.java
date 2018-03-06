package rs.mihajlojovanovic.spending.views;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import rs.mihajlojovanovic.spending.R;
import rs.mihajlojovanovic.spending.views.adapters.DrawerItem;
import rs.mihajlojovanovic.spending.views.adapters.DrawerItemAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Class " + MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        initializeDrawerMenu();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new MainFragment()).commit();


    }

    private void initializeDrawerMenu()
    {
        final String[] labels = { getString(R.string.spending) };
        final int[] icons = { R.drawable.notification_circle };
        ListView drawerList = findViewById(R.id.leftDrawer);
        ArrayList<DrawerItem> drawerItems = new ArrayList<>();
        for (int i = 0; i < labels.length; i++)
        {
            DrawerItem drawerItem = new DrawerItem();
            drawerItem.setLabel(labels[i]);
            drawerItem.setIcon(icons[i]);
            drawerItems.add(drawerItem);
        }
        DrawerItemAdapter adapter = new DrawerItemAdapter(this, R.layout.drawer_item, drawerItems);
        drawerList.setAdapter(adapter);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
//        drawerList.setOnItemClickListener(new DrawerItemClickListener(this, drawerList, drawerLayout));
//        Toolbar toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, null, R.string.app_name,
                R.string.app_name);
        drawerToggle.syncState();
//        drawerToggle.setDrawerArrowDrawable(badgeDrawable);
//        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(drawerToggle);
    }

}
