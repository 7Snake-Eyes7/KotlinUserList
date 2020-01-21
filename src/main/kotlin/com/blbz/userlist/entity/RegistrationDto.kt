package com.blbz.userlist.entity

import lombok.Data
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Data
class RegistrationDto {

    @get: NotBlank
    var name:String = ""

    @get: NotBlank
    var email:String = ""

    @get: NotEmpty
    var mobileNumber:Long = 0

    @get: NotBlank
    var password:String = ""
}