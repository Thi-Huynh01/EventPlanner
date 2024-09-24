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
    /*public int compareTo(Event o) {
        return this.name.compareTo(o.name);
    }
    */
    public int compareTo(Event e) {
        return dateTime.compareTo(e.dateTime);
    }

}
