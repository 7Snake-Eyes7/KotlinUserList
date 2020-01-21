package com.blbz.userlist.entity

import javax.validation.constraints.NotBlank

class PasswordUpdateDto {

    @get: NotBlank
    val email:String = ""

    @get: NotBlank
    val password:String = ""

    @get: NotBlank
    val confirmPassword:String =""
}