package BackEnd;

public class ExceedLimit extends RuntimeException {
    public ExceedLimit(String message) {
        super(message);
    }
}
