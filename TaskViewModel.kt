package com.codsoft.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    private val repo: TaskRepository
    val tasks: LiveData<List<Task>>

    init {
        val db = AppDatabase.get(application)
        repo = TaskRepository(db.taskDao())
        tasks = repo.allTasks
    }

    fun addTask(task: Task) = viewModelScope.launch { repo.insert(task) }
    fun updateTask(task: Task) = viewModelScope.launch { repo.update(task) }
    fun deleteTask(task: Task) = viewModelScope.launch { repo.delete(task) }
}
