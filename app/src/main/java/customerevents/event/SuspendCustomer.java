package customerevents.event;

import lombok.ToString;

import java.util.UUID;

@ToString
public final class SuspendCustomer extends CustomerPayload {
    static final String TYPE = "SUSPEND_CUSTOMER";

    public SuspendCustomer(UUID id) {
        super(id);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
