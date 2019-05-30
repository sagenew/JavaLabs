package collectionsLab.service;

import java.util.Scanner;

class InputData {
    private Scanner src;
    InputData() {
        src = new Scanner(System.in);
    }
    int scanData() throws NumberFormatException {
        return Integer.parseInt(src.nextLine());
    }
    String scanString() {
        return src.nextLine();
    }
}
