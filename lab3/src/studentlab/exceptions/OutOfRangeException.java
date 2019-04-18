package studentlab.exceptions;

public class OutOfRangeException extends Exception {
    private int outOfRangeNum;
    private int outOfRangeNum2;
    public OutOfRangeException(String error, int outOfRangeNum) {
        super(error);
        this.outOfRangeNum = outOfRangeNum;
    }
    public OutOfRangeException(String error, int outOfRangeNum, int outOfRangeNum2) {
        super(error);
        this.outOfRangeNum = outOfRangeNum;
        this.outOfRangeNum2 = outOfRangeNum2;
    }
    public int getNum () {
        return outOfRangeNum;
    }
    public int getNum2 () {
        return outOfRangeNum2;
    }
}
