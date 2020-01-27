package com.blbz.userlist.entity

import lombok.Data

@Data
data class LoginInformation(private var username: String? = null,
                       private var password: String? = null) {
    fun getUsername(): String? {
        return username
    }

    fun getPassword(): CharSequence? {
        return password
    }
}