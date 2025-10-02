package com.bardan.mydog24crm.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "app.security")
@Getter
@Setter
public class SecurityProperties {

    private List<String> allowedEmails = new ArrayList<>();

}
