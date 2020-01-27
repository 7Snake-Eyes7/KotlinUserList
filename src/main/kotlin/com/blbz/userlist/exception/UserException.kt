package com.blbz.userlist.exception

data class UserException(override val message: String?) : RuntimeException(message) {

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }

}