package Karma;
import Eyadistic.Admin;
import Yahia.User;
import x3mara.HasID;

public class Category implements HasID {
    private String catID; //store the ID of each category
    private String catName; // name of the category
    public static int totCats = 0;

    //constructors
    public Category() {              // no arg constructor for initializing (unnecessary but may help later)
        totCats++;

    }

     public Category(String catName) {
        this.catName = catName;
        this.catID = "C" + System.nanoTime();
    }

    //getters & setters
    public String getCatID() {
        return catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        //MUST SEARCH FOR EXISTING CATEGORIES FROM HASHMAP FIRST
        // IF EXISTS, CATEGORY WON'T BE ADDED
        this.catName = catName;
    }

    // CRUD
    public void createCat(String catName, User obj) {
        if (!(obj instanceof Admin)) {
            throw new AccessDenied("You do not have permission to use this method. \n Only Admins are allowed to create categories");
        }


    }


    @Override
    public String getID() {
        return catID;
    }
}
