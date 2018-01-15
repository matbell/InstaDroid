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

import java.util.List;

/**
 * Created by mattia on 14.01.18.
 */

public class Media {

    public String type;
    @SerializedName("users_in_photo") public List<UserInPhoto> usersInPhoto;
    public String filter;
    public List<String> tags;
    public Count comments;
    public Caption caption;
    public Count likes;
    public String link;
    public User user;
    @SerializedName("created_time") public long createdTime;
    public MediaFields images;
    public MediaFields videos;
    @SerializedName("carousel_media") public List<MediaField> carouselMedia;
    public String id;
    public Location location;


    public class UserInPhoto{

        public User user;
        public PositionInPhoto position;

        public class PositionInPhoto{
            public float x,y;
        }
    }

    public class Count{
        public int count;
    }

    public class MediaFields{
        public MediaField thumbnail;
        @SerializedName("low_resolution") public MediaField lowResolution;
        @SerializedName("standard_resolution") public MediaField standardResolution;
    }

    public class MediaField{

        public String url;
        public int width, height;

    }

    public class Caption{
        public String id;
        public String text;
        @SerializedName("created_time") public String createdTime;
        public User from;
    }
}
