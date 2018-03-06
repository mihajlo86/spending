package rs.mihajlojovanovic.spending.views;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rs.mihajlojovanovic.spending.App;
import rs.mihajlojovanovic.spending.R;
import rs.mihajlojovanovic.spending.data.entities.GasStationEntity;
import rs.mihajlojovanovic.spending.viewmodels.GasStationViewModel;
import rs.mihajlojovanovic.spending.views.adapters.DrawerItem;
import rs.mihajlojovanovic.spending.views.adapters.DrawerItemAdapter;

import static rs.mihajlojovanovic.spending.App.SHARED_PREFERENCES;

public class MainFragment extends Fragment {

    private static final String TAG = "Class " + MainFragment.class.getSimpleName();

    @Inject
    ViewModelProvider.Factory factory;

    GasStationViewModel gasStationViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        ((App) getActivity().getApplication()).getAppComponent().inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView");
        gasStationViewModel = ViewModelProviders.of(this, factory).get(GasStationViewModel.class);
        LiveData<List<GasStationEntity>> data = gasStationViewModel.getAllGasStations();
        data.observe(this, new Observer<List<GasStationEntity>>() {
            @Override
            public void onChanged(@Nullable List<GasStationEntity> gasStationEntities) {
                Log.d(TAG, gasStationEntities.get(0).getName());
            }
        });
        return inflater.inflate(R.layout.fragment_main, container, false);

    }
}
