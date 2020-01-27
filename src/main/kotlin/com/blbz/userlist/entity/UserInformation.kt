package com.blbz.userlist.entity

import lombok.Data
import java.time.LocalDateTime
import javax.persistence.*

@Data
@Entity
@Table(name = "userlist")
data class UserInformation (@Id
                       @GeneratedValue(strategy = GenerationType.AUTO)
                       val userId: Long = 0,
                       private val name: String? = null,
                       private val email: String? = null,
                       private val password: String? = null,
                       private val mobileNumber: Long? = null,
                       private val createdDate: LocalDateTime? = null,
                       val isVerified: Boolean = false) {
    fun setCreatedDate(now: LocalDateTime?): LocalDateTime? {
        return createdDate
    }

    fun setPassword(epassword: String?): String? {
        return epassword
    }

    fun setVerified(b: Boolean): Boolean {
        return b
    }

    fun getUserId(): Any? {
        return userId
    }

    fun getPassword(): String? {
        return password
    }
}