package com.example.todoapi;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    List<Todo> todoList = new ArrayList<>();

    private TodoService todoService1, todoService2;
    public TodoController(@Qualifier("service1") TodoService todoService1, @Qualifier("service2") TodoService todoService2) {
        this.todoService1 = todoService1;
        this.todoService2 = todoService2;
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, "todo1", "temp1", false));
        todoList.add(new Todo(2, "todo2", "temp2", true));
    }

    @GetMapping("/todos")
    public List<Todo> getTodoList(@RequestParam(required=false, defaultValue="true") boolean completed) {
        return todoList;
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        this.todoService2.doSomething();
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

}
