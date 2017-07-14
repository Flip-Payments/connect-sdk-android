package com.flip.connect.presentation.views.edit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kanda on 13/07/2017.
 */

public class EditAdapter extends RecyclerView.Adapter<EditAdapter.ViewHolder> {

    private List<Object> items;

    public EditAdapter(List<Object> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     /*       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            if (viewType == SECTION) {
                return new ViewHolder(layoutInflater.inflate(R.layout.section_layout, parent, false));
            }
            return new ViewHolder(layoutInflater.inflate(R.layout.item_section_layout, parent, false)); */
        return null;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
