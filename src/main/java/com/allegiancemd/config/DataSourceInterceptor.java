package com.allegiancemd.config;

import com.allegiancemd.constant.DatabaseEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DataSourceInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String branch = request.getHeader("database");
        if (DatabaseEnum.ALLEGIANCEMD1.toString().equalsIgnoreCase(branch))
            DatabaseContextHolder.setDatabaseContext(DatabaseEnum.ALLEGIANCEMD1);
        else
            DatabaseContextHolder.setDatabaseContext(DatabaseEnum.ALLEGIANCEMD2);
        return super.preHandle(request, response, handler);
    }
}
