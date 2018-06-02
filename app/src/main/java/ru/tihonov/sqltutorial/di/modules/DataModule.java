package ru.tihonov.sqltutorial.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.tihonov.sqltutorial.data.cache.LruCache;
import ru.tihonov.sqltutorial.data.database.SqliteDatabase;
import ru.tihonov.sqltutorial.models.Unit;

/**
 * Created by eltgm on 28.03.18
 */

@Module
public class DataModule {

    @Singleton
    @Provides
    public LruCache provideCache() {
        return new LruCache(new android.util.LruCache<Integer, Unit>(40));
    }

    @Singleton
    @Provides
    public SqliteDatabase provideDbHelper(Context context) {
        return new SqliteDatabase(context);
    }
}
