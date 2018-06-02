package ru.tihonov.sqltutorial.presentation.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

/**
 * Created by eltgm on 25.03.18
 */

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {
    //класс для обощения всех презентеров, с целью переопределения поведения при его уничтожении
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disconnect();
    }

    protected abstract void disconnect();
}
