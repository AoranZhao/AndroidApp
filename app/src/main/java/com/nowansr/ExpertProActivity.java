package com.nowansr;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nowansr.model.Skill;
import com.nowansr.model.User;
import com.squareup.picasso.Picasso;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ExpertProActivity extends AppCompatActivity {

    private final String LOG_TAG = ExpertProActivity.class.getSimpleName();

    private String expertName;
    private ImageView profileImage;
    private TextView txtExpertName, txtExpertLocation, txtExpertSummary, txtCallMe;
    private LinearLayout llSkill, llLanguage, llSkillH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_pro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Expert");
        setSupportActionBar(toolbar);

        profileImage = (ImageView) findViewById(R.id.ep_expert_profile_image);
        txtExpertName = (TextView) findViewById(R.id.ep_expert_name);
        txtExpertLocation = (TextView) findViewById(R.id.ep_expert_location);
        txtExpertSummary = (TextView) findViewById(R.id.ep_expert_summary);
        llSkill = (LinearLayout) findViewById(R.id.ep_expert_skills_linear_layout);
        llSkillH = (LinearLayout) findViewById(R.id.ep_expert_skills_horizontal_linear_layout);
        llLanguage = (LinearLayout) findViewById(R.id.ep_expert_language_linear_layout);
        txtCallMe = (TextView) findViewById(R.id.ep_expert_call_me_now);
        txtCallMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                i.setAction(Intent.ACTION_CALL);
                startActivity(i);
            }
        });

        if (getSupportActionBar()!= null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void GetExpertProfile() {
        Log.i(LOG_TAG, "GetExpertProfile: " + expertName);
        if (expertName != null) {
            RestAdapterFactory.users().getUser(expertName, new Callback<User>() {
                @Override
                public void success(User user, Response response) {
                    txtExpertName.setText(user.getUsername());
                    String location = (user.getLocation().getCity() != null)? user.getLocation().getCity() : "unknown";
                    txtExpertLocation.setText(location);
                    txtExpertSummary.setText(user.getProfileSummary());

                    Picasso.with(getBaseContext()).load(Constants.PROFILE_IMAGE_STORE + user.getAvatar()).into(profileImage);

                    llLanguage.removeViews(1, llLanguage.getChildCount() - 1);
                    for (Object language: user.getLanguages()) {
//                for (String language : user.getLanguages()) {
                        TextView textView = new TextView(getBaseContext());
                        textView.setTextAppearance(getBaseContext(), R.style.Base_TextAppearance_AppCompat_Body1);
                        textView.setTextColor(Color.BLACK);
                        textView.setText((String)language);
                        llLanguage.addView(textView, 1 + user.getLanguages().indexOf(language));
                    }


                    /**
                     * Build the Skills "table"
                     * The UI will be rendered as follows
                     * English       $2/min      ****
                     * French        $3/min      *****
                     */
                    llSkillH.removeAllViews();
                    for (String s : new String[]{"name", "price", "rating"}) {
                        LinearLayout linearLayout = new LinearLayout(getBaseContext());
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

                                    int helprating = 0;
                                    int techrating = 0;

                                    if (skill.getRating() != null) {
                                        helprating = (skill.getRating().getHelp() != null) ? skill.getRating().getHelp() : 0;
                                        techrating = (skill.getRating().getTech() != null) ? skill.getRating().getTech() : 0;
                                    }

                                    float ratingMean = (float) (helprating + techrating) / 2;
                                    if (ratingMean > 0) {
                                        ratingBarLayoutParams.bottomMargin = 10;
                                        RatingBar ratingBar = new RatingBar(getBaseContext(), null, android.R.attr.ratingBarStyleSmall);
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
                        llSkillH.addView(linearLayout, llSkillH.getChildCount());
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.i(LOG_TAG, error.getMessage());
                }
            });
        } else {
            Log.i(LOG_TAG, " > no expert name.");
        }
    }

    private void showMessage(final String msg) {
        if (TextUtils.isEmpty(msg))
            return;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private TextView buildSkillTextView(String text) {
        TextView textView = new TextView(getBaseContext());
        textView.setTextAppearance(getBaseContext(), R.style.Base_TextAppearance_AppCompat_Body1);
        textView.setTextColor(Color.BLACK);
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

    @Override
    protected void onResume() {
        super.onResume();
        expertName = getIntent().getStringExtra(Constants.EXPERTNAME_LABEL);
        GetExpertProfile();

    }
}
