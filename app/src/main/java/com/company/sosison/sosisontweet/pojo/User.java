package com.company.sosison.sosisontweet.pojo;

/**
 * Created by User on 17.03.2018.
 */

public class User {
    private long id;
    private String imageUri;
    private String name;
    private String nick;
    private String description;
    private String location;
    private int following_count;
    private int followers_count;

    public User(long id, String imageUri, String name, String nick, String description, String location, int following_count, int followers_count) {
        this.id = id;
        this.imageUri = imageUri;
        this.name = name;
        this.nick = nick;
        this.description = description;
        this.location = location;
        this.following_count = following_count;
        this.followers_count = followers_count;
    }

    public long getId() {
        return id;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getFollowing_count() {
        return following_count;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (following_count != user.following_count) return false;
        if (followers_count != user.followers_count) return false;
        if (imageUri != null ? !imageUri.equals(user.imageUri) : user.imageUri != null)
            return false;
        if (!name.equals(user.name)) return false;
        if (!nick.equals(user.nick)) return false;
        if (description != null ? !description.equals(user.description) : user.description != null)
            return false;
        return location != null ? location.equals(user.location) : user.location == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (imageUri != null ? imageUri.hashCode() : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + nick.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + following_count;
        result = 31 * result + followers_count;
        return result;
    }
}
