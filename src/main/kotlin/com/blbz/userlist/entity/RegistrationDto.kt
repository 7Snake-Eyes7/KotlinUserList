package com.blbz.userlist.entity

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class RegistrationDto (

    @get: NotBlank
    var name:String = "",

    @get: NotBlank
    var email:String = "",

    @get: NotEmpty
    var mobileNumber:Long = 0,

    @get: NotBlank
    var password:String = ""
) {
    fun getEmail(): Any {
        return email
    }

    fun getPassword(): CharSequence? {
        return password
    }
}