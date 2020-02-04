package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.ThreadLocalRandom

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rnd = ThreadLocalRandom.current()

        val lst = List(1000) {
            ToDoItem(it, it.toString(), it.toString(), rnd.nextInt(0, 34560) % 2 == 0)
        }


        val adapter = RecyclerAdapter(lst)

        recyler_view.adapter = adapter

        recyler_view
            .addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
