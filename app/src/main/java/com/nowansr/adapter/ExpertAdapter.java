package com.nowansr.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.nowansr.Constants;
import com.nowansr.R;
import com.nowansr.RestAdapterFactory;
import com.nowansr.model.Skill;
import com.nowansr.model.User;
import com.nowansr.model.Users;
import com.nowansr.ui.module.expertprofile.ExpertProfileActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Binds the expert list data from the backend to the UI.
 */
public class ExpertAdapter extends RecyclerView.Adapter<ExpertAdapter.ViewHolder> {


    private static String LOG_TAG = ExpertAdapter.class.getSimpleName();

    private List<User> mAllUsers = new ArrayList<>();
    public List<User> getmAllUsers() { return mAllUsers; }
    public void setmAllUsers(List<User> mAllUsers) {
        notifyDataSetChanged();
        this.mAllUsers = mAllUsers;
    }

//    private List<Skill> mExperts = new ArrayList<>();
//
//    public List<Skill> getmExperts() {
//        return mExperts;
//    }
//
//    public void setmExperts(List<Skill> mExperts) {
//        notifyDataSetChanged();
//        this.mExperts = mExperts;
//    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.layout_expert, parent, false);

        // set star color
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();

        //filled
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        //stars.getDrawable(1).setColorFilter(Color.BLUE, PorterDuff.Mode.);

        //empty
        stars.getDrawable(0).setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        final ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        User user = mAllUsers.get(position);
        viewHolder.expertName.setText(user.getUsername());

        viewHolder.expertSummary.setText(user.getProfileSummary());

        //TODO: needs localisation proper formatting
        viewHolder.skillPrice.setText("$" + user.getSkills().get(0).getPrice() + "/ 5 min");

        Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(50)
                .oval(false)
                .build();

        if(! user.getAvatar().equalsIgnoreCase("default.png")) {
            Picasso.with(viewHolder.expertProfileImage.getContext())
                    .load(Constants.PROFILE_IMAGE_STORE + user.getAvatar())
                    .transform(transformation)
                    .into(viewHolder.expertProfileImage);
        } else {
            Picasso.with(viewHolder.expertProfileImage.getContext())
                    .load(R.mipmap.ic_launcher)
                    .transform(transformation)
                    .into(viewHolder.expertProfileImage);
        }

//        Skill skill = mExperts.get(position);
//        viewHolder.expertName.setText(skill.getUser().getName());
//
//        viewHolder.expertSummary.setText(skill.getUser().getSummary());
//
//        //TODO: needs localisation proper formatting
//        viewHolder.skillPrice.setText("$" + skill.getPrice() + "/ 5 min");
//
//        Transformation transformation = new RoundedTransformationBuilder()
//                .cornerRadiusDp(50)
//                .oval(false)
//                .build();
//
//        if(! skill.getUser().getAvatar().equalsIgnoreCase("default.png")) {
//            Picasso.with(viewHolder.expertProfileImage.getContext())
//                    .load(Constants.PROFILE_IMAGE_STORE + skill.getUser().getAvatar())
//                    .transform(transformation)
//                    .into(viewHolder.expertProfileImage);
//        } else {
//            Picasso.with(viewHolder.expertProfileImage.getContext())
//                    .load(R.mipmap.ic_launcher)
//                    .transform(transformation)
//                    .into(viewHolder.expertProfileImage);
//        }


    }

    @Override
//    public int getItemCount() {
//        return mExperts.size();
//    }
    public int getItemCount() { return mAllUsers.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView expertName;
        public TextView expertSummary;
        public ImageView expertProfileImage;
        public TextView skillPrice;
        public ImageView callExpert;

        public ViewHolder(View view) {
            super(view);
            expertName = (TextView) view.findViewById(R.id.layout_expert_expert_name);
            expertSummary = (TextView) view.findViewById(R.id.layout_expert_expert_summary);
            expertProfileImage = (ImageView) view.findViewById(R.id.fragment_expert_profile_image);
            skillPrice = (TextView) view.findViewById(R.id.layout_expert_skill_price);
            callExpert = (ImageView) view.findViewById(R.id.call_expert_icon);

            /**
             * Visual touch feedback.
             */
            callExpert.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ImageView view = (ImageView) v;
                            view.getDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                            view.invalidate();
                            Log.d(LOG_TAG, "Camera icon clicked on position: " + getAdapterPosition());
                            //TODO: implicit intent call to AppRTC
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL: {
                            ImageView view = (ImageView) v;
                            //clear the overlay
                            view.getDrawable().clearColorFilter();
                            view.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });

            view.setOnClickListener(this);
        }

        /**
         * Open the expert profile view.
         * @param v The view associated with the click.
         */
        @Override
        public void onClick(View v) {
//            String username = mExperts.get(getAdapterPosition()).getUser().getUsername();
            String username = mAllUsers.get(getAdapterPosition()).getUsername();
            if(username == null) {
                return;
            }

            Intent intent = new Intent(Intent.ACTION_SEND,
                    Uri.parse(Constants.HOST + "/users/" + username));
//            v.getContext().startActivity(intent);
            RestAdapterFactory.users().getUser(username, new Callback<User>() {

                @Override
                public void success(User user, Response response) {
                    Log.i(LOG_TAG, user.getId() + ": " + user.getUsername());
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.i(LOG_TAG, error.getMessage());
                }
            });
            Log.i("Main Page", username);
            Intent i = new Intent();

        }
    }


}
