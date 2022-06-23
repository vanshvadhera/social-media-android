package com.example.samplepage.ui.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samplepage.Adapter.RecycleViewAdapter;
import com.example.samplepage.R;
import com.example.samplepage.databinding.FragmentPebblesBinding;
import com.example.samplepage.userData;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;


public class pebblesFragment extends Fragment {

    FragmentPebblesBinding binding;
    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> active = new ArrayList<>();
    ArrayList<String> Question = new ArrayList<>();
    ArrayList<String> like = new ArrayList<>();
    ArrayList<String> comment = new ArrayList<>();
    ArrayList<String> profilephoto = new ArrayList<>();
    ArrayList<String> postphoto = new ArrayList<>();


    public pebblesFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPebblesBinding.inflate(getLayoutInflater());
        return(binding.getRoot());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            username = bundle.getStringArrayList("username");
            active = bundle.getStringArrayList("active");
            Question = bundle.getStringArrayList("question");
            like = bundle.getStringArrayList("like");
            comment = bundle.getStringArrayList("comment");
            profilephoto = bundle.getStringArrayList("profilephoto");
            postphoto = bundle.getStringArrayList("postphoto");
        }
        //user1
        userData user1 = new userData();
        user1.setUser_name(username.get(0));
        user1.setLast_active(active.get(0));
        user1.setUser_message(Question.get(0));
        user1.setNo_likes(like.get(0));
        user1.setNo_comments(comment.get(0));
        user1.setUser_profileimage(profilephoto.get(0));
        user1.setPost_image(postphoto.get(0));
        //user2
        userData user2 = new userData();
        user2.setUser_name(username.get(1));
        user2.setLast_active(active.get(1));
        user2.setUser_message(Question.get(1));
        user2.setNo_likes(like.get(1));
        user2.setNo_comments(comment.get(1));
        user2.setUser_profileimage(profilephoto.get(1));
        user2.setPost_image(postphoto.get(1));
        //user3
        userData user3 = new userData();
        user3.setUser_name(username.get(2));
        user3.setLast_active(active.get(2));
        user3.setUser_message(Question.get(2));
        user3.setNo_likes(like.get(2));
        user3.setNo_comments(comment.get(2));
        user3.setUser_profileimage(profilephoto.get(2));
        user3.setPost_image(postphoto.get(2));
        //User Array
        userData[] user = {user1, user2, user3 };

        binding.recycleView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        binding.recycleView.setAdapter(new RecycleViewAdapter(user));

        ShimmerFrameLayout container = (ShimmerFrameLayout)binding.shimmerLyout;
        binding.recycleView.setVisibility(View.INVISIBLE);
        container.startShimmerAnimation();
        Handler handler = new Handler();
        handler.postDelayed(()->{
            binding.recycleView.setVisibility(View.VISIBLE);
            container.stopShimmerAnimation();
            container.setVisibility(View.INVISIBLE);
        },3000);

    }
}