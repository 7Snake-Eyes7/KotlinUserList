package com.blbz.userlist.entity

import lombok.Data
import org.springframework.stereotype.Component

@Data
@Component
data class UserDto(private var name: String? = null,

        private var email: String? = null,

        private var password: String? = null,

        private var mobileNumber: Long? = null) {
    fun getEmail(): String? {
        return email

    }

    fun getPassword(): CharSequence? {
        return password
    }
}