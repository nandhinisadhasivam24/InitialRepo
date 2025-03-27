package com.example.sampledependencyinjection

import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<UserModel>
}