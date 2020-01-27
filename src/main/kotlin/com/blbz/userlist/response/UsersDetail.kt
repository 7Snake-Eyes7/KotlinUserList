package com.blbz.userlist.response

import lombok.Data

@Data
class UsersDetail(private val token: String?, private val statuscode: Int, private val obj: Any?)