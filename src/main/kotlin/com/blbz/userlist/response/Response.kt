package com.blbz.userlist.response

import lombok.Data
import lombok.Getter


@Data
open class Response {
    private var message: String
    private var statusCode: Int
    private var obj: Any? = null
    var details: List<String>? = null

    constructor(message: String, statusCode: Int) {
        this.message = message
        this.statusCode = statusCode
    }

    constructor(message: String, statusCode: Int, obj: Any?) {
        this.message = message
        this.statusCode = statusCode
        this.obj = obj
    }
}