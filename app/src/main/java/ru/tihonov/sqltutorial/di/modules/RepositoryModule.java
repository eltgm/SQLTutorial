package ru.tihonov.sqltutorial.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.tihonov.sqltutorial.di.scopes.RepositoryScope;
import ru.tihonov.sqltutorial.repositories.CacheUnitDataStore;
import ru.tihonov.sqltutorial.repositories.DatabaseUnitDataStore;
import ru.tihonov.sqltutorial.repositories.UnitsRepository;

/**
 * Created by eltgm on 28.03.18
 */

@Module
public class RepositoryModule {

    @Provides
    @RepositoryScope
    public UnitsRepository provideWeatherRepository(CacheUnitDataStore cacheUnitDataStore
            , DatabaseUnitDataStore databaseUnitDataStore) {
        return new UnitsRepository(databaseUnitDataStore, cacheUnitDataStore);
    }
}
