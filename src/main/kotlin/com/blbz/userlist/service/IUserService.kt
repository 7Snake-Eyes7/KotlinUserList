package com.blbz.userlist.service

import com.blbz.userlist.entity.LoginDto
import com.blbz.userlist.entity.PasswordUpdateDto
import com.blbz.userlist.entity.RegistrationDto
import com.blbz.userlist.entity.User
import org.springframework.stereotype.Service

@Service
interface IUserService {

    fun login(info: LoginDto): User

    fun register(info: RegistrationDto): User

    fun verify(token: String): Boolean

    fun isUserExist(email: String): Boolean

    fun update(information: PasswordUpdateDto, token: String): User

    val users: List<User>

    fun getSingleUser(token: String): User

}