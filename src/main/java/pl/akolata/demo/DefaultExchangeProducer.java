package pl.akolata.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.akolata.model.OrderTaxiMessage;
import pl.akolata.util.MessagingLoggingUtil;

import static pl.akolata.config.QueuesConfiguration.QUEUE_TAXI_DEFAULT;


@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        OrderTaxiMessage msg = new OrderTaxiMessage();
        rabbitTemplate.convertAndSend(QUEUE_TAXI_DEFAULT, msg);
        MessagingLoggingUtil.logSendMessage("", QUEUE_TAXI_DEFAULT, msg);
    }

}
