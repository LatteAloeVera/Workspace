package Code;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create the school management system
        SchoolManagement schoolManagement = new SchoolManagement();

        // Create and add different types of staff members
        Teacher teacher1 = new Teacher("John Doe", 35, "Teacher", "Mathematics");
        Teacher teacher2 = new Teacher("Alice Johnson", 29, "Teacher", "English");
        Administrator admin1 = new Administrator("Sarah Connor", 42, "Administrator", "Finance");
        SupportStaff support1 = new SupportStaff("Bob Smith", 39, "Support Staff", "Morning Shift");

        schoolManagement.addStaffMember(teacher1);
        schoolManagement.addStaffMember(teacher2);
        schoolManagement.addStaffMember(admin1);
        schoolManagement.addStaffMember(support1);

        // Display all staff members
        System.out.println("Initial list of all staff members:");
        schoolManagement.listAllStaff();

        // Remove a teacher
        schoolManagement.removeStaffMember("Alice Johnson");
        System.out.println("\nList after removing Alice Johnson:");
        schoolManagement.listAllStaff();

        // Update a staff member's details
        Administrator admin2 = new Administrator("Sarah Connor", 42, "Administrator", "Human Resources");
        schoolManagement.updateStaffMember("Sarah Connor", admin2);
        System.out.println("\nList after updating Sarah Connor's department:");
        schoolManagement.listAllStaff();

        // Find a specific staff member
        StaffMember foundMember = schoolManagement.findStaffMember("John Doe");
        if (foundMember != null) {
            System.out.println("\nDetails of found member - John Doe:");
            foundMember.displayDetails();
        }

        // Searching by position
        System.out.println("\nAll Teachers in the system:");
        List<StaffMember> teachers = schoolManagement.findByPosition("Teacher");
        for (StaffMember teacher : teachers) {
            teacher.displayDetails();
        }

        // Sorting staff members by age
        schoolManagement.sortByAge();
        System.out.println("\nStaff members sorted by age:");
        schoolManagement.listAllStaff();

        // Bulk update department
        List<String> namesToUpdate = new ArrayList<>();
        namesToUpdate.add("Sarah Connor");
        schoolManagement.bulkUpdateDepartment(namesToUpdate, "Administration");
        System.out.println("\nList after bulk updating the department of Sarah Connor:");
        schoolManagement.listAllStaff();
    }
}
