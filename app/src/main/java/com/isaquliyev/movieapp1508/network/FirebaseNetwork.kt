package com.isaquliyev.movieapp1508.network

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

object FirebaseNetwork {
    var databaseReference = FirebaseDatabase.getInstance().reference
    var auth = Firebase.auth
}