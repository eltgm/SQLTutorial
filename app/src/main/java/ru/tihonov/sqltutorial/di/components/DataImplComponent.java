package ru.tihonov.sqltutorial.di.components;

import android.content.Context;

import dagger.Component;
import ru.tihonov.sqltutorial.di.modules.DataImplModule;
import ru.tihonov.sqltutorial.di.scopes.DataIMPLScope;
import ru.tihonov.sqltutorial.repositories.CacheUnitDataStore;
import ru.tihonov.sqltutorial.repositories.DatabaseUnitDataStore;

/**
 * Created by eltgm on 28.03.18
 */

@Component(dependencies = {DataComponent.class}, modules = {DataImplModule.class})
@DataIMPLScope
public interface DataImplComponent {
    CacheUnitDataStore provideCacheUnitDataStore();

    DatabaseUnitDataStore provideDatabaseUnitDataStore();

    Context provideContext();
}
