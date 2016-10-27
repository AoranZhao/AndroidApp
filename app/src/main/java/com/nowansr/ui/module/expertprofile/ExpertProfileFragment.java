package com.nowansr.ui.module.expertprofile;

import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.nowansr.Constants;
import com.nowansr.R;
import com.nowansr.RestAdapterFactory;
import com.nowansr.model.Skill;
import com.nowansr.model.Task;
import com.nowansr.model.User;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.IOException;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ExpertProfileFragment extends Fragment {

    private static String LOG_TAG = ExpertProfileFragment.class.getSimpleName();

    private String username;
    private ProgressBar progressBar;
    private ScrollView scrollView;
    private LinearLayout linearLayoutCallMeButton;
    private ViewHolder viewHolder;
    private User mUser;

    public ExpertProfileFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();

        if(intent.getData() != null) {
            Uri uri = intent.getData();
            username = uri.getLastPathSegment();
        }

        View rootView = inflater.inflate(R.layout.fragment_expert_profile, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        scrollView = (ScrollView) rootView.findViewById(R.id.scrollView);
        scrollView.setVisibility(View.GONE);

        linearLayoutCallMeButton = (LinearLayout) rootView.findViewById(R.id.call_expert_linear_layout);
        linearLayoutCallMeButton.setVisibility(View.GONE);

        viewHolder = new ViewHolder(rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        bindData();
        super.onResume();
    }

    /**
     * A view holder for the layout.
     */
    public class ViewHolder {

        public ImageView expertProfilePicture;
        public TextView expertName;
        public TextView expertLocation;
        public TextView expertSummary;
        public LinearLayout languageLinearLayout;
        public LinearLayout skillsLinearLayout;
        private TextView callMeNow;

        public ViewHolder(View view) {
            expertProfilePicture = (ImageView) view.findViewById(R.id.fragment_expert_profile_image);
            expertName = (TextView) view.findViewById(R.id.fragment_expert_name);
            expertLocation = (TextView) view.findViewById(R.id.fragment_expert_location);
            expertSummary = (TextView) view.findViewById(R.id.fragment_expert_summary);
            languageLinearLayout = (LinearLayout) view.findViewById(R.id.fragment_expert_language_linear_layout);
            skillsLinearLayout = (LinearLayout) view.findViewById(R.id.fragment_expert_skills_horizontal_linear_layout);
            callMeNow = (TextView) view.findViewById(R.id.fragment_expert_call_me_now);
            callMeNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Task task = new Task();
                    task.setName("test task name from Android");
                    task.setExpertId(mUser.getId());
                    task.setSkillId(mUser.getSkills().get(0).getId());

                    try {
                        RestAdapterFactory.task(v.getContext()).create(task, new Callback<Object>() {
                            @Override
                            public void success(Object o, Response response) {
                                Log.d(LOG_TAG, "Task created");
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Log.e(LOG_TAG, "Task creation failed", error);
                            }
                        });
                    } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                        Log.e(LOG_TAG, "Calling expert failed", e);
                    }
                }
            });
        }

    }

    /**
     * Bind data to the UI.
     */
    private void bindData() {

        RestAdapterFactory.users().getUser(username, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                mUser = user;

                progressBar.setVisibility(View.GONE);
                linearLayoutCallMeButton.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.VISIBLE);

                if (user.getName() != null) {
                    viewHolder.expertName.setText(user.getName());
                }

                if (user.getLocation() != null) {
                    viewHolder.expertLocation.setText(user.getLocation().getCity() + ", "
                            + user.getLocation().getState());
                }

                Transformation transformation = new RoundedTransformationBuilder()
                        .cornerRadiusDp(50)
                        .oval(false)
                        .build();

                if (!user.getAvatar().equalsIgnoreCase("default.png")) {
                    Picasso.with(viewHolder.expertProfilePicture.getContext())
                            .load(Constants.PROFILE_IMAGE_STORE + user.getAvatar())
                            .transform(transformation)
                            .into(viewHolder.expertProfilePicture);
                } else {
                    Picasso.with(viewHolder.expertProfilePicture.getContext())
                            .load(R.mipmap.ic_launcher)
                            .transform(transformation)
                            .into(viewHolder.expertProfilePicture);
                }

                viewHolder.languageLinearLayout.removeViews(1, viewHolder.languageLinearLayout.getChildCount() - 1);
                for (Object language: user.getLanguages()) {
//                for (String language : user.getLanguages()) {
                    TextView textView = new TextView(getActivity());
                    textView.setTextAppearance(getActivity(), R.style.Base_TextAppearance_AppCompat_Body1);
                    textView.setText((String)language);
                    viewHolder.languageLinearLayout.addView(textView, 1 + user.getLanguages().indexOf(language));
                }


                /**
                 * Build the Skills "table"
                 * The UI will be rendered as follows
                 * English       $2/min      ****
                 * French        $3/min      *****
                 */
                viewHolder.skillsLinearLayout.removeAllViews();
                for (String s : new String[]{"name", "price", "rating"}) {
                    LinearLayout linearLayout = new LinearLayout(getActivity());
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    linearLayoutParams.weight = 1;
                    linearLayout.setLayoutParams(linearLayoutParams);
                    for (Skill skill : user.getSkills()) {

                        switch (s) {
                            case "name": {
                                linearLayout.addView(buildSkillTextView(skill.getName()), linearLayout.getChildCount());
                                break;
                            }
                            case "price": {
                                linearLayout.addView(buildSkillTextView(
                                        "$" + String.format("%.2f", skill.getPrice()) + "/min"), linearLayout.getChildCount());
                                break;
                            }

                            case "rating": {
                                LinearLayout.LayoutParams ratingBarLayoutParams = new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT);

                                float ratingMean = (float) (skill.getRating().getHelp() + skill.getRating().getTech()) / 2;
                                if (ratingMean > 0) {
                                    ratingBarLayoutParams.bottomMargin = 10;
                                    RatingBar ratingBar = new RatingBar(getActivity(), null, android.R.attr.ratingBarStyleSmall);
                                    ratingBar.setLayoutParams(ratingBarLayoutParams);
                                    ratingBar.setNumStars(5);
                                    ratingBar.setRating(ratingMean);
                                    linearLayout.addView(ratingBar, linearLayout.getChildCount());
                                }
                                break;
                            }

                            default:
                                throw new UnsupportedOperationException("Unsupported view");
                        }

                    }
                    viewHolder.skillsLinearLayout.addView(linearLayout, viewHolder.skillsLinearLayout.getChildCount());
                }

//                viewHolder.expertSummary.setText(user.getSummary());
                viewHolder.expertSummary.setText(user.getProfileSummary());

                progressBar.setVisibility(View.GONE);
                linearLayoutCallMeButton.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.VISIBLE);

            }

            @Override
            public void failure(RetrofitError error) {
                String errorMessage = error.getMessage() + " - Failed to retrieve user";
                Log.e(LOG_TAG,
                        errorMessage);
                Toast.makeText(getActivity().getBaseContext(),
                        errorMessage, Toast.LENGTH_LONG).show();

            }
        });
    }

    /**
     * Create a text view.
     * @param text The text to be assigned to the text view
     * @return <code>TextView</code>
     */
    private TextView buildSkillTextView(String text) {
        TextView textView = new TextView(getActivity());
        textView.setTextAppearance(getActivity(), R.style.Base_TextAppearance_AppCompat_Body1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        if(text != null) {
            textView.setText(text);
            layoutParams.weight = 1;
        } else {
            layoutParams.weight = 3;
        }
        textView.setLayoutParams(layoutParams);

        return textView;
    }


}
