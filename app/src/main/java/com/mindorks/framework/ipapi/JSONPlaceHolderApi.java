package com.mindorks.framework.ipapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("json")
    Call<Post> getPosts();
}
