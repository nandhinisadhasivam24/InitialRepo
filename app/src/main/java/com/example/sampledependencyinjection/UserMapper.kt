package com.example.sampledependencyinjection

import javax.inject.Inject

object UserMapper {


    fun UserEntity.toModel(): UserModel {
        return UserModel(id = this.id, name = this.name, email = this.email)
    }

    fun UserModel.toEntity(): UserEntity {
        return UserEntity(id = this.id, name = this.name, email = this.email)
    }
}