package me.bhavyaaggarwal.todolistkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.bhavyaaggarwal.todolistkotlin.adapters.TodoRecyclerAdapter
import me.bhavyaaggarwal.todolistkotlin.models.Todo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTodos.layoutManager = LinearLayoutManager(this);
        val todoRecyclerAdapter: TodoRecyclerAdapter = TodoRecyclerAdapter(this);
        rvTodos.adapter = todoRecyclerAdapter

        btnAdd.setOnClickListener {
            todoRecyclerAdapter.addTodo(Todo(etTask.text.toString(), false))
        }
    }
}
