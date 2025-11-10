package com.leoevg.mihnewsapp.di

import android.content.Context
import androidx.room.Room
import com.leoevg.mihnewsapp.data.database.UserDatabase
import com.leoevg.mihnewsapp.domain.dao.UserDao
import com.leoevg.mihnewsapp.domain.entity.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase{
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "userDatabase.db"
        ).build()
    }


    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase): UserDao{
        return userDatabase.getUserDao()
    }
}