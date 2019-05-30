package collectionsLab.exceptions;

public class ListException {
    public static void checkMenuCount(int menuCount, int maxCount) throws OutOfRangeException {
        if((menuCount > maxCount) || (menuCount < 1)) {
            throw new OutOfRangeException("ERROR: Invalid menu count entered.", menuCount, maxCount);
        }
    }
    public static void checkListSize(int listSize) throws OutOfRangeException {
        if((listSize <= 0)||( listSize > 100)) {
            throw new OutOfRangeException("ERROR: Invalid list size entered.", listSize);
        }
    }
    public static void checkDividerPosition(int dividerPos, int listSize) throws OutOfRangeException {
        if((dividerPos < 0) || (dividerPos > listSize)) {
            throw new OutOfRangeException("ERROR: Invalid new divider position entered.", dividerPos, listSize);
        }
    }
}
