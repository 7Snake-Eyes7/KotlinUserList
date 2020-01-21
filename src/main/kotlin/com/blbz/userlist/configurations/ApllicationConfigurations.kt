package com.blbz.userlist.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import springfox.documentation.swagger2.mappers.ModelMapper


@Configuration
class ApplicationConfigurations {
    @get:Bean
    val passwordEncryption: BCryptPasswordEncoder
        get() = BCryptPasswordEncoder()

}