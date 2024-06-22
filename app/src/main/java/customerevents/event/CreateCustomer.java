package customerevents.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public final class CreateCustomer extends CustomerPayload {

    static final String TYPE = "CREATE_CUSTOMER";

    @JsonProperty
    private final String firstName;

    @JsonProperty
    private final String lastName;

    public CreateCustomer(UUID id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getType() {
        return TYPE;
    }


}
