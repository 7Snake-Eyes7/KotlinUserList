package com.blbz.userlist.service

import com.blbz.userlist.entity.LoginInformation
import com.blbz.userlist.entity.UserDto
import com.blbz.userlist.entity.UserInformation


interface Services {
    open fun login(information: LoginInformation?): UserInformation?
    open fun register(information: UserDto?): Boolean
    @Throws(Exception::class)
    open fun verify(token: String?): Boolean

//    open fun isUserExist(email: String?): Boolean
//    open fun update(information: PasswordUpdate?, token: String?): Boolean

}