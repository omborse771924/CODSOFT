package com.codsoft.attendance

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

fun registerUser(name: String, email: String, password: String, role: String) {
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()
    auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener { res ->
        val uid = res.user!!.uid
        val user = User(uid, name, email, role)
        db.collection("users").document(uid).set(user)
    }
}
