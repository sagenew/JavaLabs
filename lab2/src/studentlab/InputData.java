package studentlab;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputData {
    private Scanner src;

    public InputData() {
        src = new Scanner(System.in);
    }

    public int scanData() throws NumberFormatException, InputMismatchException {
        int result = Integer.parseInt(src.nextLine());
        //src.nextLine();
        return result;
    }

    public String scanLine() {
        return src.nextLine();

    }
}
