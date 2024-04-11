public class Event {
    private String eventId;
    private String title;
    private String date;
    private String description;

    Event(String eventId, String title, String date, String description){
        this.setEventId(eventId);
        this.setTitle(title);
        this.setDate(date);
        this.setDescription(description);
    }

    public void setEventId(String eventId){
        this.eventId = eventId;
    }
    public String getEventId(){
        return this.eventId;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public String getEventDetails(){
        return getEventId() + "   " + getTitle() + "   " + getDate() + "   " + getDescription();
    }
}
