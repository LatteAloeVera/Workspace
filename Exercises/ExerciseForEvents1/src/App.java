public class App {
    public static void main(String[] args) {
        // Create an instance of EventPlanner
        EventPlanner eventPlanner = new EventPlanner();

        // Adding events
        Event event1 = new Event("E001", "Tech Conference", "2024-05-15", "A conference about the latest in tech.");
        Event event2 = new Event("E002", "Music Festival", "2024-06-20", "An outdoor music festival.");
        Event event3 = new Event("E003", "Art Exhibition", "2024-07-05", "Exhibition showcasing local artists.");

        eventPlanner.addEvent(event1);
        eventPlanner.addEvent(event2);
        eventPlanner.addEvent(event3);

        // Updating an event's details
        eventPlanner.updateEventDetails("E002", "Music Festival", "2024-06-25",
                "Updated date for the outdoor music festival.");

        // Removing an event
        boolean removalSuccess = eventPlanner.removeEvent("E003");
        if (removalSuccess) {
            System.out.println("Event E003 removed successfully.");
        } else {
            System.out.println("Event E003 could not be found.");
        }

        // Listing all events
        System.out.println("Current events:");
        eventPlanner.listAllEvents();
    }
}
