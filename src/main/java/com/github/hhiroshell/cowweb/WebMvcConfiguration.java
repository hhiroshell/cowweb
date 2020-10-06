package com.github.hhiroshell.cowweb;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAccessCounterInterceptor())
                .excludePathPatterns("/cowsay/ping");
    }

    @Bean
    AccessCounterInterceptor getAccessCounterInterceptor() {
        return new AccessCounterInterceptor(meterRegistry);
    }

}
