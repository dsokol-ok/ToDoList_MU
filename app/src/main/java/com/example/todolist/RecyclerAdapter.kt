package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class ToDoItem(
    val id: Int,
    val header: String,
    val subHeader: String,
    val isCompleted: Boolean
)

class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val header: TextView = view.findViewById(R.id.title_text_view)
    private val subtitle: TextView = view.findViewById(R.id.subtitle)
    private val checkBox: CheckBox = view.findViewById(R.id.checkBox)

    private lateinit var toDoItem: ToDoItem

    fun bind(item: ToDoItem) {
        toDoItem = item

        header.text = toDoItem.header
        subtitle.text = toDoItem.subHeader
        checkBox.isChecked = toDoItem.isCompleted
    }
}

class RecyclerAdapter(private val items: List<ToDoItem>) : RecyclerView.Adapter<TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.list_tile, parent, false)

        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(items[position])
    }

}