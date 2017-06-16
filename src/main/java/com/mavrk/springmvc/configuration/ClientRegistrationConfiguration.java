package com.mavrk.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Sanatt on 14-06-2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mavrk.springmvc")
public class ClientRegistrationConfiguration {

}
