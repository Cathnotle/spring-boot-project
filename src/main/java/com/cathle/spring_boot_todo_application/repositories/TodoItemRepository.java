package com.cathle.spring_boot_todo_application.repositories;

import com.cathle.spring_boot_todo_application.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository <TodoItem,Long> {


}
