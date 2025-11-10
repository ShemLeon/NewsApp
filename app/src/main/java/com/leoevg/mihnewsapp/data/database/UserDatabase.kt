package com.leoevg.mihnewsapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leoevg.mihnewsapp.domain.dao.UserDao
import com.leoevg.mihnewsapp.domain.entity.User

@Database(entities=[User::class],version=1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}