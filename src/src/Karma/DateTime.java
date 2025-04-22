package Karma;
import x3mara.*;

public class DateTime {
    // attributes
    private int day;
    private int month;
    private int year;
    public TimeSlot time;
    public DateTime(){}
    public DateTime(int day,int month , int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public DateTime(String DoB){
        this(Integer.parseInt(DoB.substring(0,2)),Integer.parseInt(DoB.substring(3,5)),Integer.parseInt(DoB.substring(6)));
    }
    public static boolean checkFormat(String s){
        if(s.length() != 10) return false;
        System.out.println("hi");
        if(s.charAt(2) != '/' || s.charAt(5) != '/') return false;
        try{
            new DateTime(s);
        }
        catch (RuntimeException e){
            return false;
        }
        return true;
    }
    // setters & getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public TimeSlot getTime() {
        return time;
    }

    public void setDay(int day) {

        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTime(TimeSlot time) {
        this.time = time;
    }

    @Override
    public String toString() {
        String ret = "Day: " + day + "; Month: " + month + "; Year: " + year;
        if(time != null) return ret + "; Time: " + time;
        return ret;
    }
}
