package com.isaquliyev.movieapp1508.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.isaquliyev.movieapp1508.model.User
import com.isaquliyev.movieapp1508.network.FirebaseNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SigninSignupViewModel : ViewModel() {
    private var operationMessage = MutableLiveData<String>()

    fun checkExistenceOfUser() {
        CoroutineScope(Dispatchers.IO).launch {
            FirebaseNetwork.databaseReference.child("User")
                .child(FirebaseNetwork.auth.currentUser?.uid.toString()).orderByChild("email")
                .equalTo(
                    FirebaseNetwork.auth.currentUser?.email.toString()
                ).addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (!snapshot.exists()) {
                        FirebaseNetwork.databaseReference.child("User")
                            .child(FirebaseNetwork.auth.currentUser?.uid.toString()).setValue(
                            User(
                                FirebaseNetwork.auth.currentUser?.displayName.toString(),
                                FirebaseNetwork.auth.currentUser?.photoUrl.toString(),
                                FirebaseNetwork.auth.currentUser?.uid.toString(),
                                FirebaseNetwork.auth.currentUser?.email.toString(),
                            )
                        )
                    }
                    operationMessage.postValue("Signed in")
                }

                override fun onCancelled(error: DatabaseError) {
                }
            })
        }
    }

    fun observeOperationMessage(): LiveData<String> {
        return operationMessage
    }

}