package ru.startandroid.develop.mystoremvpnew.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import ru.startandroid.develop.mystoremvpnew.R;
import ru.startandroid.develop.mystoremvpnew.model.Store;

public class StoreAdapter  extends ListAdapter<Store, StoreAdapter.NoteHolder> {

    private OnItemClickListener listener;

    public StoreAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Store> DIFF_CALLBACK = new DiffUtil.ItemCallback<Store>() {
        @Override
        public boolean areItemsTheSame(@NonNull Store oldItem, @NonNull Store newItem) {
            return oldItem.getId() == newItem.getId();
        }


        @Override
        public boolean areContentsTheSame(@NonNull Store oldItem, @NonNull Store newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDescription().equals(newItem.getDescription()) &&
                    oldItem.getQuantity() == newItem.getQuantity();
        }
    };

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_item, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Store currentItem = getItem(position);
        holder.textView_title.setText(currentItem.getTitle());
        holder.textView_description.setText(currentItem.getDescription());
        holder.textView_quantity.setText(String.valueOf(currentItem.getQuantity()));
        holder.textView_price.setText(String.valueOf(currentItem.getPrice()));
        Glide.with(holder.imageView_productImage.getContext())
                .load(currentItem.getImage())
                .into(holder.imageView_productImage);
    }

    public Store getNoteAt(int position) {
        return getItem(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textView_title;
        private TextView textView_description;
        private TextView textView_quantity;
        private TextView textView_price;
        private ImageView imageView_productImage;


        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            textView_title = itemView.findViewById(R.id.text_view_title);
            textView_description = itemView.findViewById(R.id.text_view_description);
            textView_quantity = itemView.findViewById(R.id.text_view_quantity);
            textView_price = itemView.findViewById(R.id.text_view_price);
            imageView_productImage = itemView.findViewById(R.id.image_view_product);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }


    }

    public interface OnItemClickListener {
        void onItemClick(Store store);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


}
