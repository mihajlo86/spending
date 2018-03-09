package rs.mihajlojovanovic.spending.dependencyinjection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import rs.mihajlojovanovic.spending.App;
import rs.mihajlojovanovic.spending.views.fragments.FuelConsumptionFragment;

@Singleton
@Component(modules = {AppModule.class, RoomModule.class})
public interface AppComponent extends AndroidInjector<App> {

    void inject(FuelConsumptionFragment fuelConsumptionFragment);

    Application application();

}
