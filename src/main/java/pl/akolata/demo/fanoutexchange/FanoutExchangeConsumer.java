package pl.akolata.demo.fanoutexchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pl.akolata.model.Message;

import static pl.akolata.config.RabbitMqFanoutExchangeConfig.QUEUE_ASSEMBLY_SHIPMENT;
import static pl.akolata.config.RabbitMqFanoutExchangeConfig.QUEUE_GENERATE_INVOICE;

@Slf4j
@Component
public class FanoutExchangeConsumer {

    @RabbitListener(queues = {QUEUE_GENERATE_INVOICE})
    public void consumeGenerateInvoice(Message message) {
        log.info("Received message [{}] on queue [{}]", message, QUEUE_GENERATE_INVOICE);
    }

    @RabbitListener(queues = {QUEUE_ASSEMBLY_SHIPMENT})
    public void consumeAssemblyShipment(Message message) {
        log.info("Received message [{}] on queue [{}]", message, QUEUE_ASSEMBLY_SHIPMENT);
    }

}
