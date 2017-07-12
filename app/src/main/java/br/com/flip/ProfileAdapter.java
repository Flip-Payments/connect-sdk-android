package br.com.flip;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flip.connect.domain.model.user.EmailsItem;
import com.flip.connect.domain.model.user.PhonesItem;
import com.flip.connect.domain.model.user.PublicProfile;
import com.flip.connect.domain.model.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kanda on 12/07/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private User user;
    private List<Object> items;
    private int SECTION = 0;
    private int ITEM = 1;

    public ProfileAdapter(User user) {
        this.user = user;
        items = new ArrayList<>();
        items.add("Nome");
        items.add(user.getPublicProfile());
        items.add("Phones");
        items.addAll(user.getPhones());
        items.add("Emails");
        items.addAll(user.getEmails());
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof String) {
            return SECTION;
        }
        return ITEM;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == SECTION) {
            return new ViewHolder(layoutInflater.inflate(R.layout.section_layout, parent, false));
        }
        return new ViewHolder(layoutInflater.inflate(R.layout.item_section_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object object = items.get(position);
        if (object instanceof String) {
            ((TextView) holder.view.findViewById(R.id.section)).setText((String) object);
        } else {
            TextView textView = ((TextView) holder.view.findViewById(R.id.item));
            if (object instanceof PhonesItem) {
                textView.setText(((PhonesItem) object).getFullNumber());
            } else if(object instanceof EmailsItem) {
                textView.setText(((EmailsItem) object).getAddress());
            }else {
                textView.setText(((PublicProfile) object).getName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
