/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.elinar.react.rest.interceptor;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * This piece of code should force Pragma no cache header
 * @author Mika Mähönen
 */
public class DisableBrowserCachingInterceptor extends HandlerInterceptorAdapter{
    private boolean cors=false;
    private final Logger log = LoggerFactory.getLogger(DisableBrowserCachingInterceptor.class);
    public DisableBrowserCachingInterceptor() {
 
    }

    public void setCors(boolean cors) {
        this.cors = cors;
    }
    

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0"); 
        response.setHeader("Pragma", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        if(cors) {
            activateCors(response);
        }
        log.info("---------------------------");
         Enumeration<String> enumeration  = request.getHeaderNames();
         while(enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            log.info("{} = {}",name,request.getHeaders(name).nextElement());
            }
        return super.preHandle(request, response, handler); 
    }

    private void activateCors(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
        
    }

}
