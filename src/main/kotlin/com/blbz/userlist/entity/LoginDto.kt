package com.blbz.userlist.entity

import lombok.Data
import javax.validation.constraints.NotBlank

@Data
class LoginDto {

    @get: NotBlank
    val email:String =""

    @get: NotBlank
    val password:String=""
}