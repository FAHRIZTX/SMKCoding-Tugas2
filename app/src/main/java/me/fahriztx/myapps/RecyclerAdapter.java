package me.fahriztx.myapps;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<ItemModel> itemModels;
    private OnImageClickListener onImageClickListener;

    public RecyclerAdapter(List<ItemModel> itemModels, OnImageClickListener onImageClickListener) {
        this.itemModels = itemModels;
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(itemModels.get(position), onImageClickListener);
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(final ItemModel model, final OnImageClickListener imageClickListener) {
            image = itemView.findViewById(R.id.list_image);
            title = itemView.findViewById(R.id.list_title);

            image.setImageResource(model.getImage());
            title.setText(model.getTitle());

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageClickListener.onClickImage(model);
                }
            });
        }
    }

    interface OnImageClickListener {

        public void onClickImage(ItemModel model);

    }
}
