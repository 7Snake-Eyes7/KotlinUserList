package com.blbz.userlist.controller

import com.blbz.userlist.entity.LoginInformation
import com.blbz.userlist.entity.UserDto
import com.blbz.userlist.response.Response
import com.blbz.userlist.response.UsersDetail
import com.blbz.userlist.service.Services
import com.blbz.userlist.util.JwtGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CachePut
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class UserController {
    @Autowired
    private val service: Services? = null
    @Autowired
    private val generate: JwtGenerator? = null

    @PostMapping("/user/registration")
    @CachePut(value = ["user"], key = "#token") //	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    fun registration(@RequestBody information: UserDto?): ResponseEntity<Response?>? {
        val result = service!!.register(information)
        return if (result) {
            ResponseEntity.status(HttpStatus.CREATED)
                    .body(Response("registration successfull", 200, information))
        } else {
            ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                    .body(Response("user already exist", 400, information))
        }
    }

    @PostMapping("/user/login")
    fun login(@RequestBody information: LoginInformation?): ResponseEntity<UsersDetail?>? {
        val userInformation = service!!.login(information)
        println("inside login controller")
        return if (userInformation != null) {
            val token = generate!!.jwtToken(userInformation.userId)
            ResponseEntity.status(HttpStatus.ACCEPTED).header("login successfull", information!!.getUsername())
                    .body(UsersDetail(token, 200, information))
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(UsersDetail("Login failed", 400, information))
        }
    }

    @GetMapping("/user/verify/{token}")
    @Throws(Exception::class)
    fun userVerification(@PathVariable("token") token: String?): ResponseEntity<Response?>? {
        println("token for verification$token")
        val update = service!!.verify(token)
        return if (update) {
            ResponseEntity.status(HttpStatus.ACCEPTED).body(Response("verified", 200))
        } else {
            ResponseEntity.status(HttpStatus.ACCEPTED).body(Response("not verified", 400))
        }
    }

//    @PostMapping("user/forgotpassword")
//    fun forgogPassword(@RequestParam("email") email: String?): ResponseEntity<Response?>? {
//        println(email)
//        val result = service!!.isUserExist(email)
//        return if (result) {
//            ResponseEntity.status(HttpStatus.ACCEPTED).body(Response("user exist", 200))
//        } else {
//            ResponseEntity.status(HttpStatus.ACCEPTED).body(Response("user does not exist with given email id", 400))
//        }
//    }

//    @PutMapping("user/update/{token}")
//    fun update(@PathVariable("token") token: String?, @RequestBody update: PasswordUpdate?): ResponseEntity<Response?>? {
//        println("inside controller  " + update.getConfirmPassword())
//        println("inside controller  $token")
//        val result = service!!.update(update, token)
//        return if (result) {
//            ResponseEntity.status(HttpStatus.ACCEPTED)
//                    .body(Response("password updated successfully", 200, update))
//        } else {
//            ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Response("password doesn't match", 401, update))
//        }
//    }

}