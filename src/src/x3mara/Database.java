package x3mara;

import java.util.ArrayList;
import java.util.HashMap;

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
}