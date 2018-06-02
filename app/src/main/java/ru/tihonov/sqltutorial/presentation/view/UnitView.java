package ru.tihonov.sqltutorial.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.tihonov.sqltutorial.models.Unit;

@StateStrategyType(OneExecutionStateStrategy.class)
//интерфейс, содержащий поведение экрана, необходимо для взаимодействия с презентером
//также отделяет поведение экрана от его реализации, опредеяет поведение экрана
public interface UnitView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showUnit(Unit unit);

    void showError(String error);
}

