import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting extends Event implements Completable {

   public LocalDateTime endDateTime;
   public String location;
   public boolean complete;

   public Meeting (String name, LocalDateTime start, LocalDateTime end, String location) {
       super(name, start);
       this.endDateTime = end;
       this.location = location;
   }

   public LocalDateTime getEndDateTime(){
       return endDateTime;
   }

   public String getLocation(){
       return location;
   }

   public void setEndDateTime(LocalDateTime endDateTime){
       this.endDateTime = endDateTime;
   }

   public void setLocation(String location){
       this.location = location;
   }

   public Duration getDuration() {
        return (Duration.between(dateTime, endDateTime));
   }
   @Override
   public void complete () {
        this.complete = true;
   }

   @Override
    public boolean isComplete(){
       return this.complete;
   }
}
