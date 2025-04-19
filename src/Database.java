import java.util.HashMap;

public class Database {
    private static HashMap<String, Object> data = new HashMap<>();

    public static void create(Object o) {
        if(!(o instanceof hasID)){
            throw new RuntimeException("Invalid Object");
        }
        data.put(((hasID)o).getID(),o);
    }
    public static Object read(String ID){
        Object o = data.get(ID);
        if(o == null){
            throw new RuntimeException("Object Not Found");
        }
        return o;
    }
    public static void update(Object o) {
        if(!(o instanceof hasID)){
            throw new RuntimeException("Invalid Object");
        }
        data.replace(((hasID)o).getID(),o);
    }
    public static void delete(Object o){
        if(!(o instanceof hasID)){
            throw new RuntimeException("Invalid Object");
        }
        data.remove(((hasID)o).getID());
    }
}