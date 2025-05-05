package BackEnd;

import java.util.HashMap;

public class Schedule {
    private HashMap<DateTime,Event> hashMap;
    public Schedule(){
        hashMap = new HashMap<>();
    }
    public boolean isAvailable(DateTime dateTime){
        return hashMap.get(dateTime) == null;
    }
    public void add(DateTime dateTime, Event event){
        hashMap.put(dateTime, event);
    }
    public void remove(DateTime dateTime){
        hashMap.remove(dateTime);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("{");
        for(DateTime slot:hashMap.keySet()){
            if(ret.length() != 1) ret.append("; ");
            ret.append((String)("{Slot: " + slot.toString() + "; Event: " + hashMap.get(slot).getID() + "}"));
        }
        ret.append("}");
        return ret.toString();
    }
}