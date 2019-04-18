package studentlab.service;

import studentlab.exceptions.OutOfRangeException;

public class StudentSearchCriterionException {
    public static void checkMenuCount(int menuCount, int maxCount) throws OutOfRangeException {
        if((menuCount > maxCount) || (menuCount < 1)) {
            throw new OutOfRangeException("ERROR: Invalid menu count entered.", menuCount, maxCount);
        }
    }
    public static void checkCourse(int course) throws OutOfRangeException {
        if((course > 7) || (course < 1)){
            throw new OutOfRangeException("ERROR: Invalid course number entered.", course);
        }
    }
    public static void checkGrades(int min, int max) throws OutOfRangeException {
        if(((min > 100) || (max < 0)) && ((max > 100) || (max < 0))) {
            throw new OutOfRangeException("ERROR: Invalid minimal AND maximum academical performance number entered.", min, max);
        }
        if((min > 100) || (min < 0)){
            throw new OutOfRangeException("ERROR: Invalid minimal academical performance number entered.", min, max);
        }
        if((max > 100) || (max < 0)){
            throw new OutOfRangeException("ERROR: Invalid maximum academical performance number entered.", min, max);
        }
        if(min > max ) {
            throw new OutOfRangeException("ERROR: Entered minimum value is bigger than the maximum value.", min, max);
        }
    }
}
