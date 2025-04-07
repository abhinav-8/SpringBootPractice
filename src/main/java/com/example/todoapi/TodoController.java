package com.example.todoapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    List<Todo> todoList = new ArrayList<>();

    public TodoController() {
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, "todo1", "temp1", false));
        todoList.add(new Todo(2, "todo2", "temp2", true));
    }

    @GetMapping("/todos")
    public List<Todo> getTodoList() {
        return todoList;
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return newTodo;
    }

}
