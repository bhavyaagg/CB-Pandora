package me.bhavyaaggarwal.todolistkotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.list_item_todo_item.view.*
import me.bhavyaaggarwal.todolistkotlin.R
import me.bhavyaaggarwal.todolistkotlin.models.Todo

/**
 * Created by bhavyaaggarwal on 27/12/17.
 */
class TodoRecyclerAdapter(val context: Context, val todos: ArrayList<Todo> = ArrayList()) :
        RecyclerView.Adapter<TodoRecyclerAdapter.TodoViewHolder>() {

    override fun getItemCount(): Int {
        return todos.size;
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewHolder?, position: Int) {
        holder?.bindView(todos[position]);
        holder?.itemView!!.cbDone.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            todos[position].done = isChecked
        })
        holder?.itemView!!.ivDelete.setOnClickListener(View.OnClickListener {
            todos.removeAt(position)
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoViewHolder {
        val li: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
        val itemView = li.inflate(R.layout.list_item_todo_item, parent, false);
        return TodoViewHolder(itemView);
    }


    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(todo: Todo) {
            itemView.tvTask.text = todo.task
            itemView.cbDone.isChecked = todo.done
        }
    }
}