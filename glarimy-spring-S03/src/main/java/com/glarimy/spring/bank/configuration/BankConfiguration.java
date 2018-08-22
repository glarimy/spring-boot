package com.glarimy.spring.bank.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.glarimy.spring.bank" })
@EnableAspectJAutoProxy
public class BankConfiguration {
}
