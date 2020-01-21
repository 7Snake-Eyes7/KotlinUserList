package com.blbz.userlist.entity

import lombok.Data
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Data
class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id:Long = 0

	val name:String = ""

	val email:String = ""

	val mobileNumber:Long = 0

	val password:String = ""

	lateinit var createdTime: LocalDateTime

	lateinit var updateTime: LocalDateTime

}