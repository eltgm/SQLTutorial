package ru.tihonov.sqltutorial.di.components;

import dagger.Component;
import ru.tihonov.sqltutorial.di.modules.RepositoryModule;
import ru.tihonov.sqltutorial.di.scopes.RepositoryScope;
import ru.tihonov.sqltutorial.repositories.UnitsRepository;

/**
 * Created by eltgm on 28.03.18
 */

@Component(dependencies = {DataImplComponent.class}, modules = {RepositoryModule.class})
@RepositoryScope
public interface RepositoryComponent {
    UnitsRepository provideUnitsRepository();
}
