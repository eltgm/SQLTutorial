package ru.tihonov.sqltutorial.presentation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.tihonov.sqltutorial.R;
import ru.tihonov.sqltutorial.models.Unit;
import ru.tihonov.sqltutorial.presentation.adapter.UnitsAdapter;
import ru.tihonov.sqltutorial.presentation.presenter.UnitPresenter;

public class UnitsFragment extends MvpAppCompatFragment implements UnitView {

    @BindView(R.id.rvUnits)
    RecyclerView rvUnit;

    @InjectPresenter
    UnitPresenter mPresenter;

    private UnitsAdapter unitsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

    }

    private void initViews(View view){
        ButterKnife.bind(this, view);

        if (getActivity() != null)
            getActivity().setTitle("Home");

        rvUnit.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        unitsAdapter = new UnitsAdapter(new UnitsAdapter.ItemClicked() {
            @Override
            public void onItemClick(String unitName) {

            }
        });

        rvUnit.setAdapter(unitsAdapter);
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void showUnits(Unit unit) {
        unitsAdapter.add(unit);
    }
}
