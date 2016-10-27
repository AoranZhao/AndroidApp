package com.nowansr.adapter;

/**
 * Created by NEW-PC on 2/6/2016.
 */

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nowansr.Constants;
import com.nowansr.R;
import com.nowansr.model.Search;
import com.nowansr.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class Recycle_Search_ListAdapter extends RecyclerView.Adapter<Recycle_Search_ListAdapter.HomeHolder> implements View.OnClickListener {
    private static String LOG_TAG = "RecycleAdapter";
    private static MyClickListener myClickListener;
    Activity ac;

    List<User> users = new ArrayList<User>();

    @Override
    public void onClick(View view) {
        if (myClickListener != null) {
            myClickListener.onItemClick((String)view.getTag(), view);
        }
    }

    public static class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private de.hdodenhof.circleimageview.CircleImageView imageviewuserimagesession;
        private TextView namesearch;
        private TextView ratingvalue;
        private TextView onlinestatus;


        public HomeHolder(View itemView) {
            super(itemView);

            this.onlinestatus = (TextView) itemView.findViewById(R.id.online_status);
            this.ratingvalue = (TextView) itemView.findViewById(R.id.rating_value);
            this.namesearch = (TextView) itemView.findViewById(R.id.name_search);
            this.imageviewuserimagesession = (CircleImageView) itemView.findViewById(R.id.imageview_userimage_session);


            Log.i(LOG_TAG, "Adding Listener");
           // itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public Recycle_Search_ListAdapter(List<User> listTotalQuestion, Activity activity) {

        this.users = listTotalQuestion;
        ac = activity;
    }

    public Recycle_Search_ListAdapter(Activity activity) {
        ac = activity;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_list_item, parent, false);


        HomeHolder homeHolder = new HomeHolder(view);
        view.setOnClickListener(this);
        return homeHolder;
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {

        User u = users.get(position);


        holder.namesearch.setText(u.getUsername());
        double rating = (u.getRatingSummary() == null || u.getRatingSummary().size() == 0)? 0 : (u.getRatingSummary().get(0).getScore() + u.getRatingSummary().get(1).getScore()) / 2;
        holder.ratingvalue.setText(rating + "");
        holder.onlinestatus.setText(u.getOnline().toString());

        Picasso.with(ac)
                .load(Constants.PROFILE_IMAGE_STORE + u.getAvatar())
                .into(holder.imageviewuserimagesession);
//        holder.question.setText(totalQuestionModel.getQuestion());
        holder.itemView.setTag(u.getUsername());

    }


    @Override
    public int getItemCount() {

        return users.size();
    }

    public void setData(List<User> users) {
        notifyDataSetChanged();
        this.users = users;
    }

    public interface MyClickListener {
        public void onItemClick(String name, View v);
    }
}