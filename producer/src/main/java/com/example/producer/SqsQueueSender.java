package com.example.producer;

import com.amazonaws.services.sqs.AmazonSQSAsync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SqsQueueSender {
    private final QueueMessagingTemplate queueMessagingTemplate;
    private final String queue;

    @Autowired
    public SqsQueueSender(AmazonSQSAsync amazonSQS, @Qualifier("sqs-queue-name") String queue) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQS);
        this.queue = queue;
    }

    public void send(String message) {
        this.queueMessagingTemplate.send(queue, MessageBuilder.withPayload(message).build());
    }
}
