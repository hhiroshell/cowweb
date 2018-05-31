package jp.gr.java_conf.cowweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAccessLogInterceptor());
        registry.addInterceptor(getAccessCounterInterceptor())
                .excludePathPatterns("/cowsay/ping");
    }

    @Bean
    AccessLogInterceptor getAccessLogInterceptor() {
        return new AccessLogInterceptor();
    }

    @Bean
    AccessCounterInterceptor getAccessCounterInterceptor() {
        return new AccessCounterInterceptor();
    }
}
