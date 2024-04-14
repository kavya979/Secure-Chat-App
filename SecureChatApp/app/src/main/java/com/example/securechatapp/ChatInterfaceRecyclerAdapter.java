package com.example.securechatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatInterfaceRecyclerAdapter extends RecyclerView.Adapter<ChatInterfaceRecyclerAdapter.ViewHolder> {

    public interface selectListener{
        void onClickListener(int position);
    }

    private ArrayList<Test_data> contacts = new ArrayList<>();
    private selectListener mlistener;

    public ChatInterfaceRecyclerAdapter(ArrayList<Test_data> contacts, selectListener listener) {
        this.contacts = contacts;
        this.mlistener = listener;

    }

    public ArrayList<Test_data> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Test_data> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Name.setText(contacts.get(position).getNames());
        holder.Name.setText(contacts.get(position).getUnames());
    }

    @Override
    public int getItemCount() {
        return contacts.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView Name;
        private selectListener mListener;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mlistener.onClickListener(position);
                }
            }
        }
    }
}