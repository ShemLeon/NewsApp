package com.leoevg.mihnewsapp.di

import com.leoevg.mihnewsapp.data.repository.AuthRepository
import com.leoevg.mihnewsapp.domain.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAuthRepository(userDao: UserDao): AuthRepository {
        return AuthRepository(userDao)
    }

}