package com.burhanuday.todolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by burhanuday on 19-09-2019.
 */
public class ListHelper extends
        RecyclerView.Adapter<ListHelper.Holder> {

    ArrayList<String> itemList;

    public ListHelper(ArrayList<String> itemList){
        this.itemList = itemList;
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView text;
        public Holder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.list_item_text);
        }
    }

    @NonNull
    @Override
    public ListHelper.Holder
    onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View row;
        row = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder
            (@NonNull ListHelper.Holder holder, int i) {

        String item;
        item = itemList.get(i);

        holder.text.setText(item);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
