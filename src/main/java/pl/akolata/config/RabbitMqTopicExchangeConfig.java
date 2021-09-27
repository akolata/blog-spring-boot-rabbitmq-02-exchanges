package pl.akolata.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicExchangeConfig {
    public static final String EXCHANGE_TAXI = "x.taxi";
    public static final String QUEUE_TAXI_ECO_SMALL = "q.taxi.eco.small";
    public static final String QUEUE_TAXI_NORMAL_SMALL = "q.taxi.normal.small";
    public static final String QUEUE_TAXI_ECO_LARGE = "q.taxi.eco.large";
    public static final String QUEUE_TAXI_NORMAL_LARGE = "q.taxi.normal.large";

    @Bean
    public Queue queueTaxiEcoSmall() {
        return new Queue(QUEUE_TAXI_ECO_SMALL);
    }

    @Bean
    public Queue queueTaxiNormalSmall() {
        return new Queue(QUEUE_TAXI_NORMAL_SMALL);
    }

    @Bean
    public Queue queueTaxiEcoLarge() {
        return new Queue(QUEUE_TAXI_ECO_LARGE);
    }

    @Bean
    public Queue queueTaxiNormalLarge() {
        return new Queue(QUEUE_TAXI_NORMAL_LARGE);
    }

    @Bean
    public TopicExchange exchangeTaxis() {
        return new TopicExchange(EXCHANGE_TAXI);
    }

    @Bean
    public Declarables generateTopicExchangeBindings(
            Queue queueTaxiEcoSmall,
            Queue queueTaxiNormalSmall,
            Queue queueTaxiEcoLarge,
            Queue queueTaxiNormalLarge,
            TopicExchange exchangeTaxis) {
        return new Declarables(
                BindingBuilder.bind(queueTaxiEcoSmall).to(exchangeTaxis).with("taxi.*.small"),
                BindingBuilder.bind(queueTaxiNormalSmall).to(exchangeTaxis).with("taxi.*.small"),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxis).with("taxi.*.large"),
                BindingBuilder.bind(queueTaxiNormalLarge).to(exchangeTaxis).with("taxi.*.large"),
                BindingBuilder.bind(queueTaxiEcoSmall).to(exchangeTaxis).with("taxi.eco.#"),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxis).with("taxi.eco.#"),
                BindingBuilder.bind(queueTaxiNormalSmall).to(exchangeTaxis).with("taxi.normal.#"),
                BindingBuilder.bind(queueTaxiNormalLarge).to(exchangeTaxis).with("taxi.normal.#")
        );
    }

}
