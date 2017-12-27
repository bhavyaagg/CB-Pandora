package me.bhavyaaggarwal.todolistrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import me.bhavyaaggarwal.todolistrecyclerview.adapters.TodoRecyclerAdapter;
import me.bhavyaaggarwal.todolistrecyclerview.models.Todo;

public class MainActivity extends AppCompatActivity {
    EditText etTask;
    Button btnAdd;
    RecyclerView rvTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.etTask);
        btnAdd = findViewById(R.id.btnAdd);
        rvTodos = findViewById(R.id.rvTodos);

        final TodoRecyclerAdapter todoRecyclerAdapter = new TodoRecyclerAdapter(this);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
        rvTodos.setAdapter(todoRecyclerAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoRecyclerAdapter.addTodo(new Todo(etTask.getText().toString(), false));
            }
        });
    }
}
