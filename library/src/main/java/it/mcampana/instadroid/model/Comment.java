package it.mcampana.instadroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mattia on 15/01/18.
 */

public class Comment {

    @SerializedName("created_time") public String createdTime;
    public String text;
    public User from;
    public String id;
}
