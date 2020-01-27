package com.blbz.userlist.repository

import com.blbz.userlist.entity.UserInformation

interface IUserRepository {
    open fun save(userInformation: UserInformation?): UserInformation?
    open fun getUser(email: String?): UserInformation?
    open fun verify(id: Long?): Boolean
//    open fun upDate(information: PasswordUpdate?, token: Long?): Boolean
    open fun getUserById(id: Long?): UserInformation?
    open fun getUsers(): MutableList<UserInformation?>?
}