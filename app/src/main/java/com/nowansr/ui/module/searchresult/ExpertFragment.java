package com.nowansr.ui.module.searchresult;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nowansr.R;
import com.nowansr.RestAdapterFactory;
import com.nowansr.adapter.ExpertAdapter;
import com.nowansr.model.Skill;
import com.nowansr.model.Users;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * The Expert fragment.
 * Lists the experts available for calling.
 * @author Abhinav
 */
public class ExpertFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ExpertAdapter mExpertAdapter;


    public ExpertFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expert_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mExpertAdapter = new ExpertAdapter();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mExpertAdapter);
    }

    @Override
    public void onResume() {
//        RestAdapterFactory.skills().getSkills(new Callback<List<Skill>>() {
//            @Override
//            public void success(List<Skill> skills, Response response) {
//                mExpertAdapter.setmExperts(skills);
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                String errorMessage = error.getMessage() + " - Failed to retrieve list of skills";
//                Log.e(ExpertFragment.class.getSimpleName(),
//                        errorMessage);
//                Toast.makeText(getActivity().getBaseContext(),
//                        errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });

        RestAdapterFactory.allusers().getAllUsers(new Callback<Users>() {

            @Override
            public void success(Users users, Response response) {
                mExpertAdapter.setmAllUsers(users.getData());
            }

            @Override
            public void failure(RetrofitError error) {
                String errorMessage = error.getMessage() + " - Failed to retrieve list of skills";
                Log.e(ExpertFragment.class.getSimpleName(), errorMessage);
                Toast.makeText(getActivity().getBaseContext(), errorMessage, Toast.LENGTH_LONG).show();
            }
        });

//        RestAdapterFactory.skills().getSkills(new Callback<List<Skill>>() {
//            @Override
//            public void success(List<Skill> skills, Response response) {
//                mExpertAdapter.setmExperts(skills);
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                String errorMessage = error.getMessage() + " - Failed to retrieve list of skills";
//                Log.e(ExpertFragment.class.getSimpleName(),
//                        errorMessage);
//                Toast.makeText(getActivity().getBaseContext(),
//                        errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });

//        RestAdapterFactory.skills().getSkills(new Callback<List<Skill>>() {
//            @Override
//            public void success(List<Skill> users, Response response) {
////                List<User> experts = new ArrayList<User>();
////                for(User u:users) {
////                    if (u.getSkills().size() != 0) {
////                        experts.add(u);
////                    }
////                }
//                Log.d("Experts", response.getUrl());
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.d("Experts", error.getMessage());
//            }
//        });

        super.onResume();
    }
}
