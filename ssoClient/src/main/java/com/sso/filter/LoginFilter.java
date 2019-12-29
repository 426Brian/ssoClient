package com.sso.filter;

import com.sso.bean.URLInfo;
import com.sso.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Brian in 0:34 2018/12/12
 */
@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 1. 检查是否登录
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        Boolean isLogin = (Boolean) session.getAttribute("isLogin");
        if(isLogin!= null && isLogin){
            // 已经登录, 直接放行
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 退出直接放行
        if(request.getRequestURL().toString().contains("/tologout")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        // 2. 请求中是否有 token
        String token = request.getParameter("token");
        if(!StringUtils.isAllEmpty(token)){
            // token 有值, 需要校验
            HashMap<String, String> paramMap = new HashMap<>();
            paramMap.put("token", token);
            paramMap.put("clientUrl", URLInfo.getClientHostUrl());
            paramMap.put("jsessionid", session.getId());

            String isVerify = null;
            try {

                isVerify = HttpUtil.sendRequest(URLInfo.getSsoCenterUrl()+"/verify", paramMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if("true".equals(isVerify)){
                // token 有效
                session.setAttribute("isLogin",true);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

        }

        // 3. 重定向到注册中心查看是否其他系统登录过

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.sendRedirect(URLInfo.getSsoCenterUrl()+"/checkLogin?clientUrl="+request.getRequestURL());
    }

    @Override
    public void destroy() {

    }
}
