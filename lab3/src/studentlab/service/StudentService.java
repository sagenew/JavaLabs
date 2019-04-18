package studentlab.service;
import studentlab.StudentArrJSONFIleOperator;
import studentlab.exceptions.OutOfRangeException;
import studentlab.model.StudentArray;
import studentlab.view.StudentShow;
import studentlab.model.Student;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StudentService {
    private StudentShow view;
    private InputData consoleReader;
    public StudentService() {
        consoleReader = new InputData();
        view = new StudentShow();
    }

    public int getMenuCount(int maxCount) {
        try {
            int menuCount = consoleReader.scanData();
            StudentSearchCriterionException.checkMenuCount(menuCount, maxCount);
            return menuCount;
        } catch (NumberFormatException e) {
            view.printInvalidInputErr();
            return 0;
        } catch (OutOfRangeException e) {
            view.printInvalidMenuCount(e.getMessage(), e.getNum(), e.getNum2());
            return 0;
        }
    }


    public int getCourse() {
        try {
            int course = consoleReader.scanData();
            StudentSearchCriterionException.checkCourse(course);
            return course;
        } catch (NumberFormatException e) {
            view.printInvalidInputErr();
            return getCourse();
        } catch (OutOfRangeException e) {
            view.printInvalidCourse(e.getMessage(), e.getNum());
            return getCourse();
        }
    }
    public int[] getGrades() {
        int[] grades = new int [2];
        try {
            grades[0] = consoleReader.scanData();
            grades[1] = consoleReader.scanData();
            StudentSearchCriterionException.checkGrades(grades[0], grades[1]);
            return grades;
        } catch (NumberFormatException e) {
            view.printInvalidInputErr();
            grades[0] = -100;
            return getGrades();
        } catch (OutOfRangeException e) {
            view.printInvalidGrade(e.getMessage(), e.getNum(), e.getNum2());
            grades[0] = -100;
            return getGrades();
        }
    }
    public String getString() {
        String str = consoleReader.scanLine();
        return str;
    }

    public Student[] getTable(StudentArrJSONFIleOperator jsonfileop) {
        try {
            StudentArray studArr = new StudentArray(jsonfileop.read());
            return studArr.getStudArr();
        } catch (IOException e) {
            view.readTableErr(jsonfileop.getReadFilePath());
            System.exit(-1);
            return null;
        }
    }

    public void writeTableIntoFile(StudentArrJSONFIleOperator jsonfileop, Student[] studArr) {
            try {
                jsonfileop.write(studArr);
            } catch (IOException e) {
                view.writeTableErr(jsonfileop.getWriteFilePath());
            }
    }

    public void saveResults(StudentArrJSONFIleOperator jsonfileop, Student[] resultArr) {
        if(resultArr == null || resultArr.length == 0) {
            return;
        }
        view.saveResultRequest();
        if(getAnswer()) {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            try {
                jsonfileop.write(resultArr, "Results-" + dateFormat.format(new Date()) + ".json");
            } catch (IOException e) {
                view.writeTableErr(jsonfileop.getWriteFilePath());
            }
        }
    }
    public Student getStudent() {
        Student s = new Student();
        view.printStudentAttributes(1);
        s.setSurname(consoleReader.scanLine());
        view.printStudentAttributes(2);
        s.setName(consoleReader.scanLine());
        view.printStudentAttributes(3);
        s.setPatronymic(consoleReader.scanLine());
        view.printStudentAttributes(4);
        s.setStudentCard(consoleReader.scanLine());
        view.printStudentAttributes(5);
        s.setCourseYear(consoleReader.scanData());
        view.printStudentAttributes(6);
        s.setCountry(consoleReader.scanLine());
        view.printStudentAttributes(7);
        s.setSex(consoleReader.scanLine());
        view.printStudentAttributes(8);
        s.setRating(consoleReader.scanData());
        return s;
    }

    public boolean getAnswer() {
        String answer = consoleReader.scanLine();
        if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) return true; return false;
    }
}
