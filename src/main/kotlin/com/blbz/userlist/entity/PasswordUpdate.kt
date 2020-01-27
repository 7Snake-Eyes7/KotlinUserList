package com.blbz.userlist.entity

import lombok.Data

@Data
class PasswordUpdate {
    var email: String? = null
    var newPassword: String? = null
    var confirmPassword: String? = null
}