package customerevents.sender;

import customerevents.event.*;

import java.util.UUID;

public final class EventProducer {
    private final EventSender sender;

    public EventProducer(EventSender sender) {
        this.sender = sender;
    }

    public void generateRandomEvents() throws EventSender.SendException, InterruptedException {
        final var create = new CreateCustomer(UUID.randomUUID(), "Bob", "Brown");

        blockingSend(create);

        if(Math.random() > 0.5){
            final var update = new UpdateCustomer(create.getId(), "Charlie", "Brown");
            blockingSend(update);
        }

        if(Math.random() > 0.5){
            final var suspend = new SuspendCustomer(create.getId());
            blockingSend(suspend);
        }

        if(Math.random() > 0.5){
            final var reinstate = new ReinstateCustomer(create.getId());
            blockingSend(reinstate);
        }

    }

    public void blockingSend(CustomerPayload customerPayload) throws InterruptedException, EventSender.SendException {
        System.out.format("Publishing %s%n", customerPayload);
        sender.blockingSend(customerPayload);
    }
}
