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

package mcampana.it.instadroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mattia on 14.01.18.
 */

public class Media {

    String type;
    @SerializedName("users_in_photo") List<UserInPhoto> usersInPhoto;

    String filter;
    List<String> tags;
    Count comments;
    String caption;
    Count likes;
    String link;
    User user;
    @SerializedName("created_time") long createdTime;
    MediaFields images;
    MediaFields videos;
    @SerializedName("carousel_media") List<MediaField> carouselMedia;
    String id;
    Location location;


    class UserInPhoto{

        User user;
        PositionInPhoto position;

        class PositionInPhoto{
            float x,y;
        }
    }

    class Count{
        int count;
    }

    class MediaFields{
        MediaField thumbnail;
        @SerializedName("low_resolution") MediaField lowResolution;
        @SerializedName("standard_resolution") MediaField standardResolution;
    }

    class MediaField{

        String url;
        int width, height;

    }
}
