package com.hackathon.contentcreatorstudio.contentstudio.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackathon.contentcreatorstudio.R;
import com.hackathon.contentcreatorstudio.contentstudio.models.ContentStudioThemeCategory;

public class ItemContentThemeAdapter extends RecyclerView.Adapter<ItemContentThemeAdapter.ViewHolder> {

    private List<ContentStudioThemeCategory> list = new ArrayList<>();

    private Context context;

    public ItemContentThemeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_content_theme, parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        ContentStudioThemeCategory item = list.get(position);
        Glide.with(holder.itemContentIv.getContext()).load(item.imageUrl).into(holder.itemContentIv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateData(List<ContentStudioThemeCategory> newDataList) {
        if (newDataList == null || newDataList.isEmpty()) return;
        list.clear();
        list.addAll(newDataList);
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemContentIv;
        private TextView itemContentName;

        public ViewHolder(View view) {
            super(view);
            itemContentIv = (ImageView) view.findViewById(R.id.item_content_iv);
            itemContentName = (TextView) view.findViewById(R.id.item_content_name);
        }
    }
}
