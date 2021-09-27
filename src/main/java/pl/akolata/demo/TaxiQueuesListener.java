package pl.akolata.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.akolata.model.OrderTaxiMessage;

import static pl.akolata.config.QueuesConfiguration.*;
import static pl.akolata.util.MessagingLoggingUtil.logReceivedMessage;

@Slf4j
@Service
public class TaxiQueuesListener {

    @RabbitListener(queues = {QUEUE_TAXI_DEFAULT})
    public void listenOnQueueDefault(OrderTaxiMessage message) {
        logReceivedMessage(QUEUE_TAXI_DEFAULT, message);
    }

    @RabbitListener(queues = {QUEUE_TAXI_NORMAL_SMALL})
    public void listenOnQueueTaxiNormalSmall(OrderTaxiMessage message) {
        logReceivedMessage(QUEUE_TAXI_NORMAL_SMALL, message);
    }

    @RabbitListener(queues = {QUEUE_TAXI_ECO_SMALL})
    public void listenOnQueueTaxiEcoSmall(OrderTaxiMessage message) {
        logReceivedMessage(QUEUE_TAXI_ECO_SMALL, message);
    }

    @RabbitListener(queues = {QUEUE_TAXI_ECO_LARGE})
    public void listenOnQueueTaxiEcoLarge(OrderTaxiMessage message) {
        logReceivedMessage(QUEUE_TAXI_ECO_LARGE, message);
    }

    @RabbitListener(queues = {QUEUE_TAXI_NORMAL_LARGE})
    public void listenOnQueueTaxiNormalLarge(OrderTaxiMessage message) {
        logReceivedMessage(QUEUE_TAXI_NORMAL_LARGE, message);
    }

}
