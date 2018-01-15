package it.mcampana.instadroid.endpoints;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.List;

import it.mcampana.instadroid.RequestListener;
import it.mcampana.instadroid.controller.GsonRequest;
import it.mcampana.instadroid.model.User;
import it.mcampana.instadroid.responses.UserListResponse;

/**
 * Created by mattia on 15/01/18.
 */

public class RelationshipsEndpoint extends InstagramEndpoint{

    public static void getFollows(Context context, String accessToken,
                                  final RequestListener<List<User>> listener){

        String url = BASE_URL + "users/self/follows?access_token=" + accessToken;

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

    public static void getFollowedBy(Context context, String accessToken,
                                     final RequestListener<List<User>> listener){

        String url = BASE_URL + "users/self/followed-by?access_token=" + accessToken;

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

    public static void getRequestedBy(Context context, String accessToken,
                                      final RequestListener<List<User>> listener){

        String url = BASE_URL + "users/self/requested-by?access_token=" + accessToken;

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
