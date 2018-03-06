package rs.mihajlojovanovic.spending.data.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import rs.mihajlojovanovic.spending.data.entities.GasStationEntity;

@Dao
public interface GasStationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGasStations(GasStationEntity... gasStationEntities);

    @Query("SELECT * FROM gas_stations")
    List<GasStationEntity> getAllGasStations();

    @Query("SELECT * FROM gas_stations ORDER BY name")
    LiveData<List<GasStationEntity>> getAllGasStationsLiveData();

}
