package com.github.hels.tradeplatform.onboarding.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "trade.platform.security")
public class SecurityConfig {
    private String publicKey;
    private String privateKey;
}
