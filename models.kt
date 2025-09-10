package com.codsoft.attendance

data class User(val uid: String = "", val name: String = "", val email: String = "", val role: String = "student")
data class Course(val id: String = "", val name: String = "", val instructorId: String = "")
data class AttendanceRecord(val courseId: String = "", val studentId: String = "", val dateMillis: Long = 0L, val present: Boolean = true)
