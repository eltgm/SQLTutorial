package ru.tihonov.sqltutorial.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ru.tihonov.sqltutorial.data.cache.LruCache;
import ru.tihonov.sqltutorial.data.database.SqliteDatabase;
import ru.tihonov.sqltutorial.di.modules.DataModule;
import ru.tihonov.sqltutorial.di.scopes.DataScope;

/**
 * Created by eltgm on 28.03.18
 */


@Component(dependencies = {AppComponent.class}, modules = {DataModule.class})
@Singleton
@DataScope
public interface DataComponent {
    SqliteDatabase provideSqliteDatabase();

    LruCache provideLruCache();

    Context provideContext();
}
