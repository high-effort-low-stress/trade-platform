package com.github.hels.tradeplatform.onboarding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class BeanConfig {

    @Bean
    public Clock getClock(){
        return Clock.systemDefaultZone();
    }
}
