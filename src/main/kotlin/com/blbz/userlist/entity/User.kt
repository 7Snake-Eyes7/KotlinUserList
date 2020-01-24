package com.blbz.userlist.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class User (

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	open val id:Long = 0,

	open val name:String = "",

	open val email:String = "",

	open val mobileNumber:Long = 0,

	open val password:String = ""

) {
	fun setPassword(epassword: String?): String? {
		return epassword
	}
}