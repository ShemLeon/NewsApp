package com.leoevg.mihnewsapp.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.leoevg.mihnewsapp.domain.entity.User

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Delete
    fun removeUser(user: User)

    @Query("SELECT * FROM user WHERE email = :email")
    fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun login(email: String, password: String): User?
}