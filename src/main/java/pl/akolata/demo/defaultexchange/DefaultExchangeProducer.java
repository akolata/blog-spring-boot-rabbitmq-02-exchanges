package pl.akolata.demo.defaultexchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.akolata.model.Message;

import java.time.LocalDateTime;

import static pl.akolata.config.RabbitMqDefaultExchangeConfig.QUEUE_FOR_DEFAULT_EXCHANGE;


@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        Message msg = new Message();
        msg.setMsg("Message from " + LocalDateTime.now());
        rabbitTemplate.convertAndSend(QUEUE_FOR_DEFAULT_EXCHANGE, msg);
        log.info("Message with id [{}] send to default exchange with routing key [{}]", msg.getId(), QUEUE_FOR_DEFAULT_EXCHANGE);
    }

}
