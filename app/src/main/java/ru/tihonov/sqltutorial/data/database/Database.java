package ru.tihonov.sqltutorial.data.database;

import io.reactivex.Observable;
import ru.tihonov.sqltutorial.models.Unit;

public interface Database {
    //абстракция базы данных для того, чтоб без особых изменений в хранилище использовать разные реализации баз данных
    Observable<Unit> getUnits();
}
