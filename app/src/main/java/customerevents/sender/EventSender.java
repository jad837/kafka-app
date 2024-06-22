package customerevents.sender;

import customerevents.event.CustomerPayload;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.Closeable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface EventSender extends Closeable {
    Future<RecordMetadata> send(CustomerPayload customerPayload);


    final class SendException extends Exception {
        private static final long searialVersionUID = 1;
        SendException(Throwable cause) {super(cause);}
    }

    default RecordMetadata blockingSend(CustomerPayload customerPayload) throws SendException, InterruptedException {
        try{
            return send(customerPayload).get();
        } catch (ExecutionException ex){
            throw new SendException(ex);
        }
    }
}
