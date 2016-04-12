package com.cruz.sec.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Admin")
@Secured("ROLE_ADMIN")
public class AdminController {
    @RequestMapping(value = {"/",""}, method=RequestMethod.GET)
    public String hola(){
        return "admin";
    }
}
