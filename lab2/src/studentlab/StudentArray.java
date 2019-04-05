package studentlab;

public class StudentArray {
    private Student[] studArr;
    StudentArray(Student[] arr) {
        this.studArr = arr;
    }
    public void setStudArr(Student[] studArr)
    {
        this.studArr = studArr;
    }
    public Student[] getStudArr()
    {
        return studArr;
    }

    private Student[] searchForCondition(int condition) {
        Student[] bufferArr = new Student[studArr.length];
        int resSize = 0;
        for (int i = 0; i < studArr.length; i++) {
            if(condition == 1) {
                if ((studArr[i].getCourseYear() == 2) && (studArr[i].getRating() >= 95)) {
                    bufferArr[resSize] = studArr[i];
                    resSize++;
                }
            } else {
                if (!(studArr[i].getCountry().equals("Ukraine")) && (studArr[i].getRating() >= 85)) {
                    bufferArr[resSize] = studArr[i];
                    resSize++;
                }
            }
        }
        Student[] resArr = new Student[resSize];
        System.arraycopy(bufferArr, 0, resArr,  0, resSize);
        return resArr;
    }

    public Student[] getSecondYear() {
        return searchForCondition(1);
    }

    public Student[] getForeignStuds() {
        return searchForCondition(2);
    }

    public Student[] searchByCourse(int course) {
        Student[] bufferArr = new Student[studArr.length];
        int resSize = 0;
        for (int i = 0; i < studArr.length; i++) {
                if (studArr[i].getCourseYear() == course) {
                bufferArr[resSize] = studArr[i];
                resSize++;
            }

        }
        Student[] resArr = new Student[resSize];
        System.arraycopy(bufferArr, 0, resArr,  0, resSize);
        return resArr;
    }

    public Student[] searchByCountry(String country) {
        Student[] bufferArr = new Student[studArr.length];
        int resSize = 0;
        for (int i = 0; i < studArr.length; i++) {
            if (studArr[i].getCountry().equals(country)) {
                bufferArr[resSize] = studArr[i];
                resSize++;
            }
        }
        Student[] resArr = new Student[resSize];
        System.arraycopy(bufferArr, 0, resArr,  0, resSize);
        return resArr;
    }

    public Student[] searchByGrades(int min, int max) {
        Student[] bufferArr = new Student[studArr.length];
        int resSize = 0;
        for (int i = 0; i < studArr.length; i++) {
            if ((studArr[i].getRating() >= min) && (studArr[i].getRating() <= max)) {
                bufferArr[resSize] = studArr[i];
                resSize++;
            }
        }
        Student[] resArr = new Student[resSize];
        System.arraycopy(bufferArr, 0, resArr,  0, resSize);
        return resArr;
    }

}
