package com.bridgelabz.fundoo_notes.services

import com.bridgelabz.fundoo_notes.Entity.LoginInformation
import com.bridgelabz.fundoo_notes.Entity.UserDto
import com.bridgelabz.fundoo_notes.Entity.UserInformation
import com.bridgelabz.fundoo_notes.configurations.RabbitMQSender
import com.bridgelabz.fundoo_notes.exception.UserException
import com.bridgelabz.fundoo_notes.reddisrepository.RedisRepository
import com.bridgelabz.fundoo_notes.repository.IUserRepository
import com.bridgelabz.fundoo_notes.responses.MailObject
import com.bridgelabz.fundoo_notes.responses.MailResponse
import com.bridgelabz.fundoo_notes.util.JwtGenerator
import com.bridgelabz.fundoo_notes.util.MailServiceProvider
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class ServiceImplementation : Services {
    private var userInformation: UserInformation? = UserInformation()
    @Autowired
    private val repository: IUserRepository? = null
    @Autowired
    private val encryption: BCryptPasswordEncoder? = null
    @Autowired
    private val generate: JwtGenerator? = null
    @Autowired
    private val response: MailResponse? = null
    @Autowired
    private val mailObject: MailObject? = null
    @Autowired
    private val modelMapper: ModelMapper? = null
    @Autowired
    private val rabbitMQSender: RabbitMQSender? = null
    @Autowired
    private val reddisRepository: RedisRepository? = null

    @Transactional
    override fun register(information: UserDto?): Boolean {
        println("inside service")
        val user: UserInformation? = repository!!.getUser(information!!.getEmail())
        return if (user == null) {
            userInformation = modelMapper!!.map<UserInformation?>(information, UserInformation::class.java)
            //			BeanUtils.copyProperties(information, UserInformation.class);
            userInformation!!.setCreatedDate(LocalDateTime.now())
            val epassword = encryption!!.encode(information.getPassword())
            userInformation!!.setPassword(epassword)
            userInformation!!.setVerified(false)
            userInformation = repository!!.save(userInformation)
            //			reddisRepository.save(userInformation);
            println("id" + " " + userInformation!!.getUserId())
            println("token" + " " + generate!!.jwtToken(userInformation!!.getUserId() as Long))
            val mailResponse: String? = response!!.formMessage("http://localhost:3000/verify",
                    generate.jwtToken(userInformation!!.getUserId() as Long))
            println(mailResponse)
            mailObject!!.setEmail(information.getEmail())
            mailObject!!.setMessage(mailResponse)
            mailObject!!.setSubject("verification")
            rabbitMQSender!!.send(mailObject)
            true
        } else {
            throw UserException("user already exist with the same mail id")
        }
    }

    @Transactional
    override fun login(information: LoginInformation?): UserInformation? {
        val user: UserInformation? = repository!!.getUser(information!!.getUsername())
        println("inside service $user")
        return if (user != null) {
            if (user.isVerified && encryption!!.matches(information.getPassword(), user.getPassword())) {
                println(generate!!.jwtToken(user.getUserId() as Long))
                user
            } else {
                val mailResponse: String? = response!!.formMessage("http://localhost:3000/verify",
                        generate!!.jwtToken(user.getUserId() as Long))
                MailServiceProvider.Companion.sendEmail(information.getUsername(), "verification", mailResponse)
                null
            }
        } else {
            null
        }
    }

//    @Transactional
//    override fun update(information: Any?, token: String?): Boolean {
//        return if (information.getNewPassword() == information.getConfirmPassword()) {
//            var id: Long? = null
//            try {
//                println("in update method" + "   " + generate!!.parseJWT(token))
//                id = generate!!.parseJWT(token) as Long
//                val epassword = encryption!!.encode(information.getConfirmPassword())
//                information.setConfirmPassword(epassword)
//                repository!!.upDate(information, id)
//            } catch (e: Exception) {
//                throw UserException("invalid credentials")
//            }
//        } else {
//            throw UserException("invalid password")
//        }
//    }
//
//    fun generateToken(id: Long?): String? {
//        return id?.let { generate!!.jwtToken(it) }
//    }
//
    @Transactional
    @Throws(Exception::class)
    override fun verify(token: String?): Boolean {
        println("id in verification" + generate!!.parseJWT(token) as Long)
        val id = generate!!.parseJWT(token) as Long
        repository!!.verify(id)
        return true
    }
//
//    override fun isUserExist(email: String?): Boolean {
//        return try {
//            val user: UserInformation? = repository!!.getUser(email)
//            if (user!!.isVerified) {
//                val mailResponse: String? = response!!.formMessage("http://localhost:3000/updatePassword",
//                        generate!!.jwtToken(user.getUserId()))
//                MailServiceProvider.Companion.sendEmail(user.getEmail(), "verification", mailResponse)
//                true
//            } else {
//                false
//            }
//        } catch (e: Exception) {
//            throw UserException("User doesn't exist")
//        }
//    }
}