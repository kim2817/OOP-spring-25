package BackEnd;

public class FundsNOTenough extends RuntimeException {
    public FundsNOTenough(String message) {
        super(message);
    }
}
