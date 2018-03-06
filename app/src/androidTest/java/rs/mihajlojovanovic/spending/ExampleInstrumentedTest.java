package rs.mihajlojovanovic.spending;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import rs.mihajlojovanovic.spending.data.SpendingDatabase;
import rs.mihajlojovanovic.spending.data.daos.GasStationDao;
import rs.mihajlojovanovic.spending.data.entities.GasStationEntity;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TAG = "Class " + ExampleInstrumentedTest.class.getSimpleName();
    private SpendingDatabase spendingDatabase;
    private GasStationDao gasStationDao;
    private Context context;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("rs.mihajlojovanovic.spending", appContext.getPackageName());
    }

    @Before
    public void createDb() {

        context = InstrumentationRegistry.getTargetContext();
        spendingDatabase = Room.databaseBuilder(context, SpendingDatabase.class, SpendingDatabase.DATABASE_NAME).build();
        gasStationDao = spendingDatabase.gasStationDao();

    }

    @After
    public void closeDb() {

        spendingDatabase.close();

    }

    @Test
    public void insertGasStationsTest() {

        GasStationEntity gasStationEntity1 = new GasStationEntity();
        gasStationEntity1.setName("Lukoil");
        GasStationEntity gasStationEntity2 = new GasStationEntity();
        gasStationEntity2.setName("MOL");
        GasStationEntity[] gasStationEntities = new GasStationEntity[2];
        gasStationEntities[0] = gasStationEntity1;
        gasStationEntities[1] = gasStationEntity2;
        gasStationDao.insertGasStations(gasStationEntities);

    }

    @Test
    public void getAllGasStationsTest() {

        List<GasStationEntity> gasStations = gasStationDao.getAllGasStations();
        for (GasStationEntity gasStation : gasStations)
        {
            Log.d(TAG, gasStation.getName());
        }

    }

}
