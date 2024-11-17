
import java.time.LocalDateTime;

abstract class EventDecorator implements EventInterface {

    protected EventInterface event;
    public EventDecorator(EventInterface event) {
        this.event = event;
    }

    public String getName() {
        return event.getName();
    }

    @Override
    public int compareTo(Event e) {
        return 0;
    }

    public LocalDateTime getDateTime() {
        return event.getDateTime();
    }



}
