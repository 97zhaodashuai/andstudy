package com.zds.andstudy.UI.viewgroup.RecyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zds.andstudy.R;
import com.zds.andstudy.TopicBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class LinearLayoutManagerActivity extends AppCompatActivity {


    private RecyclerView mVR;
    private RecyclerView mHR;

    private List<String> mData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_manager);

        mData.add("1");
        mData.add("2");
        mData.add("3");
        mData.add("4");
        mData.add("5");
        mData.add("6");
        mData.add("7");
        mData.add("8");
        mData.add("9");

        mVR = (RecyclerView)findViewById(R.id.v_recyclerview);
        mHR = (RecyclerView)findViewById(R.id.h_recyclerview);

        LinearLayoutManager  llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mVR.setLayoutManager(llm);
        mVR.setAdapter(new RecyclerAdapter());
        mVR.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        LinearLayoutManager  llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHR.setLayoutManager(llm2);
        mHR.setAdapter(new RecyclerAdapter());
        mHR.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

    }




    public class RViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public RViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.title);
        }
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View headerView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_exam_item,parent,false);
            return new RViewHolder(headerView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final  int position) {
            RViewHolder topicHolder =(RViewHolder)holder;
            topicHolder.tv.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

}
