package studentlab.view;

import studentlab.model.Student;

public class StudentShow {

    public void printMenu() {
        System.out.println("Please choose what thou would like to search:");
        System.out.println("(1) List of students.");
        System.out.println("(2) List of second year students with excellent rating.");
        System.out.println("(3) List of foreigner students with good or excellent rating.");
        System.out.println("(4) Student search by criterion.");
        System.out.println("(5) Add new student. ");
        System.out.println("Enter (6) if thou would like to finish.");
    }

    public void printCriterionMenu() {
        System.out.println("Please choose by what criterion thou wilt to search:");
        System.out.println("(1) By course.");
        System.out.println("(2) By academic performance.");
        System.out.println("(3) By country of origin.");
        System.out.println("(4) To return to previous menu.");
    }

    public void choosingCriterion(int answer) {
        switch (answer) {
            case 1:
                System.out.println("Enter what course`s students` list thou wilt to search:");
                break;
            case 2:
                System.out.println("Please enter the minimum and the maximum criterion for academical performance for the selection:");
                break;
            case 3:
                System.out.print("Enter the country of origin thou wilt to search by:");
                break;
        }

    }

    public void showStudArr(Student[] studArr) {
        if (studArr.length == 0) {
            System.out.printf("%n%s%n%n",
                    "Students not found.");
            return;
        }
        System.out.printf("%-15s%-15s%-20s%-20s%-10s%-20s%-10s%-10s\n",
                "Surname", "Name", "Patronymic", "Student Card", "Course", "Country", "Sex", "Rating");
        System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        for (Student i : studArr) {
            System.out.println(i);
        }
        System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }

    public void printStudentAttributes(int part)
    {
        if(part == 1) System.out.println("Enter student`s surname:" );
        if(part == 2) System.out.println("Enter student`s name:" );
        if(part == 3) System.out.println("Enter student`s patronymic:" );
        if(part == 4) System.out.println("Enter student`s student card id:" );
        if(part == 5) System.out.println("Enter student`s course:" );
        if(part == 6) System.out.println("Enter student`s country of origin:" );
        if(part == 7) System.out.println("Enter student`s sex:" );
        if(part == 8) System.out.println("Enter student`s rating:" );
    }

    public void showStudent(Student s)
    {
        System.out.print(s.toString()+"\n");
    }

    public void readTableErr(String filename) {
        System.out.println("ERROR: Cannot read the table from file" + filename);
    }

    public void writeTableErr(String filename) {
        System.out.println("ERROR: Cannot write the file" + filename);
    }

    public void saveResultRequest()
    {
        System.out.println("Do thou wilt to save the result?(y/yes): ");
    }

    public void saveStudentRequest()
    {
        System.out.println("Do you want to save the new student?(y/yes: ");
    }

    public void printInvalidInputErr() {
        System.out.printf("%n%s%n%n",
                "ERROR: Incorrect input.");
    }

    public void printInvalidCourse(String message, int course)
    {
        System.out.printf("%n%s%n%s%n%n",
                message,
                "Entered course number: " + course);
    }
    public void printInvalidGrade(String message, int minGrade, int maxGrade)
    {
        System.out.printf("%n%s%n%s%n%s%n%n",
                message,
                "Entered minimal grade criterion: " + minGrade,
                "Entered minimal grade criterion: " + maxGrade);
    }

    public void printInvalidMenuCount(String message, int enteredCount, int maxCount)
    {
        System.out.printf("%n%s%n%s%n%s%n%n",
                message,
                "Entered menu count: " + enteredCount,
                "Maximum menu count : " + maxCount);
    }
    public void endOfSessionMessage()
    {
        System.out.println("Гуменчук Артур, ІП-71, варіянт 14");
    }


}