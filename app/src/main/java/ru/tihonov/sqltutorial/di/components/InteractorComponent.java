package ru.tihonov.sqltutorial.di.components;

import dagger.Component;
import ru.tihonov.sqltutorial.di.modules.InteractorModule;
import ru.tihonov.sqltutorial.di.scopes.InteractorScope;
import ru.tihonov.sqltutorial.presentation.presenter.LessonPresenter;
import ru.tihonov.sqltutorial.presentation.presenter.UnitPresenter;

/**
 * Created by eltgm on 28.03.18
 */

@Component(dependencies = {RepositoryComponent.class}, modules = {InteractorModule.class})
@InteractorScope
public interface InteractorComponent {
    void inject(UnitPresenter presenter);

    void inject(LessonPresenter presenter);
}
