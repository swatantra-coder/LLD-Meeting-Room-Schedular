import Enums.Avalability;
import Enums.Capacity;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MeetingRoom> meetingRooms = new ArrayList<>();
        meetingRooms.add(new MeetingRoom(1, "Narmada", "Elena 1st floor", null, null, Capacity.SMALL, Avalability.AVAILABLE,null));
        meetingRooms.add(new MeetingRoom(2, "Ganga", "Elena 1st floor", null, null, Capacity.MEDIUM, Avalability.AVAILABLE,null));
        meetingRooms.add(new MeetingRoom(3, "Yamuna", "Elena 1st floor", null, null, Capacity.LARGE, Avalability.UNAVAILABLE,null));
        meetingRooms.add(new MeetingRoom(4, "Saraswati", "Elena 1st floor", null, null, Capacity.SMALL, Avalability.AVAILABLE,null));
        meetingRooms.add(new MeetingRoom(5, "Godavari", "Elena 1st floor", null, null, Capacity.MEDIUM, Avalability.UNAVAILABLE,null));


        //Get the booking available room
        for(MeetingRoom meetingRoom : meetingRooms) {
            if(meetingRoom.avalability == Avalability.AVAILABLE) {
                System.out.println("Available Meeting Room: " + meetingRoom.meetingRoomName);
            }
        }

        //Book the meeting room
        System.out.println("Enter the meeting room name to book: ");
        String roomName = scanner.nextLine();

        for(MeetingRoom meetingRoom : meetingRooms) {
            if(meetingRoom.meetingRoomName.equals(roomName) && meetingRoom.avalability == Avalability.AVAILABLE ) {

                //enter persons to be added in the room;
                People person = new People();
                System.out.println("Enter the person name: ");
                person.name = scanner.nextLine();
                System.out.println("Enter the person email: ");
                person.email = scanner.nextLine();

                meetingRoom.avalability = Avalability.UNAVAILABLE;
                meetingRoom.people = person;

                try{
                    System.out.println("Enter the start time (YYYY-MM-DDTHH:MM:SS): ");
                    String startTimeString = scanner.nextLine();
                    XMLGregorianCalendar startTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(startTimeString);

                    System.out.println("Enter the end time (YYYY-MM-DDTHH:MM:SS): ");
                    String endTimeString = scanner.nextLine();
                    XMLGregorianCalendar endTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(endTimeString);
                }catch(Exception e){
                    System.out.println("Invalid date format");
                }
                System.out.println("Meeting Room " + roomName + " is booked successfully");

                //send Notification to the person
                System.out.println("Notification sent to " + person.name + " at " + person.email);

            }
        }
    }
}