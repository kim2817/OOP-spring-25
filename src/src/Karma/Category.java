package Karma;
import Eyadistic.*;
import Yahia.*;
import x3mara.*;

import java.util.Arrays;

public class Category implements HasID {
    private String catID; //store the ID of each category
    private String catName; // name of the category
    public static int totCats = 0;


    //constructors
    public Category() {              // no arg constructor
        totCats++;
    }

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
        // IF EXISTS, CATEGORY WON'T BE ADDED
        this.catName = catName;
    }

    protected final void ValidateCategoryAccess(User obj){  // method that throws exception if someone other than admin tries to use the method
        if (!(obj instanceof Admin)) {
            throw new AccessDenied("You do not have permission to use this method. \n Only Admins are allowed to modify categories");
        }
    }
    // CRUD
    public void createCat(User obj) {
        ValidateCategoryAccess(obj);
        Database.create(this);
    }
    public void updateCat(User obj){
        ValidateCategoryAccess(obj);
        Database.update(this);
    }
    public void deleteCat(User obj){
        ValidateCategoryAccess(obj);
        Database.delete(this);
    }
    public static void listAllCategories(){

    }

    @Override
    public String toString() {
        return "ID: " + catID + "\n Name: " + catName;
    }





}
