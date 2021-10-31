package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {
    private List<Model> lista;

    public PostAdapter(List<Model> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Model getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_post, parent, false);
        ImageView i_user = itemView.findViewById(R.id.picImg);
        TextView t_user = itemView.findViewById(R.id.userText);
        TextView t_desc = itemView.findViewById(R.id.descriere);
        ImageView i_post = itemView.findViewById(R.id.postImg);
        Model post = lista.get(position);
        i_user.setImageResource(post.getPicImg());
        t_user.setText(post.getUserName());
        t_desc.setText(post.getDescriere());
        i_post.setImageResource(post.getPostImg());
        return itemView;
    }

    public void updateList(List<Model> lst) {
        this.lista.clear();
        this.lista.addAll(lst);
        notifyDataSetChanged();
    }
}
