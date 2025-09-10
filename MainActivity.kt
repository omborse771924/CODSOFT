package com.codsoft.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var vm: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        vm = ViewModelProvider(this).get(TaskViewModel::class.java)
        // Implement RecyclerView, adapter and dialogs as described in README.
    }
}
