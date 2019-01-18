package com.zds.andstudy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zds.andstudy.TopicBaseActivity;
import com.zds.andstudy.UI.anim.AnimActivity;
import com.zds.andstudy.UI.layout.LayoutActivity;
import com.zds.andstudy.UI.resource.ResourceActivity;
import com.zds.andstudy.UI.viewgroup.ViewGroupActivity;
import com.zds.andstudy.UI.widget.WidgetActivity;

import java.util.ArrayList;
import java.util.List;

public class UIActivity extends TopicBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected  boolean initData(){
        topics.add("Layout");
        topicCls.add(LayoutActivity.class);
        topics.add("Widget");
        topicCls.add(WidgetActivity.class);
        topics.add("ViewGroup");
        topicCls.add(ViewGroupActivity.class);
        topics.add("动画");
        topicCls.add(AnimActivity.class);
        topics.add("Resource");
        topicCls.add(ResourceActivity.class);
        return true;
    }

}
