package com.xiaoyehai.multileveltreelist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyehai.multileveltreelist.R;
import com.xiaoyehai.multileveltreelist.treelist.Node;
import com.xiaoyehai.multileveltreelist.treelist.OnTreeNodeCheckedChangeListener;
import com.xiaoyehai.multileveltreelist.treelist.TreeRecyclerAdapter;

import java.util.List;

/**
 * Created by xiaoyehai on 2018/7/12 0012.
 */

public class RecyclerViewAdapter extends TreeRecyclerAdapter {

    private OnTreeNodeCheckedChangeListener checkedChangeListener;

    public void setCheckedChangeListener(OnTreeNodeCheckedChangeListener checkedChangeListener) {
        this.checkedChangeListener = checkedChangeListener;
    }

    public RecyclerViewAdapter(RecyclerView recyclerView, Context context, List<Node> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(recyclerView, context, datas, defaultExpandLevel, iconExpand, iconNoExpand);
    }

    public RecyclerViewAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel) {
        super(mTree, context, datas, defaultExpandLevel);
    }

    @Override
    public void onBindViewHolder(final Node node, final RecyclerView.ViewHolder holder, final int position) {

        final ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.tvName.setText(node.getName());

        if (node.getIcon() == -1) {
            viewHolder.ivExpand.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.ivExpand.setVisibility(View.VISIBLE);
            viewHolder.ivExpand.setImageResource(node.getIcon());
        }


        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(node, viewHolder.checkBox.isChecked());

                if (checkedChangeListener != null) {
                    checkedChangeListener.onCheckChange(node, position, viewHolder.checkBox.isChecked());
                }
            }
        });

        if (node.isChecked()) {
            viewHolder.checkBox.setChecked(true);
        } else {
            viewHolder.checkBox.setChecked(false);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mContext, R.layout.item, null));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private TextView tvName;
        private ImageView ivExpand;


        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.cb);
            tvName = itemView.findViewById(R.id.tv_name);
            ivExpand = itemView.findViewById(R.id.iv_expand);
        }
    }
}
