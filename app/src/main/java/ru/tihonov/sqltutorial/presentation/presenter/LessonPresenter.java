package ru.tihonov.sqltutorial.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import ru.tihonov.sqltutorial.App;
import ru.tihonov.sqltutorial.domain.UnitInteractor;
import ru.tihonov.sqltutorial.models.Unit;
import ru.tihonov.sqltutorial.presentation.view.LessonView;

@InjectViewState
public class LessonPresenter extends BasePresenter<LessonView> {
    @Inject
    UnitInteractor unitInteractor;

    public LessonPresenter() {
        App.getInteractorComponent().inject(this);
    }

    public void getUnit(int id) {
        unitInteractor.getUnit(new LessonObserver(), id);
    }

    @Override
    public void disconnect() {
        unitInteractor.dispose();
    }

    class LessonObserver extends DisposableObserver<Unit> {
        @Override
        public void onNext(Unit unit) {
            getViewState().showLesson(unit);
        }

        @Override
        public void onError(Throwable e) {
            getViewState().showError(e.toString());
        }

        @Override
        public void onComplete() {

        }
    }
}
