package pl.akolata.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.akolata.model.OrderTaxiMessage;

import static pl.akolata.config.RabbitMqTopicExchangeConfig.EXCHANGE_TAXI_TOPIC;
import static pl.akolata.util.MessagingLoggingUtil.logSendMessage;


@Slf4j
@Service
@RequiredArgsConstructor
public class TopicExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        sendMsg("taxi.normal.small");
        sendMsg("whatever.any.large");
        sendMsg("taxi.eco.additional.words");
    }

    private void sendMsg(String routingKey) {
        OrderTaxiMessage message = new OrderTaxiMessage();
        rabbitTemplate.convertAndSend(EXCHANGE_TAXI_TOPIC, routingKey, message);
        logSendMessage(EXCHANGE_TAXI_TOPIC, routingKey, message);
    }

}
