package com.company.sosison.sosisontweet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class UserInfoActivity extends AppCompatActivity {
    ImageView userImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        userImage = (ImageView)findViewById(R.id.user_image_view);
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(userImage);
    }
}
