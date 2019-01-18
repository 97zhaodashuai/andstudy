package com.zds.andstudy.UI.viewgroup;

import android.os.Bundle;

import com.zds.andstudy.TopicBaseActivity;
import com.zds.andstudy.UI.anim.AnimActivity;
import com.zds.andstudy.UI.layout.LayoutActivity;
import com.zds.andstudy.UI.resource.ResourceActivity;
import com.zds.andstudy.UI.viewgroup.RecyclerView.RecyclerViewActivity;
import com.zds.andstudy.UI.widget.WidgetActivity;

public class ViewGroupActivity extends TopicBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected  boolean initData(){
        topics.add("RecyclerView");
        topicCls.add(RecyclerViewActivity.class);
       
        return true;
    }

}
