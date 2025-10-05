package com.cathle.spring_boot_todo_application.config;

import com.cathle.spring_boot_todo_application.models.TodoItem;
import com.cathle.spring_boot_todo_application.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("get the juice");
            TodoItem todoItem2 = new TodoItem("clean the house");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }
        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }
}
