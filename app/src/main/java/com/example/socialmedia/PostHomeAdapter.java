package com.example.socialmedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.socialmedia.model2.Post;

import java.util.ArrayList;
import java.util.List;

public class PostHomeAdapter extends ArrayAdapter<Post> {
    private List<Post> posts=new ArrayList<>();
    private Context context;
    LayoutInflater lInflater;
    int ressource;

    PostHomeAdapter(Context context,int ressource,List<Post> posts){
        super(context,ressource,posts);


    }

    @Override
    public View getView(int position, @NonNull View convertview, @NonNull ViewGroup parent){

         convertview= lInflater.from(getContext()).inflate(R.layout.post_home,parent,false);
         Post post=getItem(position);
        ImageView image=convertview.findViewById(R.id.picture);
        TextView email=convertview.findViewById(R.id.user);
        TextView desc=convertview.findViewById(R.id.description);
        image.setImageBitmap(Utility.convertBLOB2Bitmap(post.getImage()));
        email.setText(post.getEmail_user());
        desc.setText(post.getDescription());
        return convertview;
    }
    public int getCount() {
        return posts.size();
    }
    public Post getItem(int position) {
        return posts.get(position);
    }


}
