package pl.akolata.demo.topicexchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pl.akolata.model.Message;

import static pl.akolata.config.RabbitMqTopicExchangeConfig.*;

@Slf4j
@Component
public class TopicExchangeConsumer {

    @RabbitListener(queues = {QUEUE_TAXI_ECO_LARGE})
    public void consumeTaxiEcoLarge(Message message) {
        log.info("Received message [{}] on queue [{}]", message, QUEUE_TAXI_ECO_LARGE);
    }

    @RabbitListener(queues = {QUEUE_TAXI_ECO_SMALL})
    public void consumeTaxiEcoSmall(Message message) {
        log.info("Received message [{}] on queue [{}]", message, QUEUE_TAXI_ECO_SMALL);
    }

    @RabbitListener(queues = {QUEUE_TAXI_NORMAL_LARGE})
    public void consumeTaxiNormalLarge(Message message) {
        log.info("Received message [{}] on queue [{}]", message, QUEUE_TAXI_NORMAL_LARGE);
    }

    @RabbitListener(queues = {QUEUE_TAXI_NORMAL_SMALL})
    public void consumeTaxiNormalSmall(Message message) {
        log.info("Received message [{}] on queue [{}]", message, QUEUE_TAXI_NORMAL_SMALL);
    }

}
