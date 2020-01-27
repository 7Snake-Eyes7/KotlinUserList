package com.blbz.userlist.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
open class ApplicationConfigurations {
    @get:Bean
    val passwordEncryption: BCryptPasswordEncoder
        get() = BCryptPasswordEncoder()

}