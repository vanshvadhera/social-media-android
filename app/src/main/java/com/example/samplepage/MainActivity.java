package com.example.samplepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.samplepage.databinding.FragmentHomeBinding;
import com.example.samplepage.ui.Fragments.createFragment;
import com.example.samplepage.ui.Fragments.homeFragment;
import com.example.samplepage.ui.Fragments.notificationFragment;
import com.example.samplepage.ui.Fragments.pebblesFragment;
import com.example.samplepage.ui.Fragments.profileFragment;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.samplepage.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Declaring
    private ActivityMainBinding binding;
    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> active = new ArrayList<>();
    ArrayList<String> Question = new ArrayList<>();
    ArrayList<String> like = new ArrayList<>();
    ArrayList<String> comment = new ArrayList<>();
    ArrayList<String> profilephoto = new ArrayList<>();
    ArrayList<String> postphoto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding action bar
        getSupportActionBar().hide();

        //ini view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // for reading jason
        try {
            String strResponse = null;
            JSONArray json = new JSONArray(JsonDataFromAssert());

            //storing values into ArrayList
            for (int i = 0; i < json.length(); i++) {
                Log.e("Message", "loop");
                JSONObject data = json.getJSONObject(i);
                username.add(data.optString("fullname"));
                active.add(data.optString("publishtime"));
                Question.add(data.optString("question"));
                like.add(data.optString("likescount"));
                comment.add(data.optString("commentscount"));
                profilephoto.add(data.optString("profile_photo"));
                postphoto.add(data.optString("post_photo"));
            }
        } catch (JSONException e) {
            Log.e("Message", "Error parsing data " + e.toString());
        }


        //Adding data to bundle
        pebblesFragment fragment = new pebblesFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("username", username);
        bundle.putStringArrayList("active", active);
        bundle.putStringArrayList("question", Question);
        bundle.putStringArrayList("like", like);
        bundle.putStringArrayList("comment", comment);
        bundle.putStringArrayList("profilephoto", profilephoto);
        bundle.putStringArrayList("postphoto", postphoto);
        fragment.setArguments(bundle);
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();

        //init navbar on click listener
        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_pebbles: {
                    homeFragment fragment1 = new homeFragment();
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    bundle.putSerializable("ARRAYLIST",(Serializable)username);
                    bundle.putStringArrayList("username", username);
                    bundle.putStringArrayList("active", active);
                    bundle.putStringArrayList("question", Question);
                    bundle.putStringArrayList("like", like);
                    bundle.putStringArrayList("comment", comment);
                    bundle.putStringArrayList("profilephoto", profilephoto);
                    bundle.putStringArrayList("postphoto", postphoto);
                    fragment1.setArguments(bundle);
                    transaction1.replace(R.id.fragment, fragment1);
                    transaction1.commit();
                    break;
                }
                case R.id.navigation_home: {
                    pebblesFragment fragment5 = new pebblesFragment();
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    //Extra work
                    bundle.putSerializable("ARRAYLIST",(Serializable)username);
                    bundle.putStringArrayList("username", username);
                    bundle.putStringArrayList("active", active);
                    bundle.putStringArrayList("question", Question);
                    bundle.putStringArrayList("like", like);
                    bundle.putStringArrayList("comment", comment);
                    bundle.putStringArrayList("profilephoto", profilephoto);
                    bundle.putStringArrayList("postphoto", postphoto);
                    fragment5.setArguments(bundle);
                    //
                    transaction1.replace(R.id.fragment, fragment5);
                    transaction1.commit();
                    break;
                }
                case R.id.navigation_create: {
                    createFragment fragment2 = new createFragment();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.fragment, fragment2);
                    transaction2.commit();
                    break;
                }
                case R.id.navigation_notifications: {
                    notificationFragment fragment3 = new notificationFragment();
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    transaction3.replace(R.id.fragment, fragment3);
                    transaction3.commit();
                    break;
                }
                case R.id.navigation_profile: {
                    profileFragment fragment4 = new profileFragment();
                    FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                    transaction4.replace(R.id.fragment, fragment4);
                    transaction4.commit();
                    break;
                }
            }
            return true;
        });

    }

    // reading data from assert (method)
    private String JsonDataFromAssert() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("data.json");
            int filesize = inputStream.available();
            byte[] bufferdata = new byte[filesize];
            inputStream.read(bufferdata);
            inputStream.close();
            json = new String(bufferdata, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}