package ru.tihonov.sqltutorial.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.tihonov.sqltutorial.R;
import ru.tihonov.sqltutorial.models.Unit;

public class UnitsAdapter extends RecyclerView.Adapter<UnitsAdapter.ViewHolder> {
    private final ItemClicked callback;
    private final List<Unit> units = new ArrayList<>();


    public UnitsAdapter(ItemClicked callback) {
        this.callback = callback;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_unit, parent, false);

        final ViewHolder h = new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = h.getAdapterPosition();
                callback.onItemClick(pos);
            }
        });

        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Unit unit = units.get(position);
        holder.setTvUnitName(String.format(Locale.ROOT, "%d. %s", unit.getId(), unit.getName()));
    }

    @Override
    public int getItemCount() {
        return units.size();
    }

    public void add(Unit unit) {
        this.units.add(unit);
        notifyDataSetChanged();
    }

    public interface ItemClicked {
        void onItemClick(int unitId);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvUnitName)
        TextView tvUnitName;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setTvUnitName(String unitName) {
            this.tvUnitName.setText(unitName);
        }
    }
}
