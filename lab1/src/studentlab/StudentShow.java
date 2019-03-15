package studentlab;

public class StudentShow
{

    public void printMenu()
    {
        System.out.println("Please choose what thou would like to search:");
        System.out.println("(1) List of students;");
        System.out.println("(2) List of second year students with excellent rating;");
        System.out.println("(3) List of foreigner students with good or excellent rating.");
        System.out.println("Enter (4) if thou would like to finish.");
    }

    public void showStudArr(Student[] studArr)
    {
        System.out.printf("%-15s%-15s%-20s%-20s%-10s%-20s%-10s%-10s\n",
                "Surname", "Name", "Patronymic", "Student Card", "Course", "Country", "Sex", "Rating");
        System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        for (Student i : studArr)
        {
            if(i != null)
            {
                String StudStr = i.toString();
                System.out.println(StudStr);
            } else {
                System.out.println("The array is empty.");
                break;
            }
        }
        System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }
}
