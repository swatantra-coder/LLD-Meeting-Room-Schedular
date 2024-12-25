import Enums.Avalability;
import Enums.Capacity;

import javax.xml.datatype.XMLGregorianCalendar;

public class MeetingRoom {
    int id;
    String meetingRoomName;
    String location;;
    XMLGregorianCalendar startTime;
    XMLGregorianCalendar endTime;
    Capacity capacity;
    Avalability avalability;
    People people;

    //constructor
    public MeetingRoom(int id, String meetingRoomName, String location, XMLGregorianCalendar startTime, XMLGregorianCalendar endTime, Capacity capacity, Avalability avalability, People people) {
        this.id = id;
        this.meetingRoomName = meetingRoomName;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.avalability = avalability;
        this.people = people;
    }
}
