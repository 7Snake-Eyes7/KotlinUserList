package com.blbz.userlist.entity

import lombok.Data
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Data
open class User {
	open fun setPassword(epassword: String?): String {
		return password
	}

	open fun setVerified(b: Boolean): Boolean {
		return true
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	open var id:Long = 0

	open var name:String = ""

	open var email:String = ""

	open var mobileNumber:Long = 0

	open var isVerified:Boolean = false

	open var password:String = ""

}