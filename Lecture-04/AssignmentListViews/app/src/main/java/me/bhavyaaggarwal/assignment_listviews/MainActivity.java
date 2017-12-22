package me.bhavyaaggarwal.assignment_listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import me.bhavyaaggarwal.assignment_listviews.models.Todo;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btnAdd;
    ListView lvTodos;

    ArrayList<Todo> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btnAdd = findViewById(R.id.btnAdd);
        lvTodos = findViewById(R.id.lvTodos);

        lvTodos = findViewById(R.id.lvTodos);
        final TodoAdapter todoAdapter = new TodoAdapter();
        lvTodos.setAdapter(todoAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todos.add(new Todo(etInput.getText().toString(), false));
                todoAdapter.notifyDataSetChanged();
            }
        });


    }

    public class TodoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return todos.size();
        }

        @Override
        public Todo getItem(int position) {
            return todos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();
            View itemView = li.inflate(R.layout.list_item_todo_details, parent, false);

            TextView tvTask = itemView.findViewById(R.id.tvTask);
            CheckBox cbDone = itemView.findViewById(R.id.cbDone);

            cbDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Todo todo = todos.get(position);

                    todo.setDone(isChecked);
                    todos.set(position, todo);


                    Log.d("STRING", "onCheckedChanged: " + todos.get(0).getDone());
                }
            });

            Todo todo = getItem(position);

            tvTask.setText(todo.getTask());
            cbDone.setChecked(todo.getDone());

            return itemView;
        }
    }
}
