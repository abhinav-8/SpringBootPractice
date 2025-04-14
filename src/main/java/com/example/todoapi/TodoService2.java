package com.example.todoapi;

import org.springframework.stereotype.Service;

@Service("service2")
public class TodoService2 implements  TodoService{
    @Override
    public void doSomething() {
        System.out.println("Todo Service 2 is called");
    }
}
