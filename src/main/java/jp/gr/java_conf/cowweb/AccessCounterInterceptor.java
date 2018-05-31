package jp.gr.java_conf.cowweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class AccessCounterInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AccessCounter counter;

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        counter.increment();
        return true;
    }

}
