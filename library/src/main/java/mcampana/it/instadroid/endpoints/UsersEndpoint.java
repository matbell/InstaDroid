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

package mcampana.it.instadroid.endpoints;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import mcampana.it.instadroid.RequestListener;
import mcampana.it.instadroid.controller.GsonRequest;
import mcampana.it.instadroid.model.User;
import mcampana.it.instadroid.responses.GetUserResponse;

/**
 * Created by mattia on 14.01.18.
 */

public class UsersEndpoint extends InstagramEndpoint{

    public static void getSelf(Context context, String accessToken,
                               final RequestListener<User> listener){

        getUser(context, accessToken, "self", listener);
    }

    public static void getUser(Context context, String accessToken, String userId,
                               final RequestListener<User> listener){

        String url = BASE_URL + "users/"+userId+"/?access_token=" + accessToken;

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<GetUserResponse> request = new GsonRequest<>(url,
                GetUserResponse.class,
                null,
                new Response.Listener<GetUserResponse>() {
                    @Override
                    public void onResponse(GetUserResponse response) {
                        listener.onResponse(response.user);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.getMessage());
                    }});

        queue.add(request);
    }

    public static void getUserRecentMedia(Context context, String accessToken, String userId,
                                          String maxId, String minId, int count,
                                          final RequestListener<User> listener){

        String url = BASE_URL + "users/"+userId+"/media/recent/?access_token=" + accessToken +
                "&max_id=" + maxId + "&min_id=" + minId + "&count=" + count;

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<GetUserResponse> request = new GsonRequest<>(url,
                GetUserResponse.class,
                null,
                new Response.Listener<GetUserResponse>() {
                    @Override
                    public void onResponse(GetUserResponse response) {
                        listener.onResponse(response.user);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.getMessage());
                    }});

        queue.add(request);
    }
}
