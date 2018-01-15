package it.mcampana.instadroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mattia on 15/01/18.
 */

public class Like {

    public String username;
    @SerializedName("first_name") public String firstName;
    @SerializedName("last_name") public String lastName;
    public String type;
    public String id;

}
