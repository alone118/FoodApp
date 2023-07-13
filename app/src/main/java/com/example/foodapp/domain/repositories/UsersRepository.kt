package com.example.foodapp.domain.repositories

import com.example.foodapp.domain.models.User

interface UsersRepository {

    fun fetchCurrentUser(): User

}