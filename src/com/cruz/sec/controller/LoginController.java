package com.cruz.sec.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController{
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response, Principal principal){
        if (principal != null){
        	try {//Se realiza el redireccionamiento a /cuando esta en sesion el usuario
				response.sendRedirect(request.getContextPath() + "/");
			} catch (IOException e) {}
        }
        return "login";
	}
	
	@RequestMapping(value = "/error/{codigo}")
	public String manejoErrores(Model model, @PathVariable(value="codigo") int codigo){
		String mensaje = "";
		switch (codigo) {
			case 400: mensaje = "Solicitud incorrecta";
				break;
			case 404: mensaje = "El contenido que solicita no se encuentra en el servidor";
				break;
			case 403: mensaje = "No tienen permisos para acceder al contenido que solicita";
				break;
			case 500: mensaje = "Se han presentado incovenientes al procesar la solicitud";
				break;
			case 999: mensaje = "Su sesión se ha abierto en otra ubicación";
				break;
		default:
			break;
		}
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("codigo", codigo);
		return "error/error";
	}
	
	@RequestMapping(value = "/refresh/window/{fecha}/{usuario}/close", method={RequestMethod.POST, RequestMethod.GET})
	public String envioMsjCliente(Model model, @PathVariable(value="fecha") long fecha, @PathVariable(value="usuario") String usuario){
		model.addAttribute("usuario", usuario);
		return "wscliente/close";
				
	}
	
}