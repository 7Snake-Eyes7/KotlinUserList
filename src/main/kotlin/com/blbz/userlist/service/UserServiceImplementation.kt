package com.blbz.userlist.service

import com.blbz.userlist.entity.RegistrationDto
import com.blbz.userlist.entity.User
import com.blbz.userlist.exception.UserException
import com.blbz.userlist.repository.IUserRepository
import com.blbz.userlist.util.JwtGenerator
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional as Transactional1


@Service
class UserServiceImplementation : IUserService {

    private val user = User()
    @Autowired
    private val repository: IUserRepository? = null
    @Autowired
    private val encryption: BCryptPasswordEncoder? = null
    @Autowired
    private val generate: JwtGenerator? = null

    @Transactional1
    override fun register(info: RegistrationDto): User {
        var user: User = repository!!.findByEmail(info.getEmail() as String)
        return if (user == null) {
            var userObj = User()
            BeanUtils.copyProperties(info, userObj)
            val epassword = encryption!!.encode(info.getPassword())
            userObj.setPassword(epassword)
            userObj = repository.save(user)
            return userObj
        } else {
            throw UserException("Email id already exists")
        }
    }
}