package com.blbz.userlist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class UserListApplication

fun main(args: Array<String>) {
	runApplication<UserListApplication>(*args)
}
