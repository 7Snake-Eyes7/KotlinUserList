package com.bridgelabz.fundoo_notes.responses

import org.springframework.stereotype.Component
@Component
class MailResponse {
    fun formMessage(url: String?, token: String?): String? {
        return "$url/$token"
    }
}