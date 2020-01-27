package com.blbz.userlist.util

import com.blbz.userlist.response.MailObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

@Component
class MailServiceProvider {
    fun sendEmail(mailObject: MailObject): MailObject {
        return mailObject
    }

    companion object {
        @Autowired
        private val javaMailSender: JavaMailSender? = null

        fun sendEmail(toEmail: String?, subject: String?, body: String?) {
            val fromEmail = "blbzrak@gmail.com"
            val password = "plm12345#"
            val prop = Properties()
            prop["mail.smtp.auth"] = "true"
            prop["mail.smtp.starttls.enable"] = "true"
            prop["mail.smtp.host"] = "smtp.gmail.com"
            prop["mail.smtp.port"] = "587"
            val auth: Authenticator = object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication? {
                    return PasswordAuthentication(fromEmail, password)
                }
            }
            val session = Session.getInstance(prop, auth)
            send(session, fromEmail, toEmail, subject, body)
        }

        private fun send(session: Session?, fromEmail: String?, toEmail: String?, subject: String?, body: String?) {
            try {
                val message = MimeMessage(session)
                message.setFrom(InternetAddress(fromEmail, "rak"))
                message.setRecipient(Message.RecipientType.TO, InternetAddress(toEmail))
                message.setSubject(subject)
                message.setText(body)
                Transport.send(message)
            } catch (e: Exception) {
                println("exception occured while sending mail")
            }
        }
    }
}