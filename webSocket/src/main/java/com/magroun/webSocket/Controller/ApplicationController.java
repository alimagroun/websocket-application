package com.magroun.webSocket.Controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magroun.webSocket.model.Task;

@RestController
public class ApplicationController {

    private final List<Task> tasks;

    public ApplicationController() {
        tasks = new ArrayList<>();
    }

    @MessageMapping("/add_new_task")
    @SendTo("/tasks/added_task")
    public Task addTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }
    
}
