package com.nowansr.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nowansr.Constants;
import com.nowansr.model.Skill;
import com.nowansr.model.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import com.nowansr.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Aaron on 4/21/16.
 */
public class Recycle_Expert_List_Adapter extends RecyclerView.Adapter<Recycle_Expert_List_Adapter.HomeHolder> implements View.OnClickListener {

    private static String LOG_TAG = "Recycle_Expert_List_Adapter";
    private Activity ac;
    private static MyClickListener myClickListener;
    private List<User> expertsList = new ArrayList<>();

    public Recycle_Expert_List_Adapter(Activity ac) {
        this.ac = ac;
    }

    public Recycle_Expert_List_Adapter(Activity ac, List<User> expertsList) {
        this.ac = ac;
        this.expertsList = expertsList;
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public void setData(List<User> users) {
        notifyDataSetChanged();
        this.expertsList = users;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expert_list_item, parent, false);

        HomeHolder homeHolder = new HomeHolder(view);
        view.setOnClickListener(this);
        return homeHolder;
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {
        User u = expertsList.get(position);

        holder.expertName.setText(u.getUsername());
        holder.expertOnline.setText(u.getOnline().toString());
        holder.expertRating.setText((u.getRatingSummary().get(0).getScore() + u.getRatingSummary().get(1).getScore()) / 2 + "");
        List<Skill> skills = u.getSkills();
        String skillStr = "";
        for (int i = 0;i < skills.size(); i++) {
            skillStr += skills.get(i).getCategory().getDisplayName().getEnUS() + ", ";
        }
        holder.expertSkill.setText(skillStr);

        Picasso.with(ac).load(Constants.PROFILE_IMAGE_STORE + u.getAvatar()).into(holder.expertImage);

        holder.itemView.setTag(u.getUsername());
    }

    @Override
    public int getItemCount() {
        return expertsList.size();
    }

    @Override
    public void onClick(View view) {
        if (myClickListener != null) {
            myClickListener.onItemClick((String)view.getTag(), view);
        }
    }

    public static class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CircleImageView expertImage;
        private TextView expertName, expertRating, expertOnline, expertSkill;

        public HomeHolder(View itemView) {
            super(itemView);

            expertImage = (CircleImageView) itemView.findViewById(R.id.imageview_expertimage);
            expertName = (TextView) itemView.findViewById(R.id.expert_name);
            expertRating = (TextView) itemView.findViewById(R.id.expert_rating);
            expertOnline = (TextView) itemView.findViewById(R.id.expert_online);
            expertSkill = (TextView) itemView.findViewById(R.id.expert_skills);

            Log.i(LOG_TAG, "create homeholder");
        }

        @Override
        public void onClick(View view) {
        }
    }

    public interface MyClickListener {
        public void onItemClick(String name, View v);
    }
}
