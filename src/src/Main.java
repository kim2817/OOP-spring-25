import x3mara.*;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Database.scanInput(new File("DataToInput.txt"));
        System.out.println(Arrays.toString(Database.readAll(new Wallet())));
    }
}
