package x3mara;

import java.util.HashMap;
import Karma.DateTime;

public class Schedule {
    private HashMap<DateTime,Boolean> hashMap;
    Schedule(){
        hashMap = new HashMap<>();
    }
    boolean isAvailable(DateTime dateTime){
        return hashMap.get(dateTime) == null;
    }
    void add(DateTime dateTime){
        hashMap.put(dateTime, true);
    }
    void remove(DateTime dateTime){
        hashMap.remove(dateTime);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("{");
        for(DateTime slot:hashMap.keySet()){
            if(!hashMap.get(slot)){
                throw new IllegalStateException("what the fuck?");
            }
            if(ret.length() != 1) ret.append("; ");
            ret.append(slot.toString());
        }
        ret.append("}");
        return ret.toString();
    }
}