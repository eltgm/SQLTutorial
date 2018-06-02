package ru.tihonov.sqltutorial.presentation.view;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.tihonov.sqltutorial.models.Unit;

@StateStrategyType(SingleStateStrategy.class)
//смотри unitView, поведение экрана Lesson
public interface LessonView extends MvpView {
    void showLesson(Unit unit);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError(String error);
}
