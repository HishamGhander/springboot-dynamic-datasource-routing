package com.allegiancemd.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "allegiancemd1.datasource")
public class AllegianceMdModel1 {
    private String url;
    private String password;
    private String username;
}
