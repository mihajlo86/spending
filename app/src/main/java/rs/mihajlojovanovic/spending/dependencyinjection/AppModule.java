package rs.mihajlojovanovic.spending.dependencyinjection;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import rs.mihajlojovanovic.spending.App;

@Module
public class AppModule {

    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    App providesApp() {
        return app;
    }

    @Provides
    Application provideApplication() {
        return app;
    }

}
