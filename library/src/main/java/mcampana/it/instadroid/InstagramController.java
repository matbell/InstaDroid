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

package mcampana.it.instadroid;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import it.matbell.ask.controllers.instagram.responses.FollowsFollowedResponse;
import it.matbell.ask.controllers.network.GsonRequest;


public class InstagramController {

    private static InstagramController instance;
    private String accessToken;
    private Inst2Listener listener;

    private InstagramController(String accessToken, Inst2Listener listener){
        this.accessToken = accessToken;
        this.listener = listener;
    }

    public static InstagramController getInstance(String accessToken, Inst2Listener listener){
        if(instance != null) instance = new InstagramController(accessToken, listener);

        return instance;
    }

    public void getFollows(Context context){

        String url = BASE_URL + "users/self/follows?access_token=" + accessToken;

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<FollowsFollowedResponse> request = new GsonRequest<>(url,
                FollowsFollowedResponse.class,
                null,
                new Response.Listener<FollowsFollowedResponse>() {
                    @Override
                    public void onResponse(FollowsFollowedResponse response) {
                        listener.onFollowsResponse(response.users);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onRequestError(error.getMessage());
                    }});

        queue.add(request);
    }

    public void getFollgetFollowers(Context context){

        String url = BASE_URL + "users/self/followed-by?access_token=ACCESS-TOKEN" + accessToken;

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<FollowsFollowedResponse> request = new GsonRequest<>(url,
                FollowsFollowedResponse.class,
                null,
                new Response.Listener<FollowsFollowedResponse>() {
                    @Override
                    public void onResponse(FollowsFollowedResponse response) {
                        listener.onFollowersResponse(response.users);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onRequestError(error.getMessage());
                    }});

        queue.add(request);
    }
}
