package com.zds.andstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zds.andstudy.UI.UIActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    public ArrayList<String> topics = new ArrayList<String>();
    public List<Class> topicCls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topics.add("UI");
        topicCls.add(UIActivity.class);
        topics.add("架构");
        topics.add("工程化");
        topics.add("性能优化");
        topics.add("Java");
        topics.add("多线程");


        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerAdapter());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


    }


    public class TopicViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_topic;
        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_topic = (TextView)itemView.findViewById(R.id.title);
        }
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View headerView= LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_item,parent,false);
            RecyclerView.ViewHolder vh =  new TopicViewHolder(headerView);

            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            TopicViewHolder topicHolder =(TopicViewHolder)holder;
            topicHolder.tv_topic.setText(topics.get(position));
            topicHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent it = new Intent(MainActivity.this, topicCls.get(position));
                    startActivity(it);
                }
            });
        }

        @Override
        public int getItemCount() {
            return topics.size();
        }
    }


}
