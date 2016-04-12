/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruz.sec.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

/**
 *
 * @author SIGSA
 */
public class ItemBasedAuthenticationFailureHandler implements AuthenticationFailureHandler {
        
    @Override
    public void onAuthenticationFailure(HttpServletRequest request , HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken)exception.getAuthentication();
        System.out.println("Mensaje del error: " + exception.getMessage());
//        PrincipalsessionInformaction user = request.getUserPrincipal();
        System.out.println("-----------------------------INTENTO FALLIDO-----------------------------");
        
        //Causas de la autenticación fallida
        if(exception.getClass().isAssignableFrom(UsernameNotFoundException.class)){
            System.out.println("INTENTO FALLIDO: El usuario no está registrado en la base de datos ");
            request.setAttribute("ERRORSESSION", "Usuario no registrado, verifique con el administrador");
            request.getRequestDispatcher("/login").forward(request, response);
            //response.sendRedirect("login?err=1");
        }
        else if(exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
            System.out.println("INTENTO FALLIDO: Creedenciales erroneas");
            request.setAttribute("ERRORSESSION", "Contraseña incorrecta, intente nuevamente");
            request.getRequestDispatcher("/login").forward(request, response);
        } else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
            System.out.println("INTENTO FALLIDO: Usuario desabilitado");
            request.setAttribute("ERRORSESSION", "Usuario deshabilitado, verifique con el administrador");
            request.getRequestDispatcher("/login").forward(request, response);
        }
        else if (exception.getClass().isAssignableFrom(SessionAuthenticationException.class)) {
            System.out.println("INTENTO FALLIDO: Usuario ya logeado");
            request.setAttribute("ERRORSESSION", "Ya existe una sesi&oacute;n abierta con este usuario");
            request.getRequestDispatcher("/login").forward(request, response);
        }
        else{
            System.out.println("INTENTO FALLIDO: NO SE QUE PASO");
            request.setAttribute("ERRORSESSION", "No ha sido posible iniciar sesi&oacute;n");
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }
    
}
