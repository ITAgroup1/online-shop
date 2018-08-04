package com.group1.admin.interceptor;

import com.group1.core.entity.admin.Admin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private List<String> exceptUrls;

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        if ( isExceptUrls(path) || admin != null) {
            return true;
        } else {
            response.sendRedirect("/login");
            return false;
        }

    }

    public boolean isExceptUrls(String path) {

        if (path == null || "".equals(path)) {
            return true;
        }
        for (String strUrl : this.exceptUrls) {
            if (path.startsWith(strUrl)) {
                return true;
            }
        }
        return false;
    }
}
