package com.example.gamebase.data.repositories

import com.example.gamebase.R
import com.example.gamebase.data.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

class DataBaseConnection {
    private val db = Firebase.firestore

    fun getUser(id: String): User?{
        val docRef = db.collection("users").document(id)
        var user: User? = null
        docRef.get().addOnSuccessListener { documentSnapshot ->
             user = documentSnapshot.toObject<User>()
        }
        return user
    }

    fun createUser(id: String, user: User): Int{
        val userCheck = getUser(id)
        if(userCheck == null){
            db.collection("users").document(id).set(user)
            return R.string.userCreated
        }else{
            return R.string.userAlreadyExists
        }
    }

    fun updateGamesToPlay(id: String, gamesToPlay: ArrayList<Int>){
        val user = db.collection("users").document(id)
        user.update("gamesToPlay", gamesToPlay)
    }

    fun updatePlayedGames(id: String, playedGames: ArrayList<Int>){
        val user = db.collection("users").document(id)
        user.update("playedGames", playedGames)
    }

    fun updateUserName(id: String, userName: ArrayList<Int>){
        val user = db.collection("users").document(id)
        user.update("userName", userName)
    }

    fun deleteUser(id: String){
        db.collection("users").document(id).delete()
    }
}