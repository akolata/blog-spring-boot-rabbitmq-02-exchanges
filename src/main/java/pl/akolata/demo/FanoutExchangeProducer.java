package pl.akolata.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.akolata.model.OrderTaxiMessage;

import static pl.akolata.config.RabbitMqFanoutExchangeConfig.EXCHANGE_TAXI_FANOUT;
import static pl.akolata.util.MessagingLoggingUtil.logSendMessage;


@Slf4j
@Service
@RequiredArgsConstructor
public class FanoutExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        OrderTaxiMessage message = new OrderTaxiMessage();
        rabbitTemplate.convertAndSend(EXCHANGE_TAXI_FANOUT, "", message);
        logSendMessage(EXCHANGE_TAXI_FANOUT, "", message);
    }

}
