package com.company.sosison.sosisontweet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.company.sosison.sosisontweet.adapter.UsersAdapter;
import com.company.sosison.sosisontweet.pojo.User;

public class SearchUserActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        initRecycler();
    }

    private void initRecycler (){
        recyclerView = (RecyclerView)findViewById(R.id.users_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        UsersAdapter adapter = new UsersAdapter();
        recyclerView.setAdapter(adapter);
        adapter.add(new User(2L,"https://nv.ua/img/article/24467/32_main.jpeg","Ilon Mask",
                "Mr. Stark","Genius ,playboy ,miliarder ","USA",23,455555));
        adapter.add(new User(3L,"https://i.ytimg.com/vi/ZQTqu1_iQkw/maxresdefault.jpg","Joker","@killingjoke",
                "Gotham prince","Gotham",678,666));
    }
}
