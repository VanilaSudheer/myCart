package com.shoppingcart.OrderService.config;

import com.shoppingcart.OrderService.external.decoder.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig  {
    @Bean
    ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }

}
