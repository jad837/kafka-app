package customerevents.sender;

import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Map;

public class RandomEventProducer {
    public static void main(String[] args) throws EventSender.SendException, InterruptedException {
        final Map<String, Object> config = Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ProducerConfig.CLIENT_ID_CONFIG, "random-customer-producer");
        final var topic = "customer.test";

        try(var sender = new DirectSender(config, topic)){
            final var businessLogic = new EventProducer(sender);
            while(true){
                businessLogic.generateRandomEvents();
                Thread.sleep(500);
            }
        }

    }
}
