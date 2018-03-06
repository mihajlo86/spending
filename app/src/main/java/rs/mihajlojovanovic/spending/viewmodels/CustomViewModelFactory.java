package rs.mihajlojovanovic.spending.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import rs.mihajlojovanovic.spending.data.repositories.GasStationRepository;


@Singleton
public class CustomViewModelFactory implements ViewModelProvider.Factory {

    private GasStationRepository gasStationRepository;

    @Inject
    public CustomViewModelFactory(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(GasStationViewModel.class))
            return (T) new GasStationViewModel(gasStationRepository);
        else
            throw new IllegalArgumentException("ViewModel not found");
    }
}
