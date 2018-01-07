package me.bhavyaaggarwal.todowithdb.models

/**
 * Created by bhavyaaggarwal on 07/01/18.
 */

data class Todo(
        val id: Int,
        val task: String,
        val done: Boolean
)