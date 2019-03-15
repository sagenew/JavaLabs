package studentlab;

public class StudentArray
{
    private Student[] studArr;
    StudentArray(Student [] arr)
    {
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

    public int getSize()
    {
        return studArr.length;
    }
    private Student[] searchForCondition(int condition)
    {
        int arrSize = getSize();
        Student[] bufferArr = new Student[arrSize];
        int resSize = 0;
        for (int i = 0; i < arrSize; i++)
        {
            if(condition == 1)
            {
                if ((studArr[i].getCourseYear() == 2) && (studArr[i].getRating() >= 95))
                {
                    bufferArr[resSize] = studArr[i];
                    resSize++;
                }
            } else {
                if ((studArr[i].getCountry() != "Ukraine") && (studArr[i].getRating() >= 85))
                {
                    bufferArr[resSize] = studArr[i];
                    resSize++;
                }
            }
        }
        Student[] resArr = new Student[resSize];
        System.arraycopy(bufferArr, 0, resArr,  0, resSize);
        return resArr;
    }

    public Student[] getSecondYear()
    {
        Student[] studentArr = searchForCondition(1);
        return studentArr;
    }

    public Student[] getForeignStuds()
    {
        Student[] studentArr = searchForCondition(2);
        return studentArr;
    }
}
