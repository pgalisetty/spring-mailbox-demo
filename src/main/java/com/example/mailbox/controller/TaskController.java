package com.example.mailbox.controller;

import com.example.mailbox.model.TaskRequest;
import com.example.mailbox.service.Mailbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private Mailbox mailbox;

    @PostMapping
    public ResponseEntity<String> submitTask(@RequestBody TaskRequest task) {
        mailbox.submit(task);
        return ResponseEntity.ok("Task submitted: " + task.getTaskId());
    }
}
