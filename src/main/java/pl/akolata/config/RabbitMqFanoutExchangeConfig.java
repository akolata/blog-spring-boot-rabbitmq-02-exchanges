package pl.akolata.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqFanoutExchangeConfig {
    public static final String EXCHANGE_TAXI_FANOUT = "x.taxi.fanout";

    @Bean
    public FanoutExchange exchangeTaxiFanout() {
        return new FanoutExchange(EXCHANGE_TAXI_FANOUT);
    }

    @Bean
    public Declarables fanoutExchangeBindings(
            FanoutExchange exchangeTaxiFanout,
            Queue queueTaxiNormalSmall,
            Queue queueTaxiEcoSmall,
            Queue queueTaxiNormalLarge,
            Queue queueTaxiEcoLarge) {
        return new Declarables(
                BindingBuilder.bind(queueTaxiNormalSmall).to(exchangeTaxiFanout),
                BindingBuilder.bind(queueTaxiEcoSmall).to(exchangeTaxiFanout),
                BindingBuilder.bind(queueTaxiNormalLarge).to(exchangeTaxiFanout),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxiFanout)
        );
    }

}
