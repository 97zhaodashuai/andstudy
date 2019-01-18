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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopicBaseActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    protected List<String> topics = new ArrayList<String>();
    protected List<Class> topicCls = new ArrayList<>();
    public  boolean init = false;
    private String mTopic = "";

    protected  boolean initData(){
        return true;
    }

    protected  void onItemClick(int postion){
        Intent it = new Intent(TopicBaseActivity.this, topicCls.get(postion));
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init = !init && initData();

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
            return new TopicViewHolder(headerView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final  int position) {
            TopicViewHolder topicHolder =(TopicViewHolder)holder;
            topicHolder.tv_topic.setText(topics.get(position));
            topicHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return topics.size();
        }
    }
}
