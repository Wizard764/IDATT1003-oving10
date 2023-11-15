package Main;
import Menu.*;
import InputUtil.InputUtil;

import java.util.Scanner;

public class Main
{
    static EventRegister er = new EventRegister();
    static Scanner sc = new Scanner(System.in);
    static boolean flag = true;
    public static void main(String[] args)
    {
        er.AddNewEvent("A", "Akershus", "Alice",    "Aktivitet",    202210121300L);
        er.AddNewEvent("B", "Bergen",   "Bob",      "B-ord",        202212101300L);
        er.AddNewEvent("C", "Akershus", "Bob",      "B-ord",        202501102000L);
        er.AddNewEvent("D", "Akershus", "Bob",      "B-ord",        202210101300L);
        er.AddNewEvent("E", "Central",  "Alice",    "Aktivitet",    200205101800L);
        er.AddNewEvent("F", "Bergen",   "Charlie",  "Concert",      201310131300L);
        Menu a =    new Menu(new Page[]
                {
                        new Page("Select action:", new Option[]                                 //<--0
                                {
                                        new Option("1. Register new event", 3),
                                        new Option("2. Get selection of events", 1),
                                        new Option("3. Get events sorted by ...", 2),
                                        new Option("4. Exit program", 10)
                                }),
                        new Page("Filter events by:", new Option[]                              //<--1
                                {
                                        new Option("1. Place", 4),
                                        new Option("2. Date", 5),
                                        new Option("3. Time interval", 6),
                                        new Option("4. Back to main menu", 0)
                                }),
                        new Page("Get events sorted by:", new Option[]                          //<--2
                                {
                                        new Option("1. Place", 7),
                                        new Option("2. Type", 8),
                                        new Option("3. Time", 9),
                                        new Option("4. Back to main menu", 0)
                                }),
                        new Endpoint(Utility.RegisterNewEvent, 0),                          //<--3
                        new Endpoint(Utility.FilterByPlace, 0),                             //<--4
                        new Endpoint(Utility.FilterByDate, 0),                              //<--5
                        new Endpoint(Utility.FilterByTimeInterval, 0),                      //<--6
                        new Endpoint(Utility.SortByPlace, 0),                               //<--7
                        new Endpoint(Utility.SortByType, 0),                                //<--8
                        new Endpoint(Utility.SortByTime, 0),                                //<--9
                        new Endpoint(Utility.ExitProgram, 0)                                //<--10
                });
        while(flag)
        {
            a.Run(sc);
        }
    }
    public class Utility
    {
        public static Function RegisterNewEvent = () ->
        {
            System.out.print("Enter name of the new event: ");
            String name = sc.next();
            System.out.print("Enter location of the new event: ");
            String location = sc.next();
            System.out.print("Enter name of the organizer: ");
            String organizer = sc.next();
            System.out.print("Enter the type of event: ");
            String type = sc.next();
            long time;
            time = InputUtil.InputLong("Input the time of the event on long form: ", "You must enter a valid long", sc);
            er.AddNewEvent(name, location, organizer, type, time);
        };
        public static Function FilterByPlace = () ->
        {
            System.out.print("Enter place to filter by: ");
            String place = sc.next();
            System.out.println(new EventRegister(er.GetEventsInSpecificLocation(place)).toString());
        };
        public static Function FilterByDate = () ->
        {
            long date = InputUtil.InputLong("Enter date to filter by on long form: ", "You must ender a valid long", sc);
            System.out.println(new EventRegister(er.GetEventsOnSpecificDate(date)).toString());
        };
        public static Function FilterByTimeInterval = () ->
        {
            long t0 = InputUtil.InputLong("Enter the beginning of the time interval: ", "You must ender a valid long", sc);
            long t1 = InputUtil.InputLong("Enter the end of the time interval: ", "You must ender a valid long", sc);
            System.out.println(new EventRegister(er.GetEventsByTimeInterval(t0, t1)).toString());
        };
        public static Function SortByPlace = () ->
        {
            System.out.println(new EventRegister(er.GetEventsSortedByPlace()).toString());
        };
        public static Function SortByType = () ->
        {
            System.out.println(new EventRegister(er.GetEventsSortedByType()).toString());
        };
        public static Function SortByTime = () ->
        {
            System.out.println(new EventRegister(er.GetEventsSortedByTime()).toString());
        };
        public static Function ExitProgram = () ->
        {
            flag = false;
        };
    }
}