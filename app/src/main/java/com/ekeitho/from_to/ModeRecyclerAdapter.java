package com.ekeitho.from_to;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ekeitho.from_to.databinding.ItemViewBinding;

public class ModeRecyclerAdapter extends RecyclerView.Adapter<ModeRecyclerAdapter.ItemViewHolder> {

    private final static int TOP = 0;
    private final static int MIDDLE = 1;
    private final static int BOTTOM = 2;
    private final static int SIZE = 4;
    private ItemViewBinding binding;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = ItemViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TOP:
                holder.addRectangleTo("bottom");
                holder.binding.textView.setText("San Francisco");
                return;
            case MIDDLE:
                holder.addRectangleTo("stretch");
                return;
            case BOTTOM:
                holder.addRectangleTo("top");
                holder.binding.textView.setText("San Jose");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TOP;
        }
        if (position == SIZE - 1) {
            return BOTTOM;
        }
        return MIDDLE;
    }

    @Override
    public int getItemCount() {
        return SIZE;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ItemViewBinding binding;
        public ItemViewHolder(ItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void addRectangleTo(String mode) {
            binding.setVariable(BR.mode, mode);
        }
    }
}
