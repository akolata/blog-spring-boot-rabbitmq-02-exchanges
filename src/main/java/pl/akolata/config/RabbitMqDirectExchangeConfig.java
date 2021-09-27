package pl.akolata.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDirectExchangeConfig {
    public static final String EXCHANGE_TAXI_DIRECT = "x.taxi.direct";
    public static final String ROUTING_KEY_TAXI_NORMAL_SMALL = "taxi.normal.small";
    public static final String ROUTING_KEY_TAXI_ECO_SMALL = "taxi.eco.small";
    public static final String ROUTING_KEY_TAXI_NORMAL_LARGE = "taxi.normal.large";
    public static final String ROUTING_KEY_TAXI_ECO_LARGE = "taxi.eco.large";

    @Bean
    public DirectExchange exchangeTaxiDirect() {
        return new DirectExchange(EXCHANGE_TAXI_DIRECT);
    }

    @Bean
    public Declarables directExchangeBindings(
            DirectExchange exchangeTaxiDirect,
            Queue queueTaxiNormalSmall,
            Queue queueTaxiEcoSmall,
            Queue queueTaxiNormalLarge,
            Queue queueTaxiEcoLarge) {
        return new Declarables(
                BindingBuilder.bind(queueTaxiNormalSmall).to(exchangeTaxiDirect).with(ROUTING_KEY_TAXI_NORMAL_SMALL),
                BindingBuilder.bind(queueTaxiEcoSmall).to(exchangeTaxiDirect).with(ROUTING_KEY_TAXI_ECO_SMALL),
                BindingBuilder.bind(queueTaxiNormalLarge).to(exchangeTaxiDirect).with(ROUTING_KEY_TAXI_NORMAL_LARGE),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxiDirect).with(ROUTING_KEY_TAXI_ECO_LARGE)
        );
    }

}
