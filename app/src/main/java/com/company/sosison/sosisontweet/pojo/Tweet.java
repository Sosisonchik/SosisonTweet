package com.company.sosison.sosisontweet.pojo;

/**
 * Created by User on 18.03.2018.
 */

public class Tweet {
    private User user;
    private long id;
    private String creationDate;
    private String text;
    private int retweetCount;
    private int favouriteCount;
    private String imageUrl;

    public Tweet(User user, long id, String creationDate, String text, int retweetCount, int favouriteCount, String imageUrl) {
        this.user = user;
        this.id = id;
        this.creationDate = creationDate;
        this.text = text;
        this.retweetCount = retweetCount;
        this.favouriteCount = favouriteCount;
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getText() {
        return text;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public int getFavouriteCount() {
        return favouriteCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (id != tweet.id) return false;
        if (retweetCount != tweet.retweetCount) return false;
        if (favouriteCount != tweet.favouriteCount) return false;
        if (!user.equals(tweet.user)) return false;
        if (!creationDate.equals(tweet.creationDate)) return false;
        if (!text.equals(tweet.text)) return false;
        return imageUrl != null ? imageUrl.equals(tweet.imageUrl) : tweet.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + retweetCount;
        result = 31 * result + favouriteCount;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
