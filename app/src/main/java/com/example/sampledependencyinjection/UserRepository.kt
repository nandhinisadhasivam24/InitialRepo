package com.example.sampledependencyinjection

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.sampledependencyinjection.UserMapper.toEntity
import com.example.sampledependencyinjection.UserMapper.toModel
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService,
                                         private val userDao: UserDao,

) {
    suspend fun fetchUsersFromApi() {
        val users = apiService.getUsers().map {
           it.toEntity()
        }
        users.forEach {
            userDao.insertUser(it)
        }
    }
    fun getUsers(): LiveData<List<UserModel>> {
        return userDao.getUsers().map { users ->
            users.map { it.toModel() }
        }
    }

    }


