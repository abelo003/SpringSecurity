/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruz.sec.config;

import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author SIGSA
 */
public class MyAuthenticationProvider implements AuthenticationProvider{
     
	private JdbcDaoImpl customJDBCDaoImpl;
    private ShaPasswordEncoder shaPasswordEncoder;
    private SaltSource saltSource;
    @Autowired
    private SessionRegistryImpl sessionRegistry;

    public SessionRegistryImpl getSessionRegistry() {
		return sessionRegistry;
	}

	public void setSessionRegistry(SessionRegistryImpl sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}

	public SaltSource getSaltSource() {
		return saltSource;
	}

	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}

	public ShaPasswordEncoder getShaPasswordEncoder() {
        return shaPasswordEncoder;
    }

    public void setShaPasswordEncoder(ShaPasswordEncoder shaPasswordEncoder) {
        this.shaPasswordEncoder = shaPasswordEncoder;
    }
    
    public JdbcDaoImpl getCustomJDBCDaoImpl() {
		return customJDBCDaoImpl;
	}

	public void setCustomJDBCDaoImpl(JdbcDaoImpl customJDBCDaoImpl) {
		this.customJDBCDaoImpl = customJDBCDaoImpl;
	}

	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("Entrando a la verificación del usuario");
		System.out.println("Nombre de usuario: " + authentication.getName());
        UserDetails userDetails = (UserDetails)this.customJDBCDaoImpl.loadUserByUsername(authentication.getName());
        if (userDetails.isEnabled()) {
        	Object salt = null;
        	if (this.saltSource != null) { 
        		salt = saltSource.getSalt(userDetails);
        	}
            if (shaPasswordEncoder.isPasswordValid(userDetails.getPassword(), authentication.getCredentials().toString(), salt)) {
            	//Verifico si el usuario ya tiene una sesión abierta, si es así la cierro y le creo su nueva instancia
                verifUserInSession(userDetails.getUsername());
            	return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            }
            throw new BadCredentialsException("Bad credentials");
        } else {
            throw new DisabledException("User disabled");
        }
    }
	
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
    /**
     * Nos permite verificar si el usuario que intenta iniciar sesión no tenga una abierta, 
     * en caso de tenerla, se expira la actual y se permite abrir la nueva.
     * @param username
     */
    private void verifUserInSession(String username){
        if(sessionRegistry != null && sessionRegistry.getAllPrincipals().size() > 0){
            for (Iterator iterator = sessionRegistry.getAllPrincipals().iterator(); iterator.hasNext();) {
                List<SessionInformation> sessionInformactionList = sessionRegistry.getAllSessions(iterator.next(), false);
                if(sessionInformactionList.size() > 0){
                    if( ((User)sessionInformactionList.get(0).getPrincipal()).getUsername().equalsIgnoreCase(username)){
                        //Si ya tiene una sesión abierta se elimina su sesión actual y se permite el inicio de sesión en el otro lugar
                        if(!sessionInformactionList.get(0).isExpired()){
                            sessionInformactionList.get(0).expireNow();
                        }
                    }
                }
            }
        }
    }
    
}
