import Eyadistic.Admin;
import Karma.DateTime;
import Omar.Attendee;
import Yahia.*;
import x3mara.Database;
import x3mara.Room;
import x3mara.Schedule;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String[] options1 = new String[]{"Register","Login","Exit"};
    static Scanner in = new Scanner(System.in);
    public static void screen1(){
        System.out.println("Choose an option:");
        for(int i=0;i<options1.length;i++){
            System.out.println((i+1) + ") " + options1[i]);
        }
        boolean flag = false;
        int choice = in.nextInt();
        if(choice < 1 || choice >= options1.length){
            throw new InputMismatchException("Input should be inbounds.");
        }
        switch (choice){
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3:
                break;
        }
    }
    public static void register(){
        Scanner in = new Scanner(System.in);
        System.out.print("Choose account type (0 for attendee; 1 for organizer): ");
        int classChoice = in.nextInt();
        System.out.print("Email: ");
        String email = in.next();
        System.out.print("Username: ");
        String username = in.next();
        System.out.print("Password: ");
        String password = in.next();
        do{
            System.out.print("Confirm Password: ");
        }while(!in.next().equals(password));
        System.out.print("Contact Number: ");
        String contactNo = in.next();
        System.out.print("Date of Birth (in dd/mm/yyyy): ");
        String DoB = in.next();
        while(!DateTime.checkFormat(DoB)){
            System.out.print("Wrong Format. Please use (dd/mm/yyyy): ");
            DoB = in.next();
        }
        System.out.print("Address: ");
        String address = in.next();
        System.out.print("Choose gender (true for MALE and false for female): ");
        Gender gender = in.nextBoolean()?Gender.MALE:Gender.FEMALE;
        if(classChoice == 1){ // organizer
            Database.create(new Organizer(email,username,contactNo,password,new DateTime(DoB),address,0.0,gender,new Schedule()));
        }
        else if(classChoice == 0){ // attendee
            Database.create(new Attendee(email,username,contactNo,password,new DateTime(DoB),address,gender,0,"Default City",new int[0][0],0.0));
        }
        else throw new RuntimeException("Unexpected Class Choice.");
        System.out.println("Registered Successfully");
        screen1();
    }
    public static void login(){
        System.out.print("Username: ");
        String username = in.next();
        System.out.print("Password: ");
        String password = in.next();
        int ret = Database.findUser(username,password);
        switch (ret){
            case 0:
                System.out.println("Incorrect Username/Password.");
                screen1();
                break;
            case 1:
                System.out.println("Welcome Mr. Attendee");
//                attendeeInterface();
                break;
            case 2:
                System.out.println("Welcome Mr. Organizer");
//                organizerInterface();
                break;
            case 3:
                System.out.println("Welcome Mr. Admin");
//                adminInterface();
                break;
        }
    }
    public static void main(String[] args){
        Database.scanInput(new File("DataToInput.txt"));
//        System.out.println(Arrays.toString(Database.readAll(new Attendee())));
//        screen1();
        Room.createRoom(new Admin());
    }
}