package ru.tihonov.sqltutorial.data.cache;


import io.reactivex.Observable;
import ru.tihonov.sqltutorial.models.Unit;

public interface Cache {
    //смотри Database
    Observable<Unit> getUnit(int id);

    boolean isEmpty();

    Observable<Unit> getUnits();

    void put(Unit unit);
}
