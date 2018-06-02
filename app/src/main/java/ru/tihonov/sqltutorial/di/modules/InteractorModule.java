package ru.tihonov.sqltutorial.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.tihonov.sqltutorial.di.scopes.InteractorScope;
import ru.tihonov.sqltutorial.domain.UnitInteractor;
import ru.tihonov.sqltutorial.repositories.UnitsRepository;

/**
 * Created by eltgm on 28.03.18
 */

@Module
public class InteractorModule {

    @Provides
    @InteractorScope
    public UnitInteractor provideMainInteractor(UnitsRepository repository) {
        return new UnitInteractor(repository);
    }
}
