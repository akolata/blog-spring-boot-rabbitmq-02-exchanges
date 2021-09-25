package pl.akolata.demo.defaultexchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.akolata.model.Message;

import static pl.akolata.config.RabbitMqDefaultExchangeConfig.QUEUE_FOR_DEFAULT_EXCHANGE;

@Slf4j
@Service
public class DefaultExchangeConsumer {

    @RabbitListener(queues = {QUEUE_FOR_DEFAULT_EXCHANGE})
    public void consume(Message message) {
        log.info("Received message [{}]", message);
    }

}
