package com.example.samplepage.ui.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.samplepage.CircleTransform;
import com.example.samplepage.databinding.FragmentHomeBinding;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class homeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> active = new ArrayList<>();
    ArrayList<String> Question = new ArrayList<>();
    ArrayList<String> like = new ArrayList<>();
    ArrayList<String> comment = new ArrayList<>();
    ArrayList<String> profilephoto = new ArrayList<>();
    ArrayList<String> postphoto = new ArrayList<>();
    Boolean state = true;
    Boolean state1 = true;
    int time = 1 ;
    // empty constructor
    public homeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //init view binding
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return (binding.getRoot());

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getting values from activity
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

        //shimmer view ini
        ShimmerFrameLayout container = (ShimmerFrameLayout)binding.shimmerLyout;
        binding.main.setVisibility(View.INVISIBLE);
        container.startShimmerAnimation();
        Handler handler = new Handler();
        handler.postDelayed(()->{
            binding.main.setVisibility(View.VISIBLE);
            container.stopShimmerAnimation();
            container.setVisibility(View.INVISIBLE);
        },3000);

        // inserting values in views
        binding.userName1.setText(username.get(0));
        binding.lastActive1.setText(active.get(0));
        binding.userMessage1.setText(Question.get(0));
        binding.lastActive2.setText(active.get(1));
        binding.userMessage2.setText(Question.get(1));
        binding.nooflikes.setText(like.get(1));
        binding.noofcomments.setText(comment.get(0));
        binding.userName3.setText(username.get(2));
        binding.lastActive3.setText(active.get(2));
        binding.userMessage3.setText(Question.get(2));
        binding.nooflikes1.setText(like.get(2));
        binding.noofcomments.setText(comment.get(1));
        Picasso.get().load(postphoto.get(2)).into(binding.imageView7);
        Picasso.get().load(profilephoto.get(0)).transform(new CircleTransform()).into(binding.userProfile1);
        Picasso.get().load(profilephoto.get(2)).transform(new CircleTransform()).into(binding.userProfile3);

        for(int i= 0 ; i<active.size();i++)
        {
            Log.d("data", Question.get(i));
        }

        //ini like button
        binding.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = String.valueOf(binding.nooflikes.getText());
                int valuein = Integer.parseInt(value);
                if(state){
                    valuein += 1;
                    Log.d("data", String.valueOf(valuein));
                    binding.nooflikes.setText(String.valueOf(valuein));
                    state = false;
                }
                else{
                    valuein -= 1;
                    Log.d("data", String.valueOf(valuein));
                    binding.nooflikes.setText(String.valueOf(valuein));
                    state = true;
                }
            }
        });
        binding.imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = String.valueOf(binding.nooflikes1.getText());
                int valuein = Integer.parseInt(value);
                if(state1 && time == 1){
                    valuein += 1;
                    Log.d("data", String.valueOf(valuein));
                    binding.nooflikes1.setText(String.valueOf(valuein));
                    state1 = false;
                    time++;
                }
                else{
                    valuein -= 1;
                    Log.d("data", String.valueOf(valuein));
                    binding.nooflikes1.setText(String.valueOf(valuein));
                    state1 = true;
                    time--;
                }
            }
        });
        binding.imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imageView7.setOnClickListener(new View.OnClickListener() {
                    String value = String.valueOf(binding.nooflikes1.getText());
                    int valuein = Integer.parseInt(value);
                    @Override
                    public void onClick(View view) {
                        if (time == 1) {
                            valuein += 1;
                            Log.d("data", String.valueOf(valuein));
                            binding.nooflikes1.setText(String.valueOf(valuein));
                            time++;
                        }
                        else
                        {
                            Toast.makeText(getContext(), "Alredy Liked", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

//    private Bitmap getBitmapFromURL(String url1) {
//        try {
//            URL url = new URL(url1);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream input = connection.getInputStream();
//            Bitmap myBitmap = BitmapFactory.decodeStream(input);
//            Log.e("Bitmap","returned");
//            return myBitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.e("Exception", String.valueOf(e));
//            return null;
//        }
//    }
}