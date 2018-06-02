package ru.tihonov.sqltutorial.domain;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ru.tihonov.sqltutorial.models.Unit;
import ru.tihonov.sqltutorial.repositories.UnitsRepository;

public class UnitInteractor {
    //класс, отделяющий основную логику(бизнес-логику) приложения, от работы с отображением и данными
    //нужно для удобства работы с логикой приложения, чтоб не думать об реализации обращения к данным или реализации экрана
    private final CompositeDisposable disposables;
    private final UnitsRepository unitsRepository;

    public UnitInteractor(UnitsRepository unitsRepository) {
        this.disposables = new CompositeDisposable();
        this.unitsRepository = unitsRepository;
    }

    public void dispose() {
        if (!disposables.isDisposed())
            disposables.clear();
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    public void getUnit(DisposableObserver<Unit> observer, int id) {
        addDisposable(unitsRepository.getUnit(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer));
    }

    public void getUnits(DisposableObserver<Unit> observer) {
        addDisposable(unitsRepository.getUnits()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer));
    }
}
