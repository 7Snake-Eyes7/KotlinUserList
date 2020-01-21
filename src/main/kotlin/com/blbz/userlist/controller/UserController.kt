package com.blbz.userlist.controller

import com.blbz.userlist.entity.RegistrationDto
import com.blbz.userlist.entity.User
import com.blbz.userlist.response.Response
import com.blbz.userlist.service.IUserService
import com.blbz.userlist.util.JwtGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class UserController {
    @Autowired
    private val service: IUserService? = null
    @Autowired
    private val generate: JwtGenerator? = null

    @PostMapping("/user/registration")
    @ResponseBody
    fun registration(@RequestBody information: RegistrationDto): ResponseEntity<Response> {
        val result: User = service!!.register(information)
        return if (result==null) {
            ResponseEntity.status(HttpStatus.CREATED)
                    .body<Response>(Response("registration successfull", 200, information))
        } else {
            ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                    .body<Response>(Response("user already exist", 400, information))
        }
    }
}