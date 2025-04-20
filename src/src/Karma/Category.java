package Karma;
import Eyadistic.*;
import Yahia.*;
import x3mara.*;
import Jasmin.*;

import java.util.Arrays;
import java.util.Scanner;

public class Category implements HasID {
    private final String catID; //store the ID of each category
    private String catName; // name of the category
    public static int totCats = 0;
    private Event[] events = new Event[100]; // or any reasonable size
    private int numEvents = 0;


    Scanner input = new Scanner(System.in);

    //constructors
    // no-arg constructor
    public Category() {
        System.out.print("Enter category name: ");
        catName = input.nextLine();
        this.catName = catName;
        this.catID = "C" + System.nanoTime();
        totCats++;
    }

    // Arg constructor
    public Category(String catName) {
        this.catName = catName;
        this.catID = "C" + System.nanoTime();
        totCats++;
    }

    //getters & setters
    public String getID(){
        return catID;
    }
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public static void listAllCategories(){
        System.out.println(Arrays.toString(Database.readAll(new Category())));
    }

    public void addEvent(Event event) {
        if (numEvents > 100) { // to avoid exceeding the limit of the array
            throw new ExceedLimit("You have reached the limit of events for a category");
        }
        else {
            events[numEvents++] = event;
        }
    }

    @Override
    public String toString() {
        return "ID: " + catID + "\n Name: " + catName;
    }


}
