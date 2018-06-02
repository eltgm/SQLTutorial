package ru.tihonov.sqltutorial.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.tihonov.sqltutorial.data.cache.LruCache;
import ru.tihonov.sqltutorial.data.database.SqliteDatabase;
import ru.tihonov.sqltutorial.di.scopes.DataIMPLScope;
import ru.tihonov.sqltutorial.repositories.CacheUnitDataStore;
import ru.tihonov.sqltutorial.repositories.DatabaseUnitDataStore;

/**
 * Created by eltgm on 28.03.18
 */

@Module
public class DataImplModule {

    @Provides
    @DataIMPLScope
    public DatabaseUnitDataStore provideDatabaseWeatherDataStore(SqliteDatabase dbHelper) {
        return new DatabaseUnitDataStore(dbHelper);
    }

    @Provides
    @DataIMPLScope
    public CacheUnitDataStore provideCacheWeatherDataStore(LruCache cache) {
        return new CacheUnitDataStore(cache);
    }
}
