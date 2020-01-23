package com.blbz.userlist.entity

import javax.validation.constraints.NotBlank

data class LoginDto (

    @get: NotBlank
    val email:String ="",

    @get: NotBlank
    val password:String=""
)