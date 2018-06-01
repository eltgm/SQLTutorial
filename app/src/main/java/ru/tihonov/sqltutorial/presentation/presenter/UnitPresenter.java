package ru.tihonov.sqltutorial.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;

import ru.tihonov.sqltutorial.models.Unit;
import ru.tihonov.sqltutorial.presentation.view.UnitView;

@InjectViewState
public class UnitPresenter extends BasePresenter<UnitView> {



    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        Unit u1 = new Unit();
        u1.setId(1);
        u1.setName("MySQL - Home");
        u1.setText("<html><body><h1>test1</h1></body></html>");

        Unit u2 = new Unit();
        u2.setId(2);
        u2.setName("MySQL - Introduction");
        u2.setText("<html><body><h1>test2</h1></body></html>");

        getViewState().showUnits(u1);
        getViewState().showUnits(u2);
    }

    @Override
    public void disconnect() {

    }
}
