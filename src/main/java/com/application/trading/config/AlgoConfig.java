package com.application.trading.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.application.trading.algo.Algo;

@Configuration
public class AlgoConfig {
	/**
     * bean invokes to call the Algo as it will be a 3rd party lib
     */
    @Bean
    Algo algo() {
        return new Algo();
    }

}
