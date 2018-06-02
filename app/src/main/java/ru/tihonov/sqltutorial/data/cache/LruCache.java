package ru.tihonov.sqltutorial.data.cache;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import ru.tihonov.sqltutorial.models.Unit;

public class LruCache implements Cache {
    //реализация cache
    private final android.util.LruCache<Integer, Unit> unitCache;

    public LruCache(android.util.LruCache<Integer, Unit> unitCache) {
        this.unitCache = unitCache;
    }

    @Override
    public Observable<Unit> getUnit(int id) {
        Unit u = unitCache.get(id);
        return Observable.just(u);
    }

    @Override
    public boolean isEmpty() {
        return unitCache.size() <= 0;
    }

    @Override
    public Observable<Unit> getUnits() {
        List<Unit> units = new ArrayList<>();
        for (int i = 1; i < unitCache.size(); i++) {
            units.add(unitCache.get(i));
        }
        return Observable.fromIterable(units);
    }

    @Override
    public void put(Unit unit) {
        unitCache.put(unit.getId(), unit);
    }
}
