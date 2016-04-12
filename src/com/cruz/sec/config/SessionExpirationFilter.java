/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruz.sec.config;

//import com.sigsa.sisbc.classes.RequestNodeJS;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

/**
 *
 * @author Abel
 */
public class SessionExpirationFilter implements ApplicationListener<HttpSessionDestroyedEvent>{
    
//    private RequestNodeJS requestNodeJS;
    
    public SessionExpirationFilter(){}

//    public void setRequestNodeJS(RequestNodeJS requestNodeJS) {
//        this.requestNodeJS = requestNodeJS;
//    }

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent event) {
        List<org.springframework.security.core.context.SecurityContext> lstSecurityContext = event.getSecurityContexts();
        UserDetails ud;
        for (org.springframework.security.core.context.SecurityContext securityContext : lstSecurityContext){
            ud = (UserDetails) securityContext.getAuthentication().getPrincipal();
            System.out.println("OBJECTO SESION DESTRUIDO: "+ud.toString());
            
            HttpSession httpSession = event.getSession();
//            long createdTime = httpSession.getCreationTime();
            long lastAccessedTime = httpSession.getLastAccessedTime();
            int maxInactiveTime = httpSession.getMaxInactiveInterval();
            long currentTime = System.currentTimeMillis();

//            System.out.println("Session Id :"+httpSession.getId() );
//            System.out.println("Created Time : " + createdTime);
//            System.out.println("Last Accessed Time : " + lastAccessedTime);
//            System.out.println("Current Time : " + currentTime);
            boolean possibleSessionTimeout = (currentTime-lastAccessedTime) >= (maxInactiveTime*1000);
            if(possibleSessionTimeout){
            	System.out.println("SESI”N CERRADA POR INACTIVIDAD");
                //Se realiza la petici√≥n al Node JS
//                requestNodeJS.sendRequestWithUsernameAndMethod(ud.getUsername(), "/session-close");
            }
        }
    }
    
}
