package me.bhavyaaggarwal.todowithdb;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import me.bhavyaaggarwal.todowithdb.adapters.TodoAdapter;
import me.bhavyaaggarwal.todowithdb.db.TodoDatabaseHelper;
import me.bhavyaaggarwal.todowithdb.db.tables.TodoTable;
import me.bhavyaaggarwal.todowithdb.models.Todo;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TODOS";

    ListView lvTodos;
    EditText etTask;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTodos = findViewById(R.id.lvTodos);
        etTask = findViewById(R.id.etTask);
        btnAdd = findViewById(R.id.btnAdd);


        TodoDatabaseHelper myDbHelper = new TodoDatabaseHelper(this);
        final SQLiteDatabase writeDb = myDbHelper.getWritableDatabase();
        final SQLiteDatabase readDb = myDbHelper.getReadableDatabase();

        final TodoAdapter todoAdapter = new TodoAdapter(this, TodoTable.getAllTodos(readDb));
        lvTodos.setAdapter(todoAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoTable.insertTodo(new Todo(0, etTask.getText().toString(), false), writeDb);
                todoAdapter.refreshTodos(readDb);
            }
        });
    }
}
