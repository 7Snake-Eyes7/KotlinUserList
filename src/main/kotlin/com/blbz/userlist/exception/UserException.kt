package com.blbz.userlist.exception

import lombok.Getter


@Getter
class UserException(override val message: String) : RuntimeException(message) {

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }

}