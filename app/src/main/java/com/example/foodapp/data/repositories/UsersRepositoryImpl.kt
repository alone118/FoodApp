package com.example.foodapp.data.repositories

import com.example.foodapp.domain.models.User
import com.example.foodapp.domain.repositories.UsersRepository

class UsersRepositoryImpl: UsersRepository {

    override fun fetchCurrentUser(): User {
        return User(
            id = "1",
            name = "Bayastan",
            lastname = "Abylkasymov",
            avatarUrl = "https://www.w3schools.com/howto/img_avatar.png"
        )
    }
}