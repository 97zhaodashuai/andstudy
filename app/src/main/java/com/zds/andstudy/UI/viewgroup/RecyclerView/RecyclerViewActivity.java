package com.zds.andstudy.UI.viewgroup.RecyclerView;

import android.os.Bundle;

import com.zds.andstudy.TopicBaseActivity;
import com.zds.andstudy.UI.layout.LayoutActivity;

public class RecyclerViewActivity extends TopicBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected  boolean initData(){
        topics.add("LinearLayoutManager");
        topicCls.add(LinearLayoutManagerActivity.class);
        return true;
    }

}
