package com.blbz.userlist.repository

import com.blbz.userlist.entity.User
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository {

    fun save(user: User): User

    fun getUser(email: String): User

    fun verify(id: Long?): Boolean

    fun getUserById(id: Long?): User

    val users: List<Any?>?
}