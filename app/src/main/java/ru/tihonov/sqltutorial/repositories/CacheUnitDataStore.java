package ru.tihonov.sqltutorial.repositories;

import io.reactivex.Observable;
import ru.tihonov.sqltutorial.data.cache.Cache;
import ru.tihonov.sqltutorial.models.Unit;

public class CacheUnitDataStore implements UnitDataStore {
    //реализация хранилища в виде кэша
    private final Cache cache;

    public CacheUnitDataStore(Cache cache) {
        this.cache = cache;
    }

    @Override
    public Observable<Unit> getUnit(int unitId) {
        return cache.getUnit(unitId);
    }

    @Override
    public Observable<Unit> getAllUnits() {
        return cache.getUnits();
    }

    @Override
    public void put(Unit unit) {
        cache.put(unit);
    }

    @Override
    public boolean isEmpty() {
        return cache.isEmpty();
    }
}
