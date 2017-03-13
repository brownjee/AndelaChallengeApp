package com.brownjee.andelachallengeapp.service;

import com.brownjee.andelachallengeapp.model.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Brownjee on 3/13/2017.
 */
public interface RestApiService {

    @GET("/search/users")
    Call<UserList> getUserList(@Query("q") String filter);

}