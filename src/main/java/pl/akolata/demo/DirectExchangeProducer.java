package pl.akolata.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.akolata.model.OrderTaxiMessage;

import static pl.akolata.config.RabbitMqDirectExchangeConfig.*;
import static pl.akolata.util.MessagingLoggingUtil.logSendMessage;


@Slf4j
@Service
@RequiredArgsConstructor
public class DirectExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        sendMsg(ROUTING_KEY_TAXI_NORMAL_SMALL);
        sendMsg(ROUTING_KEY_TAXI_ECO_LARGE);
        sendMsg("not-matching");
    }

    private void sendMsg(String routingKey) {
        OrderTaxiMessage message = new OrderTaxiMessage();
        rabbitTemplate.convertAndSend(EXCHANGE_TAXI_DIRECT, routingKey, message);
        logSendMessage(EXCHANGE_TAXI_DIRECT, routingKey, message);
    }

}
