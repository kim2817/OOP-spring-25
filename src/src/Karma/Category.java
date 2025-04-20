package Karma;
import Eyadistic.*;
import Yahia.*;
import x3mara.*;
import Jasmin.*;

import java.util.Arrays;
import java.util.Scanner;

public class Category implements HasID {
    private String catID; //store the ID of each category
    private String catName; // name of the category
    public static int totCats = 0;
    private Event[] events;

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

    public static void listAllCategories(){
        System.out.println(Arrays.toString(Database.readAll(new Category())));
    }

    @Override
    public String toString() {
        return "ID: " + catID + "\n Name: " + catName;
    }


}
