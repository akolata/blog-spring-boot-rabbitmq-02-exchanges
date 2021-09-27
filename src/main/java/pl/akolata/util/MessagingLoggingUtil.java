package pl.akolata.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import pl.akolata.model.OrderTaxiMessage;

@Slf4j
@UtilityClass
public class MessagingLoggingUtil {
    public static void logReceivedMessage(String queue, OrderTaxiMessage message) {
        log.info("Listener on queue [{}] received message [{}]", queue, message);
    }

    public static void logSendMessage(String exchange, String routingKey, OrderTaxiMessage message) {
        log.info("Message [{}] send to exchange [{}] with routing key [{}]", message.getId(), exchange, routingKey);
    }
}
