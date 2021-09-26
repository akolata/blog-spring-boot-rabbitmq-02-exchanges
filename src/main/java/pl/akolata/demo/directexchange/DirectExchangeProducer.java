package pl.akolata.demo.directexchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.akolata.model.Message;

import static pl.akolata.config.RabbitMqDirectExchangeConfig.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class DirectExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        sendMsg(ROUTING_KEY_PDF, "Message for PDF queue");
        sendMsg(ROUTING_KEY_DOCX, "Message for DOCX queue");
        sendMsg("not-matching", "Message to be discarded");
    }

    private void sendMsg(String routingKey, String msg) {
        Message message = new Message(msg);
        rabbitTemplate.convertAndSend(EXCHANGE_GEN_REPORT, routingKey, message);
        log.info("Message with id [{}] send to exchange [{}] with routing key [{}]", message.getId(), EXCHANGE_GEN_REPORT, routingKey);
    }

}
