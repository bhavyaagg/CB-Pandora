package me.bhavyaaggarwal.todowithdb.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import me.bhavyaaggarwal.todowithdb.R;
import me.bhavyaaggarwal.todowithdb.db.tables.TodoTable;
import me.bhavyaaggarwal.todowithdb.models.Todo;

/**
 * Created by bhavyaaggarwal on 07/01/18.
 */

public class TodoAdapter extends BaseAdapter {

    Context context;
    private ArrayList<Todo> todos;

    public TodoAdapter(Context context, ArrayList<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.list_item_todo, parent, false);
        }

        TextView tvTask = convertView.findViewById(R.id.tvtask);
        CheckBox cbDone = convertView.findViewById(R.id.cbDone);

        Todo todo = getItem(position);

        tvTask.setText(todo.getTask());
        cbDone.setChecked(todo.getDone());

        return convertView;
    }

    public void refreshTodos(SQLiteDatabase db) {
        this.todos = TodoTable.getAllTodos(db);
        notifyDataSetChanged();
    }
}
