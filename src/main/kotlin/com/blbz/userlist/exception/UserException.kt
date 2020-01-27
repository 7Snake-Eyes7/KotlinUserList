package com.bridgelabz.fundoo_notes.exception

import lombok.Getter

@Getter
class UserException(override val message: String?) : RuntimeException(message) {

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }

}