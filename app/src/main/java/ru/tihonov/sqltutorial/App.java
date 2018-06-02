package ru.tihonov.sqltutorial;

import android.app.Application;

import ru.tihonov.sqltutorial.di.components.AppComponent;
import ru.tihonov.sqltutorial.di.components.DaggerAppComponent;
import ru.tihonov.sqltutorial.di.components.DaggerDataComponent;
import ru.tihonov.sqltutorial.di.components.DaggerDataImplComponent;
import ru.tihonov.sqltutorial.di.components.DaggerInteractorComponent;
import ru.tihonov.sqltutorial.di.components.DaggerRepositoryComponent;
import ru.tihonov.sqltutorial.di.components.DataComponent;
import ru.tihonov.sqltutorial.di.components.DataImplComponent;
import ru.tihonov.sqltutorial.di.components.InteractorComponent;
import ru.tihonov.sqltutorial.di.components.RepositoryComponent;
import ru.tihonov.sqltutorial.di.modules.AppModule;

public class App extends Application { //Базовый класс для поддержания состояния глобального приложения
    public static App INSTANCE; //здесь вся работа для инициализации DI(создаем всё зависимости)
    private static InteractorComponent interactorComponent;

    public static InteractorComponent getInteractorComponent() {
        return interactorComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        DataComponent dataComponent = DaggerDataComponent.builder()
                .appComponent(appComponent)
                .build();

        DataImplComponent dataIMPLComponent = DaggerDataImplComponent.builder()
                .dataComponent(dataComponent)
                .build();

        RepositoryComponent repositoryComponent = DaggerRepositoryComponent.builder()
                .dataImplComponent(dataIMPLComponent)
                .build();

        interactorComponent = DaggerInteractorComponent.builder()
                .repositoryComponent(repositoryComponent)
                .build();
    }
}
