package com.blbz.userlist.service

import com.blbz.userlist.entity.LoginDto
import com.blbz.userlist.entity.PasswordUpdateDto
import com.blbz.userlist.entity.RegistrationDto
import com.blbz.userlist.entity.User
import org.springframework.stereotype.Service

@Service
interface IUserService {

    fun register(info: RegistrationDto): User

}