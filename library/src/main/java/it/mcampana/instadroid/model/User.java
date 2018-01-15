/*
 * Copyright (c) 2018. Mattia Campana, m.campana@iit.cnr.it, campana.mattia@gmail.com
 *
 * This file is part of Android Sensing Kit (ASK).
 *
 * Android Sensing Kit (ASK) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Android Sensing Kit (ASK) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Android Sensing Kit (ASK).  If not, see <http://www.gnu.org/licenses/>.
 */

package it.mcampana.instadroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mattia on 14.01.18.
 */

public class User{
    public String username;
    @SerializedName("profile_picture") public String profilePicture;
    @SerializedName("full_name") public String fullName;
    @SerializedName("id") public String userId;
    public String bio;
    public String website;
    @SerializedName("is_business") public boolean isBusiness;
    public Counts counts;

    class Counts{
        int media, follows;
        @SerializedName("followed_by") int followedBy;
    }
}
