package com.usuario.reporteCrediticio.infrastructure.configRestemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ConfiguracionRestemplate {
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

}
