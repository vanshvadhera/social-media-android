package com.example.samplepage.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplepage.CircleTransform;
import com.example.samplepage.R;
import com.example.samplepage.userData;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter  extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private userData[] localDataSet;
    ImageView userProfile;
    TextView userName;
    TextView lastActive;
    TextView userMessage;
    ImageView imageView;
    TextView nooflikes;
    TextView noofcomments;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userProfile;
        TextView userName;
        TextView lastActive;
        TextView userMessage;
        ImageView imageView;
        TextView nooflikes;
        TextView noofcomments;
        ImageView likebutton;
        int time = 1 ;
        boolean state = true;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            userProfile = view.findViewById(R.id.userProfile);
            userName = (TextView) view.findViewById(R.id.userName);
            lastActive = view.findViewById(R.id.lastActive);
            userMessage = view.findViewById(R.id.userMessage);
            imageView = view.findViewById(R.id.imageView);
            nooflikes = view.findViewById(R.id.nooflikes);
            noofcomments = view.findViewById(R.id.noofcomments);
            likebutton =view.findViewById(R.id.likebutton);
        }

        public TextView getTextView() {
            return userName;
        }
    }

    public RecycleViewAdapter(userData[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.basic_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {

        if (localDataSet[position].getUser_name() == "")
        {
            holder.userName.setText("Anonymous User");
        }else{
            holder.userName.setText(localDataSet[position].getUser_name());
        }
        if(localDataSet[position].getUser_profileimage() == ""){
            Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuIbv-7JSgC23hcGq8qDRBpFzdMBEw8urHdQ&usqp=CAU").transform(new CircleTransform()).into(holder.userProfile);
        }
        else{
            Picasso.get().load(localDataSet[position].getUser_profileimage()).transform(new CircleTransform()).into(holder.userProfile);
        }
        holder.lastActive.setText(localDataSet[position].getLast_active());
        holder.userMessage.setText(localDataSet[position].getUser_message());
//        holder.imageView.setText(localDataSet[position].getUser_name());
        if(localDataSet[position].getNo_likes() == ""){
            holder.nooflikes.setText("0");
        }else{
            holder.nooflikes.setText(localDataSet[position].getNo_likes());
        }
        if(localDataSet[position].getNo_comments() == ""){
            holder.noofcomments.setText("0");
        }else{
            holder.noofcomments.setText(localDataSet[position].getNo_comments());
        }
        if(localDataSet[position].getPost_image() == null || localDataSet[position].getPost_image() == ""){
            holder.imageView.setVisibility(View.INVISIBLE);
        }else {
            Picasso.get().load(localDataSet[position].getPost_image()).into(holder.imageView);
            Log.d("data", "onBindViewHolder: ");
        }
        holder.likebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = String.valueOf(holder.nooflikes.getText());
                int valuein = Integer.parseInt(value);
                if(holder.state && holder.time == 1){
                    valuein += 1;
                    Log.d("data", String.valueOf(valuein));
                    holder.nooflikes.setText(String.valueOf(valuein));
                    holder.state = false;
                    holder.time++;
                }
                else{
                    valuein -= 1;
                    Log.d("data", String.valueOf(valuein));
                    holder.nooflikes.setText(String.valueOf(valuein));
                    holder.state = true;
                    holder.time--;
                }
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String value = String.valueOf(holder.nooflikes.getText());
                        int valuein = Integer.parseInt(value);
                            if (holder.time == 1) {
                                valuein += 1;
                                Log.d("data", String.valueOf(valuein));
                                holder.nooflikes.setText(String.valueOf(valuein));
                                holder.time++;
                            }
                            else
                            {
                                Toast.makeText(holder.getTextView().getContext(), "Alredy Liked", Toast.LENGTH_SHORT).show();
                            }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

}
