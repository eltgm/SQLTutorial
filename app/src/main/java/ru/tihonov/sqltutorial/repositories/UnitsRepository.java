package ru.tihonov.sqltutorial.repositories;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import ru.tihonov.sqltutorial.models.Unit;

public class UnitsRepository {
    //класс, хранящий возможные источники данных для приложения, нужен для удобства работы с различными источниками данных
    private final UnitDataStore databaseUnitDataStore;
    private final UnitDataStore cacheUnitDataStore;

    public UnitsRepository(UnitDataStore databaseUnitDataStore, UnitDataStore cacheUnitDataStore) {
        this.databaseUnitDataStore = databaseUnitDataStore;
        this.cacheUnitDataStore = cacheUnitDataStore;
    }

    public Observable<Unit> getUnits() {
        if (cacheUnitDataStore.isEmpty())
            return databaseUnitDataStore.getAllUnits().doOnNext(new Consumer<Unit>() {
                @Override
                public void accept(Unit unit) {
                    cacheUnitDataStore.put(unit);
                }
            });
        else
            return cacheUnitDataStore.getAllUnits();
    }

    public Observable<Unit> getUnit(int id) {
        return cacheUnitDataStore.getUnit(id);
    }
}
