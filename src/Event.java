import java.time.LocalDateTime;

public abstract class Event implements Comparable <Event> {
    public String name;
    public LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    @Override
    public int compareTo(Event e) {

        if (this.dateTime.isBefore(e.dateTime)) {
            return -1;
        }
        else if (this.dateTime.isAfter(e.dateTime)) {
            return 1;
        }
        return 0;
    }
}
