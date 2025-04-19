import java.util.HashMap;
import java.util.Date;

public class Schedule {
    private HashMap<Object[],Boolean> hashMap;
    Schedule(){
        hashMap = new HashMap<>();
    }
    boolean isAvailable(Date date, TimeSlot timeSlot){
        return hashMap.get(new Object[]{date, timeSlot});
    }
    void add(Date date, TimeSlot timeSlot){
        hashMap.put(new Object[]{date, timeSlot}, true);
    }
    void remove(Date date, TimeSlot timeSlot){
        hashMap.remove(new Object[]{date, timeSlot});
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("{");
        for(Object[] slot:hashMap.keySet()){
            if(!hashMap.get(slot)){
                throw new IllegalStateException("what the fuck?");
            }
            ret.append((String)(slot[0] + " @ " + slot[1]));
        }
        ret.append("}");
        return ret.toString();
    }
}