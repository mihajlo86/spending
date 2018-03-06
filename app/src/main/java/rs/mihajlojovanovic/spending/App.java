package rs.mihajlojovanovic.spending;

import android.app.Application;

import rs.mihajlojovanovic.spending.dependencyinjection.AppComponent;
import rs.mihajlojovanovic.spending.dependencyinjection.AppModule;
import rs.mihajlojovanovic.spending.dependencyinjection.DaggerAppComponent;
import rs.mihajlojovanovic.spending.dependencyinjection.RoomModule;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {

        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .roomModule(new RoomModule(this))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
