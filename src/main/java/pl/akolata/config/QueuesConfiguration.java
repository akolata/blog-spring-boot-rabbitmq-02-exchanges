package pl.akolata.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueuesConfiguration {
    public static final String QUEUE_TAXI_DEFAULT = "q.taxi.default";
    public static final String QUEUE_TAXI_NORMAL_SMALL = "q.taxi.normal.small";
    public static final String QUEUE_TAXI_ECO_SMALL = "q.taxi.eco.small";
    public static final String QUEUE_TAXI_NORMAL_LARGE = "q.taxi.normal.large";
    public static final String QUEUE_TAXI_ECO_LARGE = "q.taxi.eco.large";

    @Bean
    public Queue queueTaxiDefault() {
        return new Queue(QUEUE_TAXI_DEFAULT);
    }

    @Bean
    public Queue queueTaxiNormalSmall() {
        return new Queue(QUEUE_TAXI_NORMAL_SMALL);
    }

    @Bean
    public Queue queueTaxiEcoSmall() {
        return new Queue(QUEUE_TAXI_ECO_SMALL);
    }

    @Bean
    public Queue queueTaxiNormalLarge() {
        return new Queue(QUEUE_TAXI_NORMAL_LARGE);
    }

    @Bean
    public Queue queueTaxiEcoLarge() {
        return new Queue(QUEUE_TAXI_ECO_LARGE);
    }

}
