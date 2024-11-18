
import java.time.LocalDateTime;

abstract class EventDecorator implements EventInterface {

    // Implement all methods from EventInterface.java

    protected EventInterface event;
    public EventDecorator(EventInterface event) {
        this.event = event;
    }

    public String getName() {
        return event.getName();
    }

    @Override
    public int compareTo(Event e) {
        return event.compareTo(e);
    }

    public LocalDateTime getDateTime() {
        return event.getDateTime();
    }



}
