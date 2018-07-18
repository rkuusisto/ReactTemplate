/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.elinar.react.rest.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * View Controller
 * @author Mika Mähönen
 */
@Controller
@Scope("prototype")
public class ViewController implements ApplicationContextAware {

    private final Logger log = LoggerFactory.getLogger(ViewController.class);
    private ApplicationContext ac;

    /**
     * 
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handle(ModelMap model, HttpServletRequest request) {
        return "index";
    }
    
    /**
     * Implements Application Context Aware
     * @param ac
     * @throws BeansException 
     */
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.ac = ac;
    }


}
