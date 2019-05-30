package collectionsLab.view;

import java.util.List;


public class ListView {
    public void printInitMenu() {
        System.out.println("Please choose what thou would like to do:");
        System.out.println("(1) Get example list.");
        System.out.println("(2) Generate random list.");
        System.out.println("(3) Create your own list.");
        System.out.println("Enter (4) if thou would like to finish.");
    }

    public void printListSizeRequest() {
        System.out.println("Please type the list`s size to be generated:");
    }
    public void printProcessMenu() {

        System.out.println("(1) Change divider position.");
        System.out.println("(2) Finish.");
    }

    public void printList(List list) {
        System.out.println(list);
    }

    public void printListInfo(int pos, int size) {
        System.out.print(String.format("%s%s%s%s%n","Divider position: ", pos, ", list`s size: ", size));
    }

    public void printWrongValueEntered(String message, int value, int minValue, int maxValue) {
        System.out.print(String.format("%s%n%s%s%n%s%s%s%s%n",message,"Wrong value entered: ", value, "Min value possible: ", minValue, ", max value possible: ", maxValue));
    }

    public void printMsg(String msg) {
        System.out.print(msg);
    }

    public static final String PRINT_LIST_MSG = String.format("%s%n%s%n","List","——————————————————————————————————————————————————————");
    public static final String PRINT_DIVIDED_MSG = String.format("%s%n%s%n","Divided Lists","——————————————————————————————————————————————————————");
    public static final String LIST_SORTED_MSG = String.format("%s%n%s%n", "Lists sorted.","——————————————————————————————————————————————————————");
    public static final String PRINT_LIST_CREATION_MSG = String.format("%s%n","Please, initiate list`s elements (type \"N\" to finish): ");
    public static final String PRINT_DIVIDER_POS_MSG = String.format("%s%n","Please, enter divider`s position: ");
    public static final String PRINT_NEW_DIVIDER_POS_MSG = String.format("%s%n","Please, enter new divider`s position: ");
    public static final String PRINT_LINE = String.format("%s%n","——————————————————————————————————————————————————————");
    public static final String TRY_AGAIN_MESSAGE = String.format("%s%n","Please, try again: ");
    public static final String TRY_AGAIN_DVD_MESSAGE = String.format("%s%n","Please, try again (divider position has to be between 0 and list`s size): ");
    public static final String INVALID_INPUT_MSG = String.format("%n%s%n","ERROR: Invalid input.");
    public static final String END_OF_WORK = String.format("%s%n","Гуменчук А.О., ІП-71, Варіант 14");
}
