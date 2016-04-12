/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruz.sec.config;

/**
 *
 * @author SIGSA
 */
import org.springframework.security.core.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class ItemIdBasedAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    
    private String defaultTargetUrl;

    public ItemIdBasedAuthenticationSuccessHandler(){}

    @Override
    public void setDefaultTargetUrl(String defaultTargetUrl){
        this.defaultTargetUrl = defaultTargetUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User)authentication.getPrincipal();
//        request.getSession().setAttribute("TOOLS", obtenerHerrDptosByUser.getDptoByUsername(user.getUsername()));
//        for (Iterator iterator = user.getAuthorities().iterator(); iterator.hasNext();) {
//            String autority = iterator.next().toString();
            //Obtengo el contexto de la dirección IP y la agrego al objeto session
//            request.getSession().setAttribute("ENVIRONMENT", request.getParameter("environment"));
//            if(autority.equalsIgnoreCase("ROLE_COORDINADOR") || autority.equalsIgnoreCase("ROLE_TECNICO")){
                //Agrego el número de mensajes nos leídos a un atributo sesión.
//                String rol = (autority.equalsIgnoreCase("ROLE_COORDINADOR")? "ROLE_COORDINADOR": "ROLE_TECNICO");
//                request.getSession().setAttribute("NUM_MSJ_N_L", mensajesBandejaDaoImp.getMensajesNoLeidosUser(user.getUsername(), rol));
//                break;
//            }
//        }
        super.onAuthenticationSuccess(request, response, authentication);
//            String redirectUrl = request.getContextPath() + "/";
            System.out.println("-----------------------------INICIO DE SESI�N EXITOSO-----------------------------");
//            System.out.println("información: " + authentication.getDetails().toString());
//            response.sendRedirect(redirectUrl);
    }
}