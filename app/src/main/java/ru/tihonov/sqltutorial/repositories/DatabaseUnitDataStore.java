package ru.tihonov.sqltutorial.repositories;

import io.reactivex.Observable;
import ru.tihonov.sqltutorial.data.database.Database;
import ru.tihonov.sqltutorial.models.Unit;

public class DatabaseUnitDataStore implements UnitDataStore {
    //реализация хранилища в виде базы данных
    private final Database database;

    public DatabaseUnitDataStore(Database database) {
        this.database = database;
    }

    @Override
    public Observable<Unit> getUnit(int unitId) {
        throw new UnsupportedOperationException("Операция поддерживается только кэшом ");
    }

    @Override
    public Observable<Unit> getAllUnits() {
        return database.getUnits();
    }

    @Override
    public void put(Unit unit) {
        throw new UnsupportedOperationException("Операция поддерживается только кэшом ");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Операция поддерживается только кэшом ");
    }
}
