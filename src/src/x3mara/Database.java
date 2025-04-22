package x3mara;

import Eyadistic.Admin;
import Jasmin.Event;
import Karma.Category;
import Karma.DateTime;
import Omar.Attendee;
import Yahia.Organizer;
import Yahia.Gender;
import Yahia.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Database {
    private static HashMap<String, Object> data = new HashMap<>();
    public static void create(Object o) {
        if(!(o instanceof HasID)){
            throw new RuntimeException("Invalid Object");
        }
        data.put(((HasID)o).getID(),o);
    }
    public static Object read(String ID){
        Object o = data.get(ID);
        if(o == null){
            throw new RuntimeException("Object Not Found");
        }
        return o;
    }
    public static Object[] readAll(Object o){
        ArrayList<Object> ret = new ArrayList<>();
        for(String ID:data.keySet()){
            if(!(o.getClass()).equals((data.get(ID)).getClass())) continue;
            ret.add(data.get(ID));
        }
        return ret.toArray();
    }
    public static void update(Object o) {
        if(!(o instanceof HasID)){
            throw new RuntimeException("Invalid Object");
        }
        data.replace(((HasID)o).getID(),o);
    }
    public static void delete(Object o){
        if(!(o instanceof HasID)){
            throw new RuntimeException("Invalid Object");
        }
        data.remove(((HasID)o).getID());
    }
    public static int findUser(String username, String password){
        Object[] A = readAll(new Attendee());
        for(Object o:A) {
            if(((Attendee)o).getUsername().equals(username)
                    && ((Attendee)o).getPassword().equals(password)) return 1;
        }
        A = readAll(new Organizer());
        for(Object o:A) {
            if(((Organizer)o).getUsername().equals(username)
                    && ((Organizer)o).getPassword().equals(password)) return 2;
        }
        A = readAll(new Admin());
        for(Object o:A) {
            if(((Admin)o).getUsername().equals(username)
                    && ((Admin)o).getPassword().equals(password)) return 3;
        }
        return 0;
    }
    public static void scanInput(File source) {
        Scanner in;
        try{
            in = new Scanner(source);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String s = in.next();
        while(!s.equals("*")){
            System.out.println(s);
            switch (s){
                case "Wallet":
                    create(new Wallet(in.nextDouble()));
                    break;
                case "Room":
                    create(new Room(in.next(),in.nextInt(),in.nextDouble(),in.next()));
                    break;
                case "Attendee":
                    create(new Attendee(in.next(),in.next(),in.next(),in.next(),null,in.next(),(in.nextBoolean()? Gender.MALE : Gender.FEMALE),in.nextInt(),in.next(),new int[0][0],in.nextDouble()));
                    break;
                case "Organizer":
                    create(new Organizer(in.next(),in.next(),in.next(),in.next(),null,in.next(),in.nextDouble(),(in.nextBoolean()? Gender.MALE : Gender.FEMALE),new Schedule()));
                    break;
                case "Admin":
                    create(new Admin(in.next(),in.next(),in.next(),in.next(),null,in.next(),(in.nextBoolean()? Gender.MALE : Gender.FEMALE),in.next(),in.next()));
                    break;
                case "Category":
                    create(new Category(in.next()));
                    break;
                case "Event":
                    create(new Event(in.next(),(Category)random(new Category()),(Room)random(new Room()),(Organizer)random(new Organizer()),in.nextDouble(),in.nextDouble(),new DateTime(),TimeSlot.translate(in.nextInt())));
            }
            s = in.next();
        }
        in.close();
    }

    private static Object random(Object o){
        Object[] ret = readAll(o);
        return ret[(int)(Math.random()*ret.length)];
    }
}