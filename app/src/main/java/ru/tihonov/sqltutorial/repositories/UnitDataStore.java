package ru.tihonov.sqltutorial.repositories;

import io.reactivex.Observable;
import ru.tihonov.sqltutorial.models.Unit;

interface UnitDataStore {
    //абстракция хранилища данных, позволяет создавать различные реализации хранилища, без изменения в работе репозитория
    Observable<Unit> getUnit(int unitId);

    Observable<Unit> getAllUnits();

    void put(Unit unit);

    boolean isEmpty();
}
