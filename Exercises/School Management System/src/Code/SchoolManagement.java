package Code;

import java.util.ArrayList;
import java.util.List;

public class SchoolManagement {
    protected ArrayList<StaffMember> memberList;

    public SchoolManagement() {
        this.memberList = new ArrayList<StaffMember>();
    }

    public void addStaffMember(StaffMember member) {
        this.memberList.add(member);
    }

    public StaffMember findStaffMember(String name) {
        for (StaffMember staffMember : memberList) {
            if (staffMember.getName().equals(name)) {
                return staffMember;
            }
        }
        return null;
    }

    public boolean removeStaffMember(String name) {
        if (findStaffMember(name) != null) {
            this.memberList.remove(findStaffMember(name));
            return true;
        }

        return false;
    }

    public boolean updateStaffMember(String name, StaffMember newDetails) {
        if (findStaffMember(name) != null) {
            this.memberList.remove(findStaffMember(name));
            this.memberList.add(newDetails);

            return true;
        }

        return false;
    }

    public void listAllStaff() {
        System.out.println();
        System.out.println("---------------- Listing All Staff ----------------");
        for (StaffMember staffMember : memberList) {
            staffMember.displayDetails();
            System.out.println("---------------------------------------------------");
        }
    }

    public List<StaffMember> findByPosition(String position) {
        List<StaffMember> list = new ArrayList<StaffMember>();

        for (StaffMember staffMember : memberList) {
            if (staffMember.getPosition().equals(position)) {
                list.add(staffMember);
            }
        }

        return list;
    }

    public void sortByAge() {
        ArrayList<StaffMember> tempMemberList = new ArrayList<StaffMember>();
        StaffMember minAgedStaffMember = memberList.get(0);

        while (!memberList.isEmpty()) {
            minAgedStaffMember = memberList.get(0);
            for (int i = 0; i < memberList.size(); i++) {
                if (minAgedStaffMember.getAge() > memberList.get(i).getAge()) {
                    minAgedStaffMember = memberList.get(i);
                }
            }

            tempMemberList.addFirst(minAgedStaffMember);
            memberList.remove(minAgedStaffMember);
        }

        memberList = tempMemberList;
    }

    public void bulkUpdateDepartment(List<String> names, String newDepartment) {
        for (StaffMember staffMember : memberList) {
            if (staffMember instanceof Administrator && names.contains(staffMember.getName())) {
                staffMember.setPosition(newDepartment);
            }
        }
    }
}
