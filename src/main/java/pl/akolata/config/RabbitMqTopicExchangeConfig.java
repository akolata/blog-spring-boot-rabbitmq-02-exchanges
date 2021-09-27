package pl.akolata.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static pl.akolata.config.RabbitMqDirectExchangeConfig.*;

@Configuration
public class RabbitMqTopicExchangeConfig {
    public static final String EXCHANGE_TAXI_TOPIC = "x.taxi.topic";

    @Bean
    public TopicExchange exchangeTaxiTopic() {
        return new TopicExchange(EXCHANGE_TAXI_TOPIC);
    }

    @Bean
    public Declarables topicExchangeBindings(
            TopicExchange exchangeTaxiTopic,
            Queue queueTaxiNormalSmall,
            Queue queueTaxiEcoSmall,
            Queue queueTaxiNormalLarge,
            Queue queueTaxiEcoLarge) {
        return new Declarables(
                BindingBuilder.bind(queueTaxiNormalSmall).to(exchangeTaxiTopic).with(ROUTING_KEY_TAXI_NORMAL_SMALL),
                BindingBuilder.bind(queueTaxiEcoSmall).to(exchangeTaxiTopic).with(ROUTING_KEY_TAXI_ECO_SMALL),
                BindingBuilder.bind(queueTaxiNormalLarge).to(exchangeTaxiTopic).with(ROUTING_KEY_TAXI_NORMAL_LARGE),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxiTopic).with(ROUTING_KEY_TAXI_ECO_LARGE),
                BindingBuilder.bind(queueTaxiNormalLarge).to(exchangeTaxiTopic).with("*.*.large"),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxiTopic).with("*.*.large"),
                BindingBuilder.bind(queueTaxiEcoSmall).to(exchangeTaxiTopic).with("taxi.eco.#"),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxiTopic).with("taxi.eco.#")
        );
    }

}
