package com.agudelo.configserver.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="microserviciocliente")
@org.springframework.context.annotation.Configuration
public class Config {
	 private String value;

	    public String getValue() {
	        return value;
	    }

	    public void setValue(String value) {
	        this.value = value;
	    }
	
	

}
