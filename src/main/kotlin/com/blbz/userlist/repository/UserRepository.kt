package com.blbz.userlist.repository

import com.blbz.userlist.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository : CrudRepository<User, Long> {

    fun findByEmail(email: String): User


}