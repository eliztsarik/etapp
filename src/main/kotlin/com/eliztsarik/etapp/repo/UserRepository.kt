package com.eliztsarik.etapp.repo

import com.eliztsarik.etapp.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByLogin(login: String): User?
}