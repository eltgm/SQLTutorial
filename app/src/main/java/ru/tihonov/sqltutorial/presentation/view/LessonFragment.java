package ru.tihonov.sqltutorial.presentation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.tihonov.sqltutorial.R;
import ru.tihonov.sqltutorial.models.Unit;
import ru.tihonov.sqltutorial.presentation.presenter.LessonPresenter;

public class LessonFragment extends MvpAppCompatFragment implements LessonView {
    @InjectPresenter
    LessonPresenter mPresenter;

    @BindView(R.id.tvWebView)
    WebView webView;

    //метод, для передачи на этот экран значения
    public static LessonFragment getInstance(int lessonId) {
        LessonFragment lessonFragment = new LessonFragment();
        Bundle args = new Bundle();
        args.putInt("lessonId", lessonId);
        lessonFragment.setArguments(args);

        return lessonFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lesson, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View v) {
        ButterKnife.bind(this, v);
        mPresenter.attachView(this);
        if (getArguments() != null)
            mPresenter.getUnit(getArguments().getInt("lessonId"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void showLesson(Unit unit) {
        if (getActivity() != null)
            getActivity().setTitle(unit.getName());
        webView.loadDataWithBaseURL(null, unit.getText(), "text/html", "utf-8", null);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
