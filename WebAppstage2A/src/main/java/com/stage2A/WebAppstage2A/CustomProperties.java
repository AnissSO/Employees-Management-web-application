package com.stage2A.WebAppstage2A;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.stage2-a.web-appstage2-a")
public class CustomProperties {

	private String apiUrl;
	
}
