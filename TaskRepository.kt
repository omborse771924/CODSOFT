package com.codsoft.todo

class TaskRepository(private val dao: TaskDao) {
    val allTasks = dao.getAll()
    suspend fun insert(t: Task) = dao.insert(t)
    suspend fun update(t: Task) = dao.update(t)
    suspend fun delete(t: Task) = dao.delete(t)
}
