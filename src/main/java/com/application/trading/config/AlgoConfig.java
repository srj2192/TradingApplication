package com.application.trading.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.application.trading.algo.Algo;

@Configuration
public class AlgoConfig {

    @Bean
    Algo algo() {
        return new Algo();
    }

}
