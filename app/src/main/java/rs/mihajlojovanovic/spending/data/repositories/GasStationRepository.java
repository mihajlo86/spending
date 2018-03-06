package rs.mihajlojovanovic.spending.data.repositories;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import rs.mihajlojovanovic.spending.data.daos.GasStationDao;
import rs.mihajlojovanovic.spending.data.entities.GasStationEntity;

public class GasStationRepository {

    private final GasStationDao gasStationDao;

    @Inject
    public GasStationRepository(GasStationDao gasStationDao) {
        this.gasStationDao = gasStationDao;
    }

    public LiveData<List<GasStationEntity>> getAllGasStations() {
        return gasStationDao.getAllGasStationsLiveData();
    }

}
