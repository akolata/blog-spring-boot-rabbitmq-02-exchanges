package pl.akolata.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDefaultExchangeConfig {
    public static final String QUEUE_FOR_DEFAULT_EXCHANGE = "q.test-default-exchange";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_FOR_DEFAULT_EXCHANGE);
    }

}
