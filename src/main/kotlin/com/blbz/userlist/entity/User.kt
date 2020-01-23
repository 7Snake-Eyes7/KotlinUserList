package com.blbz.userlist.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class User (

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	open var id:Long = 0,

	open var name:String = "",

	open var email:String = "",

	open var mobileNumber:Long = 0,

	open var password:String = ""

) {
	fun setPassword(epassword: String?): String? {
		return epassword
	}
}