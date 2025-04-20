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

}
