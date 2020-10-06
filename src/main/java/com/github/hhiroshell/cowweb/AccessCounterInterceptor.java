package com.github.hhiroshell.cowweb;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class AccessCounterInterceptor extends HandlerInterceptorAdapter {

    private final Counter accessCounter;

    AccessCounterInterceptor(MeterRegistry meterRegistry) {
        super();
        accessCounter = meterRegistry.counter("com.github.cowweb.metrics.accessCounter");
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        accessCounter.increment();
        return true;
    }
}
