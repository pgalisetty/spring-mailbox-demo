package com.example.mailbox.service;

import com.example.mailbox.model.TaskRequest;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Mailbox {
    private final BlockingQueue<TaskRequest> queue = new LinkedBlockingQueue<>();

    public void submit(TaskRequest request) {
        queue.offer(request);
    }

    public TaskRequest take() throws InterruptedException {
        return queue.take();
    }
}
