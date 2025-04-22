package Karma;
import Eyadistic.*;
import Yahia.*;
import x3mara.*;
import Jasmin.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Category implements HasID {
    private final String catID; //store the ID of each category
    private String catName; // name of the category
    public static int totCats = 0; // stores total number of categories;
    private Event[] events = new Event[100];  // stores events under each category;
    private int numEvents = 0; // stores number of events in each category


    Scanner input = new Scanner(System.in);

    //constructors
    // no-arg constructor
    public Category() {
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

    public Event[] getEvents() {
        return Arrays.copyOf(events, numEvents); // to ignore the null values
    }


    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public final void ValidateCatAccess(User obj){
        if (!(obj instanceof Admin)) {
            throw new AccessDenied("You do not have permission to use this method." +
                    " \n Only Admins are allowed to create categories");
        }
    }
    public void addCatToDatabase(User obj) {
        ValidateCatAccess(obj);
        Database.create(this);
    }
    public void updateCatInDatabase(User obj){
        ValidateCatAccess(obj);
        Database.update(this);
    }
    public void deleteCatFromDatabase(User obj){
        ValidateCatAccess(obj);
        Database.delete(this);
    }

    public static void listAllCategories(){
        System.out.println(Arrays.toString(Database.readAll(new Category())));
    }

    public void addEvent(Event event) {
        if (numEvents > 100) { // to avoid exceeding the limit of the array
            throw new ExceedLimit("You have reached the limit of events for " +
                    "a category");
        }
        else {
            events[numEvents++] = event;
        }
    }

    @Override
    public String toString() {
        return "ID: " + catID + "\n Name: " + catName;
    }

    public boolean equals(Category cat) {
        return this.catName.equals(cat.catName);
    }

}
