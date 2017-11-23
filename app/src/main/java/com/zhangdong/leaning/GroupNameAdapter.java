package com.zhangdong.leaning;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * use to
 * <p>
 * Created by zhangdong on 2017/8/14.
 *
 * @version 1.0
 */
public class GroupNameAdapter extends RecyclerView.Adapter<GroupNameAdapter.NameHolder> {

    private ItemClickListener listener;

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public NameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new NameHolder(view);
    }

    @Override
    public void onBindViewHolder(NameHolder holder, final int position) {
        holder.groupName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class NameHolder extends RecyclerView.ViewHolder {

        private final TextView groupName;

        public NameHolder(View itemView) {
            super(itemView);
            groupName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    public interface ItemClickListener {
        //item click
        void onItemClick(int position);
    }
}
