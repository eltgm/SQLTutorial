package ru.tihonov.sqltutorial.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.observers.DisposableObserver;
import ru.tihonov.sqltutorial.domain.UnitInteractor;
import ru.tihonov.sqltutorial.models.Unit;
import ru.tihonov.sqltutorial.repositories.UnitsRepository;

public class UnitInteractorTest {
    @Mock
    UnitsRepository repository;
    @Mock
    DisposableObserver<Unit> observer;
    UnitInteractor interactor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        interactor = new UnitInteractor(repository);
    }

    @Test
    public void verifyGetUnits() {
        interactor.getUnits(observer);

        Mockito.verify(repository).getUnits();
    }
}
