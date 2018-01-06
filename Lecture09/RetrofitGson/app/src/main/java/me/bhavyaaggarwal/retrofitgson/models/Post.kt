package me.bhavyaaggarwal.retrofitgson.models

/**
 * Created by bhavyaaggarwal on 06/01/18.
 */

data class Post(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
);