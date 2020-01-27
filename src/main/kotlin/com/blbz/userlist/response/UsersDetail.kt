package com.bridgelabz.fundoo_notes.responses

import lombok.Data

@Data
class UsersDetail(private val token: String?, private val statuscode: Int, private val obj: Any?)