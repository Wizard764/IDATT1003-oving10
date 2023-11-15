package Main;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class EventRegister
{
    public class Event
    {
        private static int idCounter = 0;
        private final int id;
        private final String name;
        private final String location;
        private final String organizer;
        private final String type;
        private final long time;
        public Event(String name, String location, String organizer, String type, long time)
        {
            id = idCounter;
            idCounter++;
            this.name = name;
            this.location = location;
            this.organizer = organizer;
            this.type = type;
            this.time = time;
        }
        public Event(Event event) {this(event.name, event.location, event.organizer, event.type, event.time);}
        public static int getIdCounter()
        {
            return idCounter;
        }
        public int getId()
        {
            return id;
        }
        public String getName()
        {
            return name;
        }
        public String getLocation()
        {
            return location;
        }
        public String getOrganizer()
        {
            return organizer;
        }
        public String getType()
        {
            return type;
        }
        public long getTime()
        {
            return time;
        }
        public String toString() {return "Name: " + name + ", Type: " + type + ", Location: " + location + ", Time: " + time + ", Organizer: " + organizer;}
    }
    private ArrayList<Event> events;
    public EventRegister()
    {
        events = new ArrayList<Event>();
    }
    public EventRegister(Event[] events)
    {
        this();
        this.events.addAll(Arrays.asList(events));
    }
    public void AddNewEvent(String name, String location, String organizer, String type, long time)
    {
        events.add(new Event(name, location, organizer, type, time));
        OrderEvents();
    }
    private void OrderEvents()
    {
        if(events.size() > 1)
        {
            for (int i = 0; i < events.size(); i++)
            {
                if(i == events.size() - 1)
                {
                    return;
                }
                if (events.get(i).getTime() > events.get(i+1).getTime())
                {
                    Event temp = new Event(events.get(i));
                    events.set(i, new Event(events.get(i+1)));
                    events.set(i+1, new Event(temp));
                    i = 0;
                }
            }
        }
    }
    public Event[] GetEventsByTimeInterval(long t0, long t1)
    {
        ArrayList<Event> res = new ArrayList<Event>();
        boolean found = false;
        int i = 0;
        while(i < events.size())
        {
            if(events.get(i).getTime() >= t0 && events.get(i).getTime() <= t1)
            {
                found = true;
                break;
            }
            i++;
        }
        while(i < events.size())
        {
            if(events.get(i).getTime() >= t0 && events.get(i).getTime() <= t1)
            {
                res.add(new Event(events.get(i)));
                i++;
            }
            else
            {
                break;
            }
        }
        Event[] result = new Event[res.size()];
        for(int j = 0; j < res.size(); j++)
        {
            result[j] = new Event(res.get(j));
        }
        return result;
    }
    public Event[] GetEventsInSpecificLocation(String location)
    {
        ArrayList<Event> res = new ArrayList<Event>();
        for(Event event : events)
        {
            if(event.getLocation().equals(location))
            {
                res.add(event);
            }
        }
        Event[] result = new Event[res.size()];
        for(int i = 0; i < res.size(); i++)
        {
            result[i] = new Event(res.get(i));
        }
        return result;
    }
    public Event[] GetEventsOnSpecificDate(long date)
    {
        long t0 = date * 10000;
        long t1 = t0 + 2359;
        return(GetEventsByTimeInterval(t0, t1));
    }
    public Event[] GetEventsSortedByTime()
    {
        OrderEvents();
        Event[] result = new Event[events.size()];
        for(int i = 0; i < events.size(); i++)
        {
            result[i] = new Event(events.get(i));
        }
        return result;
    }
    public Event[] GetEventsSortedByPlace()
    {
        ArrayList<String> places = new ArrayList<String>();
        for(Event event : events)
        {
            if(!places.contains(event.getLocation()))
            {
                places.add(event.getLocation());
            }
        }
        Collections.sort(places);
        Event[] result = new Event[events.size()];
        int i = 0;
        for(String place : places)
        {
            for(Event event : events)
            {
                if(event.getLocation().equals(place))
                {
                    result[i] = event;
                    i++;
                }
            }
        }
        return result;
    }
    public Event[] GetEventsSortedByType()
    {
        ArrayList<String> types = new ArrayList<String>();
        for(Event event : events)
        {
            if(!types.contains(event.getType()))
            {
                types.add(event.getType());
            }
        }
        Collections.sort(types);
        Event[] result = new Event[events.size()];
        int i = 0;
        for(String place : types)
        {
            for(Event event : events)
            {
                if(event.getType().equals(place))
                {
                    result[i] = event;
                    i++;
                }
            }
        }
        return result;
    }
    public String toString()
    {
        String res = "Events:";
        for(Event event : events)
        {
            res += "\n" + event.toString();
        }
        return res;
    }
}