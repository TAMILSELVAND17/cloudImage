package com.tamil.cloudimage;

import com.tamil.cloudimage.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@EnableConfigurationProperties(Config.class)
public class CloudImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudImageApplication.class, args);
	}

}
