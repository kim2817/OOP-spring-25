package BackEnd;

public enum TimeSlot{
    MORNING,
    AFTERNOON,
    EVENING;
    public static TimeSlot translate(int x){
        return switch (x) {
            case 0 -> TimeSlot.MORNING;
            case 1 -> TimeSlot.AFTERNOON;
            case 2 -> TimeSlot.EVENING;
            default -> null;
        };
    }
}