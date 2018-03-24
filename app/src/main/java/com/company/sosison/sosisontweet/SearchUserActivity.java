package com.company.sosison.sosisontweet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.company.sosison.sosisontweet.adapter.UsersAdapter;
import com.company.sosison.sosisontweet.pojo.User;

public class SearchUserActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    EditText searchText;
    Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        toolbar = findViewById(R.id.search_toolbar);
        searchText = toolbar.findViewById(R.id.search__text);
        searchText.setText(null);
        searchButton = toolbar.findViewById(R.id.search_btn);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH){
                    Set(initRecycler());
                    return true;
                }
                return false;
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchText.getText() != null){
                    Set(initRecycler());
                }else{
                    Toast.makeText(SearchUserActivity.this,"No query!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private UsersAdapter initRecycler (){
        recyclerView = (RecyclerView)findViewById(R.id.users_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UsersAdapter adapter = new UsersAdapter();
        recyclerView.setAdapter(adapter);
        return adapter;
    }

    private void Set(UsersAdapter adapter){

        adapter.add(new User(2L,"https://nv.ua/img/article/24467/32_main.jpeg","Ilon Mask",
                "Mr. Stark","Genius ,playboy ,miliarder ","USA",23,455555));
        adapter.add(new User(3L,"https://i.ytimg.com/vi/ZQTqu1_iQkw/maxresdefault.jpg","Joker","@killingjoke",
                "Gotham prince","Gotham",678,666));
    }
}
