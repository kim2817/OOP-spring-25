package BackEnd;

import java.util.Scanner;

public class Entrance {


    public static void registerOrganizer(String email, String username, String password,
                               String DOB,boolean gender,double walletBalance){
        Gender gen= gender?Gender.FEMALE:Gender.MALE;
        Database.create(new Organizer(email,username,password,new DateTime(DOB),gen,walletBalance));
    }

    public static void registerAttendee(String email, String username, String password,
                                         String DOB,boolean gender,int age, String address, double walletBalance){
        Gender gen= gender?Gender.FEMALE:Gender.MALE;
        Database.create(new Attendee(email, username, password, new DateTime(DOB),gen, age, address, walletBalance));
    }

    public static int login(String username, String password){

        User curUser = Database.findUser(username, password);
        int ret = 1;
        if(curUser instanceof Attendee) ret=2;
        if(curUser instanceof Organizer) ret=3;
        if(curUser instanceof Admin) ret=4;
        return switch (ret) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            case 4 -> 4;
            default -> -1;
        };

    }
}
