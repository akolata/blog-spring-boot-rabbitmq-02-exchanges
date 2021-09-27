package pl.akolata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.akolata.demo.defaultexchange.DefaultExchangeProducer;
import pl.akolata.demo.directexchange.DirectExchangeProducer;
import pl.akolata.demo.fanoutexchange.FanoutExchangeProducer;
import pl.akolata.demo.topicexchange.TopicExchangeProducer;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {
    private final DefaultExchangeProducer defaultExchangeProducer;
    private final DirectExchangeProducer directExchangeProducer;
    private final FanoutExchangeProducer fanoutExchangeProducer;
    private final TopicExchangeProducer topicExchangeProducer;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
//        defaultExchangeProducer.sendMessage();
//        directExchangeProducer.sendMessage();
//        fanoutExchangeProducer.sendMessage();
        topicExchangeProducer.sendMessage();
    }

}
