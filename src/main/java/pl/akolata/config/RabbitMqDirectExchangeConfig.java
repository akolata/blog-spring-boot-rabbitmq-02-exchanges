package pl.akolata.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDirectExchangeConfig {
    public static final String ROUTING_KEY_PDF = "pdf";
    public static final String ROUTING_KEY_DOCX = "docx";
    public static final String EXCHANGE_GEN_REPORT = "x.generate-report";
    public static final String QUEUE_GEN_REPORT_PDF = "q.generate-report.pdf";
    public static final String QUEUE_GEN_REPORT_DOCX = "q.generate-report.docx";

    @Bean
    public Queue queueGenerateReportPdf() {
        return new Queue(QUEUE_GEN_REPORT_PDF);
    }

    @Bean
    public Queue queueGenerateReportDocx() {
        return new Queue(QUEUE_GEN_REPORT_DOCX);
    }

    @Bean
    public DirectExchange exchangeGenerateReport() {
        return new DirectExchange(EXCHANGE_GEN_REPORT);
    }

    @Bean
    public Binding generateReportBindingPdf(Queue queueGenerateReportPdf, DirectExchange exchangeGenerateReport) {
        return BindingBuilder.bind(queueGenerateReportPdf).to(exchangeGenerateReport).with(ROUTING_KEY_PDF);
    }

    @Bean
    public Binding generateReportBindingDocx(Queue queueGenerateReportDocx, DirectExchange exchangeGenerateReport) {
        return BindingBuilder.bind(queueGenerateReportDocx).to(exchangeGenerateReport).with(ROUTING_KEY_DOCX);
    }

}
