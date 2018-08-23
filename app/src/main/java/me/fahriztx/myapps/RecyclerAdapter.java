package me.fahriztx.myapps;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<ItemModel> itemModels;
    private OnCardClickListener onCardClickListener;

    public RecyclerAdapter(List<ItemModel> itemModels, OnCardClickListener onCardClickListener) {
        this.itemModels = itemModels;
        this.onCardClickListener = onCardClickListener;
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
        holder.bind(itemModels.get(position), onCardClickListener);
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;
        private CardView card;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(final ItemModel model, final OnCardClickListener cardClickListener) {

            image = itemView.findViewById(R.id.list_image);
            title = itemView.findViewById(R.id.list_title);
            card = itemView.findViewById(R.id.cardView);

            image.setImageResource(model.getImage());
            title.setText(model.getTitle());

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cardClickListener.onClickCard(model);
                }
            });
        }
    }

    interface OnCardClickListener {

        void onClickCard(ItemModel model);

    }
}
