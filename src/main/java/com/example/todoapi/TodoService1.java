package com.example.todoapi;

import org.springframework.stereotype.Service;

@Service("service1")
public class TodoService1 implements TodoService{
    @Override
    public void doSomething() {
        System.out.println("Todo Service 1 is called");
    }
}
