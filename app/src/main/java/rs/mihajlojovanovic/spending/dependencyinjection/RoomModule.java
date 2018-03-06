package rs.mihajlojovanovic.spending.dependencyinjection;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rs.mihajlojovanovic.spending.data.SpendingDatabase;
import rs.mihajlojovanovic.spending.data.daos.GasStationDao;
import rs.mihajlojovanovic.spending.data.repositories.GasStationRepository;
import rs.mihajlojovanovic.spending.viewmodels.CustomViewModelFactory;

@Module
public class RoomModule {

    private final SpendingDatabase database;

    public RoomModule(Application application) {

        this.database = Room.databaseBuilder(
                application,
                SpendingDatabase.class,
                SpendingDatabase.DATABASE_NAME
        ).build();

    }

    @Provides
    @Singleton
    SpendingDatabase provideSpendingDatabase(Application application) {
        return database;
    }

    @Provides
    @Singleton
    GasStationDao provideGasStationDao(SpendingDatabase database) {
        return database.gasStationDao();
    }

    @Provides
    @Singleton
    GasStationRepository provideGasStationRepository(GasStationDao gasStationDao) {
        return new GasStationRepository(gasStationDao);
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(GasStationRepository gasStationRepository) {
        return new CustomViewModelFactory(gasStationRepository);
    }
}
