package com.example.mailbox.service;

import com.example.mailbox.model.TaskRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskWorker {

    @Autowired
    private Mailbox mailbox;

    @PostConstruct
    public void startWorker() {
        Thread workerThread = new Thread(() -> {
            while (true) {
                try {
                    TaskRequest task = mailbox.take();
                    System.out.println("Processing task: " + task.getTaskId() + " | Payload: " + task.getPayload());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        workerThread.setDaemon(true);
        workerThread.start();
    }
}
