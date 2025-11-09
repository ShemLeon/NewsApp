package com.leoevg.mihnewsapp.data.repository

import com.leoevg.mihnewsapp.domain.dao.UserDao
import com.leoevg.mihnewsapp.domain.entity.User
import com.leoevg.mihnewsapp.util.util.Result
import javax.inject.Inject
import java.util.UUID

class AuthRepository @Inject constructor(
    private val userDao: UserDao
){
    suspend fun login(email: String, password: String): Result{
        val loginUser = userDao.login(email, password)
        val result = if (loginUser == null) Result.Failure<Unit>("Не залогинилось")
        else Result.Success<Unit>("Login прошел нормально")

        return result
    }

    suspend fun register(username: String, email: String, password: String): Result{
        if (userDao.getUserByEmail(email) !=null )
            return Result.Failure<Unit>("Пользователь с таким email уже существует")
        val user = User(
            id = UUID.randomUUID().toString(),
            username = username,
            email = email,
            password = password
        )
        userDao.addUser(user)
        return Result.Success<Unit>("Регистрация прошла успешно")
    }


}