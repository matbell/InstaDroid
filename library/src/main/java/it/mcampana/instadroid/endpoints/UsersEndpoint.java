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

package it.mcampana.instadroid.endpoints;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import it.mcampana.instadroid.RequestListener;
import it.mcampana.instadroid.controller.GsonRequest;
import it.mcampana.instadroid.model.Media;
import it.mcampana.instadroid.model.User;
import it.mcampana.instadroid.responses.GetUserResponse;
import it.mcampana.instadroid.responses.RecentMediaResponse;
import it.mcampana.instadroid.responses.UserListResponse;

/**
 * Wrapper class for the User Endpoints
 * See https://www.instagram.com/developer/endpoints/users/
 */
public class UsersEndpoint extends InstagramEndpoint{

    /**
     * GET /users/self
     */
    public static void getSelf(Context context, String accessToken,
                               final RequestListener<User> listener){

        getUser(context, accessToken, "self", listener);
    }

    /**
     * GET /users/[user-id]
     */
    public static void getUser(Context context, String accessToken, String userId,
                               final RequestListener<User> listener){

        String url = BASE_URL + "users/"+userId+"/?access_token=" + accessToken;

        final AtomicReference<User> user = new AtomicReference<>();

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<GetUserResponse> request = new GsonRequest<>(url,
                GetUserResponse.class,
                null,
                new Response.Listener<GetUserResponse>() {
                    @Override
                    public void onResponse(GetUserResponse response) {
                        listener.onResponse(response.user);
                        user.set(response.user);
                        notify();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.getMessage());
                    }});

        queue.add(request);
    }

    /**
     * GET /users/self/media/recent
     */
    public static void getSelfRecentMedia(Context context, String accessToken, String maxId,
                                          String minId, int count,
                                          final RequestListener<List<Media>> listener){

        getUserRecentMedia(context, accessToken, "self", maxId, minId, count, listener);
    }

    /**
     * GET /users/[user-id]/media/recent
     */
    public static void getUserRecentMedia(Context context, String accessToken, String userId,
                                          String maxId, String minId, int count,
                                          final RequestListener<List<Media>> listener){

        String url = BASE_URL + "users/"+userId+"/media/recent/?access_token=" + accessToken +
                "&max_id=" + maxId + "&min_id=" + minId + "&count=" + count;

        Log.d("IO", url);

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<RecentMediaResponse> request = new GsonRequest<>(url,
                RecentMediaResponse.class,
                null,
                new Response.Listener<RecentMediaResponse>() {
                    @Override
                    public void onResponse(RecentMediaResponse response) {
                        listener.onResponse(response.media);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.getMessage());
                    }});

        queue.add(request);
    }

    /**
     * GET /users/self/media/liked
     */
    public static void getSelfLikedMedia(Context context, String accessToken, String maxLikeId,
                                         int count, final RequestListener<List<Media>> listener){

        String url = BASE_URL + "users/self/media/liked?access_token=" + accessToken +
                "&max_like_id=" + maxLikeId + "&count=" + count;

        Log.d("IO", url);

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<RecentMediaResponse> request = new GsonRequest<>(url,
                RecentMediaResponse.class,
                null,
                new Response.Listener<RecentMediaResponse>() {
                    @Override
                    public void onResponse(RecentMediaResponse response) {
                        listener.onResponse(response.media);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.getMessage());
                    }});

        queue.add(request);
    }

    /**
     * GET /users/search
     */
    public static void searchUsers(Context context, String accessToken, String queryString,
                                         int count, final RequestListener<List<User>> listener){

        String url = BASE_URL + "users/self/media/liked?access_token=" + accessToken +
                "&q=" + queryString + "&count=" + count;

        Log.d("IO", url);

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<UserListResponse> request = new GsonRequest<>(url,
                UserListResponse.class,
                null,
                new Response.Listener<UserListResponse>() {
                    @Override
                    public void onResponse(UserListResponse response) {
                        listener.onResponse(response.users);
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
