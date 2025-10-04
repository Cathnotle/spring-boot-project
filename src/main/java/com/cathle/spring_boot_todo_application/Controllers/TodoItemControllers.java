package com.cathle.spring_boot_todo_application.Controllers;

import ch.qos.logback.core.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TodoItemControllers {
    private final Logger log = LoggerFactory.getLogger(TodoItemControllers.class);

    @GetMapping ({"/","/index"})
    public ModelAndView index (){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
