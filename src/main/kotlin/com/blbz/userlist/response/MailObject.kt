package com.bridgelabz.fundoo_notes.responses

import lombok.Data
import org.springframework.stereotype.Component
import java.io.Serializable

@Data
@Component
class MailObject : Serializable {
    fun setEmail(email: String?): String? {
        return email
    }

    fun setMessage(mailResponse: String?): String? {
        return mailResponse
    }

    fun setSubject(message: String): String? {
        return message
    }

    fun getEmail(): String? {
        return email
    }

    fun getSubject(): String? {
        return subject
    }

    fun getMessage(): String? {
        return message
    }

    private var email: String? = null
    private var subject: String? = null
    private var message: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}