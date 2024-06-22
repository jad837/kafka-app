package customerevents.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import customerevents.event.CustomerPayload;
import org.apache.kafka.common.serialization.Serializer;

import java.io.Serial;
import java.util.Map;

public final class CustomerPayloadSerializer implements Serializer<CustomerPayload> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final class MarshallingException extends RuntimeException{
        @Serial
        private static final long serialVersionUID = 1L;
        private MarshallingException(Throwable cause) {super(cause);}
    }

    @Override
    public byte[] serialize(String topic, CustomerPayload customerPayload) {
        try {
            return objectMapper.writeValueAsBytes(customerPayload);
        } catch (JsonProcessingException e){
            throw new MarshallingException(e);
        }
    }
}
