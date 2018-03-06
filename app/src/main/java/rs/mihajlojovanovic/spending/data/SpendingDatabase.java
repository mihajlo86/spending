package rs.mihajlojovanovic.spending.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import javax.inject.Singleton;

import rs.mihajlojovanovic.spending.data.daos.GasStationDao;
import rs.mihajlojovanovic.spending.data.entities.EntryEntity;
import rs.mihajlojovanovic.spending.data.entities.FuelTypeEntity;
import rs.mihajlojovanovic.spending.data.entities.GasStationEntity;
import rs.mihajlojovanovic.spending.data.converters.DateConverter;

@Database(entities = {GasStationEntity.class, FuelTypeEntity.class, EntryEntity.class}, version = 1)
@TypeConverters({DateConverter.class})
@Singleton
public abstract class SpendingDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "spending";

    public abstract GasStationDao gasStationDao();

}
