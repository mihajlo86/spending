package rs.mihajlojovanovic.spending.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import rs.mihajlojovanovic.spending.data.entities.GasStationEntity;
import rs.mihajlojovanovic.spending.data.repositories.GasStationRepository;

public class GasStationViewModel extends ViewModel {

    private GasStationRepository gasStationRepository;

    GasStationViewModel(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public LiveData<List<GasStationEntity>> getAllGasStations() {
        return gasStationRepository.getAllGasStations();
    }

}
