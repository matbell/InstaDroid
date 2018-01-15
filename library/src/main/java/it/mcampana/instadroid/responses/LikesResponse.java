package it.mcampana.instadroid.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import it.mcampana.instadroid.model.Like;

/**
 * Created by mattia on 15/01/18.
 */

public class LikesResponse {

    @SerializedName("data")
    public List<Like> likes;
}
