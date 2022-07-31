package com.allegiancemd.config;

import com.allegiancemd.constant.DatabaseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class DataSourceInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        log.info(request.getRequestURI());

        String database = request.getHeader("database");
        log.info(database);
        if (DatabaseEnum.ALLEGIANCEMD1.toString().equalsIgnoreCase(database))
            DatabaseContextHolder.setDatabaseContext(DatabaseEnum.ALLEGIANCEMD1);
        else
            DatabaseContextHolder.setDatabaseContext(DatabaseEnum.ALLEGIANCEMD2);
        return super.preHandle(request, response, handler);
    }
}
