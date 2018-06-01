package ru.tihonov.sqltutorial.presentation.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.tihonov.sqltutorial.models.Unit;

public interface UnitView extends MvpView {
    void showUnits(Unit unit);
}

