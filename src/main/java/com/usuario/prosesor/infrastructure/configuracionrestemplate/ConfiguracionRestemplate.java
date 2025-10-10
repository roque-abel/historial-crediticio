package com.usuario.prosesor.infrastructure.configuracionrestemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ConfiguracionRestemplate {
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
