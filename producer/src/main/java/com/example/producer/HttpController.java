package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
    private final SqsQueueSender sqsQueueSender;

    @Autowired
    public HttpController(SqsQueueSender sqsQueueSender) {
        this.sqsQueueSender = sqsQueueSender;
    }

	@PostMapping("/produce")
	public void pushMessage(@RequestBody String message) {
        this.sqsQueueSender.send(message);
	}
}
