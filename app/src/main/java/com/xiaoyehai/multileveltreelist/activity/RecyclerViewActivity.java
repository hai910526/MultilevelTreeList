package com.xiaoyehai.multileveltreelist.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xiaoyehai.multileveltreelist.R;
import com.xiaoyehai.multileveltreelist.adapter.ListViewAdapter;
import com.xiaoyehai.multileveltreelist.adapter.RecyclerViewAdapter;
import com.xiaoyehai.multileveltreelist.treelist.Node;
import com.xiaoyehai.multileveltreelist.bean.NodeData;
import com.xiaoyehai.multileveltreelist.treelist.OnTreeNodeCheckedChangeListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<Node> dataList = new ArrayList<>();

    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        initData();

        //第一个参数  ListView
        //第二个参数  上下文
        //第三个参数  数据集
        //第四个参数  默认展开层级数 0为不展开
        //第五个参数  展开的图标
        //第六个参数  闭合的图标
        mAdapter = new RecyclerViewAdapter(mRecyclerView, this, dataList,
                0, R.mipmap.bt_arrow_up_gray, R.mipmap.bt_arrow_down_gray);

        mRecyclerView.setAdapter(mAdapter);

        //获取所有节点
        final List<Node> allNodes = mAdapter.getAllNodes();
        for (Node allNode : allNodes) {
            //Log.e("xyh", "onCreate: " + allNode.getName());
        }

        //选中状态监听
        mAdapter.setCheckedChangeListener(new OnTreeNodeCheckedChangeListener() {
            @Override
            public void onCheckChange(Node node, int position, boolean isChecked) {
                //获取所有选中节点
                List<Node> selectedNode = mAdapter.getSelectedNode();
                for (Node n : selectedNode) {
                    Log.e("xyh", "onCheckChange: " + n.getName());
                }
            }
        });
    }

    /**
     * 模拟数据，实际开发中对返回的json数据进行封装
     */
    private void initData() {
        //根节点
        Node<NodeData> node = new Node<>("0", "-1", "根节点1");
        dataList.add(node);
        dataList.add(new Node<>("1", "-1", "根节点2"));
        dataList.add(new Node<>("2", "-1", "根节点3"));

        //根节点1的二级节点
        dataList.add(new Node<>("3", "0", "二级节点"));
        dataList.add(new Node<>("4", "0", "二级节点"));
        dataList.add(new Node<>("5", "0", "二级节点"));

        //根节点2的二级节点
        dataList.add(new Node<>("6", "1", "二级节点"));
        dataList.add(new Node<>("7", "1", "二级节点"));
        dataList.add(new Node<>("8", "1", "二级节点"));

        //根节点3的二级节点
        dataList.add(new Node<>("9", "2", "二级节点"));
        dataList.add(new Node<>("10", "2", "二级节点"));
        dataList.add(new Node<>("11", "2", "二级节点"));

        //三级节点
        dataList.add(new Node<>("12", "3", "三级节点"));
        dataList.add(new Node<>("13", "3", "三级节点"));
        dataList.add(new Node<>("14", "3", "三级节点"));

        dataList.add(new Node<>("15", "4", "三级节点"));
        dataList.add(new Node<>("16", "4", "三级节点"));
        dataList.add(new Node<>("17", "4", "三级节点"));

        dataList.add(new Node<>("18", "5", "三级节点"));
        dataList.add(new Node<>("19", "5", "三级节点"));
        dataList.add(new Node<>("20", "5", "三级节点"));

        //四级节点
        dataList.add(new Node<>("21", "12", "四级节点"));

        //...
        //可以有无线多层级
    }
}
