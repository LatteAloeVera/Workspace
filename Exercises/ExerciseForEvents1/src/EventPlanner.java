import java.util.ArrayList;

public class EventPlanner {
    private ArrayList<Event> events;

    EventPlanner(){
        this.events = new ArrayList<Event>();
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public boolean removeEvent(String eventId){
        for (Event event : events) {
            if(eventId == event.getEventId()){
                events.remove(event);
                return true;
            }
        }
        return false;
    }

    public Event findEventById(String eventId){
        for (Event event : events) {
            if(eventId == event.getEventId()){
                return event;
            }
        }
        return null;
    }

    public void updateEventDetails(String eventId, String title, String date, String description){
        Event event = findEventById(eventId);
        event.setDate(date);
        event.setDescription(description);
        event.setTitle(title);
    }

    public void listAllEvents(){
        for (Event event : events) {
            // System.out.println(event.getEventDetails());
            System.out.printf("%-6s %-20s %-15s %-50s\n",event.getEventId(), event.getTitle(), event.getDate(), event.getDescription());
        }
    }
}