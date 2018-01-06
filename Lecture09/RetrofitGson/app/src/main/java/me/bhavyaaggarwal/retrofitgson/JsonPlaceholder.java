package me.bhavyaaggarwal.retrofitgson;

import java.util.ArrayList;

import me.bhavyaaggarwal.retrofitgson.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by bhavyaaggarwal on 06/01/18.
 */

public interface JsonPlaceholder {

    @GET("posts")
    Call<ArrayList<Post>> getPosts();

    @GET("posts/{postId}")
    Call<Post> getPostById(
            @Path("postId") Integer postId
    );
}
