package customerevents.event;

import lombok.ToString;

import java.util.UUID;

@ToString
public final class ReinstateCustomer extends CustomerPayload {
    static final String TYPE = "REINSTATE_CUSTOMER";

    public ReinstateCustomer(UUID id) {
        super(id);
    }

    @Override
    public String getType(){
        return TYPE;
    }
}
