package pl.akolata.demo.directexchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pl.akolata.model.Message;

import static pl.akolata.config.RabbitMqDirectExchangeConfig.QUEUE_GEN_REPORT_DOCX;
import static pl.akolata.config.RabbitMqDirectExchangeConfig.QUEUE_GEN_REPORT_PDF;

@Slf4j
@Component
public class DirectExchangeConsumer {

    @RabbitListener(queues = {QUEUE_GEN_REPORT_DOCX})
    public void consumeDocx(Message message) {
        log.info("Received message [{}] on queue [{}]", message, QUEUE_GEN_REPORT_DOCX);
    }

    @RabbitListener(queues = {QUEUE_GEN_REPORT_PDF})
    public void consumePdf(Message message) {
        log.info("Received message [{}] on queue [{}]", message, QUEUE_GEN_REPORT_PDF);
    }

}
