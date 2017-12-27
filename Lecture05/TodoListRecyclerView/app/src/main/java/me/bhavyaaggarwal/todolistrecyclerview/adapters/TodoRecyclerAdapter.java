package me.bhavyaaggarwal.todolistrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.bhavyaaggarwal.todolistrecyclerview.R;
import me.bhavyaaggarwal.todolistrecyclerview.models.Todo;

/**
 * Created by bhavyaaggarwal on 27/12/17.
 */

public class TodoRecyclerAdapter extends RecyclerView.Adapter<TodoRecyclerAdapter.TodoViewHolder> {
    private Context context;
    private ArrayList<Todo> todos;

    public TodoRecyclerAdapter(Context context) {
        this.context = context;
        this.todos = new ArrayList<>();
    }

    public void addTodo(Todo todo) {
        this.todos.add(todo);
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_todo_item, parent, false);

        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, final int position) {
        Todo todo = todos.get(position);

        holder.tvTask.setText(todo.getTask());
        holder.cbDone.setChecked(todo.isDone());

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todos.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTask;
        CheckBox cbDone;
        ImageView ivDelete;

        public TodoViewHolder(View itemView) {
            super(itemView);
            tvTask = itemView.findViewById(R.id.tvTask);
            cbDone = itemView.findViewById(R.id.cbDone);
            ivDelete = itemView.findViewById(R.id.ivDelete);
        }
    }
}
