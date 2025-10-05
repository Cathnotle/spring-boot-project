package com.cathle.spring_boot_todo_application.Controllers;

import com.cathle.spring_boot_todo_application.models.TodoItem;
import com.cathle.spring_boot_todo_application.repositories.TodoItemRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.ZoneId;

@Controller
public class TodoItemControllers {

    private final Logger log = LoggerFactory.getLogger(TodoItemControllers.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping({"/", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());

        return modelAndView;
    }
    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-todo-item";
        }

        todoItem.setCreatedDate(Instant.now());
        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }



    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            todoItem.setId(id);
            return "update-todo-item";
        }
        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }
}
