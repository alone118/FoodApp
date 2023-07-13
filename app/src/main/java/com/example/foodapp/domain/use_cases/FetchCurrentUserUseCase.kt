package com.example.foodapp.domain.use_cases

import com.example.foodapp.domain.models.User
import com.example.foodapp.domain.repositories.UsersRepository

class FetchCurrentUserUseCase(
    private val repository: UsersRepository
) {
    operator fun invoke(): User {
        return repository.fetchCurrentUser()
    }
}