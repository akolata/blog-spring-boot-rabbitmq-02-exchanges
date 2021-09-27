package pl.akolata.demo.topicexchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.akolata.model.Message;

import static pl.akolata.config.RabbitMqTopicExchangeConfig.EXCHANGE_TAXI;


@Slf4j
@Service
@RequiredArgsConstructor
public class TopicExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        sendMsg("taxi.any.large", "Request for a large taxi");
        sendMsg("taxi.eco", "Message for DOCX queue");
    }

    private void sendMsg(String routingKey, String msg) {
        Message message = new Message(msg);
        rabbitTemplate.convertAndSend(EXCHANGE_TAXI, routingKey, message);
        log.info("Message with id [{}] send to exchange [{}] with routing key [{}]", message.getId(), EXCHANGE_TAXI, routingKey);
    }

}
