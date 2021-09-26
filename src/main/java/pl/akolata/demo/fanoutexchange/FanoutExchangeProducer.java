package pl.akolata.demo.fanoutexchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.akolata.model.Message;

import static pl.akolata.config.RabbitMqFanoutExchangeConfig.EXCHANGE_ORDER_CREATED;


@Slf4j
@Service
@RequiredArgsConstructor
public class FanoutExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        Message message = new Message("Order created");
        rabbitTemplate.convertAndSend(EXCHANGE_ORDER_CREATED, "", message);
        log.info("Message with id [{}] send to exchange [{}]", message.getId(), EXCHANGE_ORDER_CREATED);
    }

}
