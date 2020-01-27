package com.blbz.userlist.response

import org.springframework.stereotype.Component
@Component
class MailResponse {
    fun formMessage(url: String?, token: String?): String? {
        return "$url/$token"
    }
}