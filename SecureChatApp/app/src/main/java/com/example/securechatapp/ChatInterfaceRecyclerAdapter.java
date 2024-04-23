package com.example.securechatapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


// ChatInterfaceRecyclerAdapter.java

public class ChatInterfaceRecyclerAdapter extends RecyclerView.Adapter<ChatInterfaceRecyclerAdapter.ViewHolder> {
    private List<UserObject> FilteredDataList;

    public interface SelectListener {
        void onClickListener(int position);
    }

    public interface SearchListener {
        void onSelect(int position);
    }

    private SelectListener mSelectListener;

    private SearchListener searchListener;
    private List<UserObject> contacts;
    //private List<Test_data> filteredContacts;

    public ChatInterfaceRecyclerAdapter(List<UserObject> contacts, SearchListener searchListener, SelectListener selectListener) {

        this.contacts = contacts;
        // this.filteredContacts = contacts;
        this.searchListener = searchListener;
        this.mSelectListener = selectListener;
    }

    public ChatInterfaceRecyclerAdapter(ArrayList<UserObject> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.Name.setText(contacts.get(position).getUsername());
        holder.user_name.setText(contacts.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView Name;
        private TextView user_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            user_name = itemView.findViewById(R.id.user_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mSelectListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mSelectListener.onClickListener(position);
                }
            }
        }
    }

    //filter method
    public void filter1(ArrayList<UserObject> filteredContacts) {
        contacts = filteredContacts;
        notifyDataSetChanged();
    }
}



