package com.company.sosison.sosisontweet.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.sosison.sosisontweet.R;
import com.company.sosison.sosisontweet.pojo.Tweet;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetViewHolder> {
    private List<Tweet> tweetList = new ArrayList<Tweet>();
    private static final String TWITTER_RESPONSE_FORMAT="EEE MMM dd HH:mm:ss ZZZZZ yyyy";
    private static final String MONTH_DAY_FORMAT = "MMM d";


    public void setItems(Collection<Tweet> tweets){
        tweetList.addAll(tweets);
        notifyDataSetChanged();
    }

    public void clearItems(){
        tweetList.clear();
        notifyDataSetChanged();
    }

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_item_view,parent,false);
        return new TweetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TweetViewHolder holder, int position) {
        holder.bind(tweetList.get(position));

    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImageView;
        private TextView nameTextView;
        private TextView nickTextView;
        private TextView creationDateTextView;
        private TextView contentTextView;
        private ImageView tweetImageView;
        private TextView retweetsTextView;
        private TextView likesTextView;

        public void bind(Tweet tweet){
            nameTextView.setText(tweet.getUser().getName());
            nickTextView.setText(tweet.getUser().getNick());
            contentTextView.setText(tweet.getText());
            retweetsTextView.setText(String.valueOf(tweet.getRetweetCount()));
            likesTextView.setText(String.valueOf(tweet.getFavouriteCount()));

            Picasso.with(itemView.getContext()).load(tweet.getUser().getImageUri()).into(userImageView);
            Picasso.with(itemView.getContext()).load(tweet.getImageUrl()).into(tweetImageView);
            
            creationDateTextView.setText(formatedText(tweet.getCreationDate()));

            tweetImageView.setVisibility(tweet.getImageUrl()!=null ? View.VISIBLE : View.GONE);
        }

        private String formatedText(String rawDate) {
            SimpleDateFormat utcFormat = new SimpleDateFormat(TWITTER_RESPONSE_FORMAT, Locale.ROOT);
            SimpleDateFormat displayedFormat = new SimpleDateFormat(MONTH_DAY_FORMAT, Locale.getDefault());
            try {
                Date date = utcFormat.parse(rawDate);
                return displayedFormat.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                return null;
            }
        }

        public TweetViewHolder(View itemView) {
            super(itemView);
            userImageView = itemView.findViewById(R.id.user_image_view_item);
            nameTextView = itemView.findViewById(R.id.user_name_text_view_item);
            nickTextView = itemView.findViewById(R.id.user_nick_text_view_item);
            creationDateTextView = itemView.findViewById(R.id.date_text_view_item);
            contentTextView = itemView.findViewById(R.id.message_text_view_item);
            tweetImageView = itemView.findViewById(R.id.image_post_item);
            retweetsTextView = itemView.findViewById(R.id.retweets_count_item);
            likesTextView = itemView.findViewById(R.id.likes_count_item);
        }
    }
}
