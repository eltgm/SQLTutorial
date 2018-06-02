package ru.tihonov.sqltutorial.presentation.presenter;

import android.support.v4.app.FragmentManager;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import ru.tihonov.sqltutorial.App;
import ru.tihonov.sqltutorial.R;
import ru.tihonov.sqltutorial.domain.UnitInteractor;
import ru.tihonov.sqltutorial.models.Unit;
import ru.tihonov.sqltutorial.presentation.view.LessonFragment;
import ru.tihonov.sqltutorial.presentation.view.UnitView;

@InjectViewState
public class UnitPresenter extends BasePresenter<UnitView> {

    @Inject
    UnitInteractor unitInteractor;

    public UnitPresenter() {
        App.getInteractorComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getUnits();
    }

    public void moveToLesson(FragmentManager fragmentManager, int unitId) {
        fragmentManager.beginTransaction()
                .add(R.id.flMain, LessonFragment.getInstance(unitId))
                .addToBackStack("lesson")
                .commit();
    }

    private void getUnits() {
        unitInteractor.getUnits(new UnitsObserver());
    }

    @Override
    public void disconnect() {
        unitInteractor.dispose();
    }

    class UnitsObserver extends DisposableObserver<Unit> {

        @Override
        public void onNext(Unit unit) {
            getViewState().showUnit(unit);
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
