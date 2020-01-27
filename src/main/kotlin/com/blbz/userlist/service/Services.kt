package com.bridgelabz.fundoo_notes.services

import com.bridgelabz.fundoo_notes.Entity.LoginInformation
import com.bridgelabz.fundoo_notes.Entity.UserDto
import com.bridgelabz.fundoo_notes.Entity.UserInformation


interface Services {
    open fun login(information: LoginInformation?): UserInformation?
    open fun register(information: UserDto?): Boolean
    @Throws(Exception::class)
    open fun verify(token: String?): Boolean

//    open fun isUserExist(email: String?): Boolean
//    open fun update(information: PasswordUpdate?, token: String?): Boolean

}