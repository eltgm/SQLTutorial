package ru.tihonov.sqltutorial.di.components;

import android.content.Context;

import dagger.Component;
import ru.tihonov.sqltutorial.di.modules.AppModule;

@Component(modules = {AppModule.class})
public interface AppComponent {
    Context provideContext();
}
