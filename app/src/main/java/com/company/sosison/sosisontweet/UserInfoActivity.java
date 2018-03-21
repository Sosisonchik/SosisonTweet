package com.company.sosison.sosisontweet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.company.sosison.sosisontweet.adapter.TweetAdapter;
import com.company.sosison.sosisontweet.pojo.Tweet;
import com.company.sosison.sosisontweet.pojo.User;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.Collection;

public class UserInfoActivity extends AppCompatActivity {
    ImageView userImage_view;
    TextView name_view;
    TextView nick_view;
    TextView description_view;
    TextView location_view;
    TextView following_count_view;
    TextView followers_count_view;
    private RecyclerView tweetsRycler;
    android.support.v7.widget.Toolbar toolbar;
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
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        initRecycler();
        TweetAdapter adapter = new TweetAdapter();
        tweetsRycler.setAdapter(adapter);
        adapter.setItems(getTweets());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.search_btn){
            Intent intent = new Intent(this,SearchUserActivity.class);
            startActivity(intent);
        }
        return true;
    }

    private Collection<Tweet> getTweets() {
        return Arrays.asList(
                new Tweet(loadUser(), 1L, "Thu Dec 13 07:31:08 +0000 2017", "Очень длинное описание твита 1",
                        4, 23, "https://www.w3schools.com/w3css/img_fjords.jpg"),

                new Tweet(loadUser(), 2L, "Thu Dec 12 07:31:08 +0000 2017", "Очень длинное описание твита 2",
                        5, 5, "https://www.w3schools.com/w3images/lights.jpg"),

                new Tweet(loadUser(), 3L, "Thu Dec 11 07:31:08 +0000 2017", "Очень длинное описание твита 3",
                        6, 6, "https://www.w3schools.com/css/img_mountains.jpg")
        );
    }

    private void initRecycler() {
        tweetsRycler = (RecyclerView)findViewById(R.id.tweets_recycler_view);
        tweetsRycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
