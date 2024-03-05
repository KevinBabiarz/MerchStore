package com.example.merchstore.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    public int expireAt = 86400; // 1 Day
    private String secretString = "poloteammmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm";

    private byte[] secretBytes = secretString.getBytes(StandardCharsets.UTF_8);
    public SecretKey secretKey = new SecretKeySpec(secretBytes, "HmacSHA512");

}
