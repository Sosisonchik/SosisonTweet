package com.company.sosison.sosisontweet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.sosison.sosisontweet.pojo.User;
import com.squareup.picasso.Picasso;

public class UserInfoActivity extends AppCompatActivity {
    ImageView userImage_view;
    TextView name_view;
    TextView nick_view;
    TextView description_view;
    TextView location_view;
    TextView following_count_view;
    TextView followers_count_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        userImage_view = (ImageView)findViewById(R.id.user_image_view);
        name_view = (TextView)findViewById(R.id.user_name_text_view);
        nick_view = (TextView)findViewById(R.id.user_nick_text_view);
        description_view = (TextView)findViewById(R.id.user_description_text_view);
        location_view = (TextView)findViewById(R.id.user_location_text_view);
        following_count_view = (TextView)findViewById(R.id.following_count_text_view);
        followers_count_view = (TextView)findViewById(R.id.followers_count_text_view);
        confirmInformation(loadUser());
    }

    private User loadUser(){
        return new User(1L,"https://st.kp.yandex.net/images/article/sm_2806726_01_201609090317175965.jpg",
                "Sosiska","@sosison","Love memes",
                "My sello",321,100);
    }

    private void confirmInformation(User user){
        Picasso.with(this).load(user.getImageUri()).into(userImage_view);
        name_view.setText(user.getName());
        nick_view.setText(user.getNick());
        description_view.setText(user.getDescription());
        location_view.setText(user.getLocation());
        following_count_view.setText(String.valueOf(user.getFollowing_count()));
        followers_count_view.setText(String.valueOf(user.getFollowers_count()));
    }
}
