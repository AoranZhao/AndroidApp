package com.nowansr.adapter;

/**
 * Created by NEW-PC on 2/6/2016.
 */

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nowansr.R;
import com.nowansr.model.Question;

import java.util.ArrayList;
import java.util.List;


public class Recycle_View_Question_ListAdapter extends RecyclerView.Adapter<Recycle_View_Question_ListAdapter.HomeHolder> {
    private static String LOG_TAG = "RecycleAdapter";
    private static MyClickListener myClickListener;
    Activity ac;
    private List<Question> qs = new ArrayList<>();


    public static class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView date, language;
        Button see_response,repost;
        EditText questions;

        public HomeHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            language = (TextView) itemView.findViewById(R.id.language);
            questions= (EditText) itemView.findViewById(R.id.et_question);
            see_response= (Button) itemView.findViewById(R.id.btsee_response);
            repost= (Button) itemView.findViewById(R.id.bt_repost);


            Log.i(LOG_TAG, "Adding Listener");
//            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public Recycle_View_Question_ListAdapter(Activity activity) {

        ac = activity;
    }

    public Recycle_View_Question_ListAdapter(Activity activity, List<Question> qqs) {
        ac = activity;
        qs = qqs;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewquestion_list_item, parent, false);


        HomeHolder homeHolder = new HomeHolder(view);
        return homeHolder;
    }

    public void setData(List<Question> qqs) {
        notifyDataSetChanged();
        this.qs = qqs;
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {

        Question q = qs.get(position);
        Log.i(LOG_TAG, "fill homeholder number " + position);
        if (q != null) {
            holder.date.setText(q.getCreatedAt());
            holder.language.setText(q.getCategory().getDisplayName().getEnUS());
            holder.questions.setText(q.getQuestion());
        } else {
            Log.i(LOG_TAG, "question is null");
        }


    }


    @Override
    public int getItemCount() {
//        return mDataset.size();
//        return size_realm;
//        return 12;
        return qs.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}