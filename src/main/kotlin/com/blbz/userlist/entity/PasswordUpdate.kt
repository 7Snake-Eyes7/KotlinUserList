package com.bridgelabz.fundoo_notes.Entity

import lombok.Data

@Data
class PasswordUpdate {
    var email: String? = null
    var newPassword: String? = null
    var confirmPassword: String? = null
}