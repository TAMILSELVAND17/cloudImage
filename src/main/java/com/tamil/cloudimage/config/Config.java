package com.tamil.cloudimage.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
//@ConfigurationProperties(prefix = "cloudinary")
public class Config {
    @Value("${cloudinary.cloud-name}")
    private  String cloudName;

    @Value("${cloudinary.api-key}")
    private  String apiKey;

    @Value("${cloudinary.api-secret}")
    private  String apiSecret;

    @Bean(name = "cloudinary")
    public Cloudinary cloudinary(){
        if (cloudName == null || apiKey == null || apiSecret == null) {
            throw new IllegalStateException("Cloudinary configuration is incomplete: " +
                    "cloud_name=" + cloudName + ", api_key=" + apiKey + ", api_secret=" + (apiSecret == null ? "null" : "set"));
        }
        Map<String,String> config= ObjectUtils.asMap("cloud_name",cloudName,
                                                              "api_key",apiKey,
                                                               "api_secret",apiSecret);
                              return new Cloudinary(config);
    }

}
