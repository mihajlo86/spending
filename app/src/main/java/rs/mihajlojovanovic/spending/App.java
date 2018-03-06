package rs.mihajlojovanovic.spending;

import android.app.Application;
import android.content.SharedPreferences;

import rs.mihajlojovanovic.spending.dependencyinjection.AppComponent;
import rs.mihajlojovanovic.spending.dependencyinjection.AppModule;
import rs.mihajlojovanovic.spending.dependencyinjection.DaggerAppComponent;
import rs.mihajlojovanovic.spending.dependencyinjection.RoomModule;

public class App extends Application {

    private static final String PREFERENCES = "Preferences";
    private AppComponent appComponent;
    public static SharedPreferences SHARED_PREFERENCES;

    @Override
    public void onCreate() {

        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .roomModule(new RoomModule(this))
                .build();
        SHARED_PREFERENCES = getSharedPreferences(PREFERENCES, MODE_PRIVATE);


    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
