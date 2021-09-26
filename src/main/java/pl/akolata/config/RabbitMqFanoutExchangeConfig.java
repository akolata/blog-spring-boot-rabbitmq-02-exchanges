package pl.akolata.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqFanoutExchangeConfig {
    public static final String EXCHANGE_ORDER_CREATED = "x.order-created";
    public static final String QUEUE_GENERATE_INVOICE = "q.order.generate-invoice";
    public static final String QUEUE_ASSEMBLY_SHIPMENT = "q.order.assemble-shipment";

    @Bean
    public Queue queueOrderGenerateInvoice() {
        return new Queue(QUEUE_GENERATE_INVOICE);
    }

    @Bean
    public Queue queueOrderAssemblyShipment() {
        return new Queue(QUEUE_ASSEMBLY_SHIPMENT);
    }

    @Bean
    public FanoutExchange exchangeOrderCreated() {
        return new FanoutExchange(EXCHANGE_ORDER_CREATED);
    }

    @Bean
    public Binding generateInvoiceBinding(Queue queueOrderGenerateInvoice, FanoutExchange exchangeOrderCreated) {
        return BindingBuilder.bind(queueOrderGenerateInvoice).to(exchangeOrderCreated);
    }

    @Bean
    public Binding assemblyShipmentBinding(Queue queueOrderAssemblyShipment, FanoutExchange exchangeOrderCreated) {
        return BindingBuilder.bind(queueOrderAssemblyShipment).to(exchangeOrderCreated);
    }

}
