package com.yzstu.filter;

import com.alibaba.fastjson.JSON;
import com.yzstu.comon.BaseContext;
import com.yzstu.comon.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //用于路径比较
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转类型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取本次请求的uri
        String uri = request.getRequestURI();
        log.info("拦截到请求:" + uri);

        //定义不需要处理的请求的路径
        String urls[] = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login",

        };
        //判断本次请求是否需要处理
        boolean check = check(urls, uri);
        //System.out.println(check);
        //不需要处理就直接放行
        if (check) {
            filterChain.doFilter(request, response);
            return;
        }
        //判断登录状态  如果登录 直接放行
        if (request.getSession().getAttribute("employee") != null) {
            //利用basacontext 工具类 传入id 方便后面使用
            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(request, response);
            return;
        }
        //判断移动端的用户是否登录
        if (request.getSession().getAttribute("user") != null) {
            //利用basacontext 工具类 传入id 方便后面使用
            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request, response);
            return;
        }
        //如果未登录 则返回未登录结果
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    //用户判断是否需要拦截
    public boolean check(String[] urls, String url) {
        for (String s : urls) {
           /* System.out.println("urls:"+s);
            System.out.println("url"+url);*/
            boolean match = PATH_MATCHER.match(s, url);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
