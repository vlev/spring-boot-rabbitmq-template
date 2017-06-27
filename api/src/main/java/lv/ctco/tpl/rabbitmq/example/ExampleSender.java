package lv.ctco.tpl.rabbitmq.example;

import lombok.extern.slf4j.Slf4j;
import lv.ctco.tpl.rabbitmq.configuration.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExampleSender {

    @Autowired
    RabbitTemplate template;

    public void send(String message) {
        log.info("Sending message: {}", message);
        template.convertAndSend(RabbitMQConfiguration.QUEUE_NAME, message);
    }
}
