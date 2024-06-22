package customerevents.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=CreateCustomer.class, name = CreateCustomer.TYPE),
        @JsonSubTypes.Type(value=CreateCustomer.class, name = CreateCustomer.TYPE),
        @JsonSubTypes.Type(value=CreateCustomer.class, name = CreateCustomer.TYPE),
        @JsonSubTypes.Type(value=CreateCustomer.class, name = CreateCustomer.TYPE)
})
@Setter
@ToString
public abstract class CustomerPayload {
    @JsonProperty
    private final UUID id;

    CustomerPayload(UUID id) {
        this.id = id;
    }

    public abstract String getType();

    public UUID getId() {
        return id;
    }
}
