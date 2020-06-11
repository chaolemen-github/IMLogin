package com.example.imlogin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imlogin.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    Context context;
    ArrayList<String> list;

    public ContactsAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_contacts_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.containerName.setText(list.get(i));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListenerContacks!=null){
                    onClickListenerContacks.onClick(list.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.container_img)
        ImageView containerImg;
        @BindView(R.id.container_name)
        TextView containerName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    OnClickListenerContacks onClickListenerContacks;

    public void setOnClickListenerContacks(OnClickListenerContacks onClickListenerContacks) {
        this.onClickListenerContacks = onClickListenerContacks;
    }

    public interface OnClickListenerContacks {
        void onClick(String name);
    }
}
