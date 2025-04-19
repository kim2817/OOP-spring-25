public class Category {
    private int catID; //store the ID of each category
    private String catName;  // name of the category

    //constructors
    Category() {              // no arg constructor for initializing (unnecessary but may help later)
        this.catID = -1;    // so we detect unassigned category IDs later
        this.catName = "";  // to avoid null pointer exceptions later
    }

    Category(String catName) {
        this.catName = catName;
    }

    //getters & setters
    public int getCatID() {
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
        // EYAD's method

    }


}
