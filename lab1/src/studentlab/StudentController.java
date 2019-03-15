package studentlab;

public class StudentController
{
    private StudentArray studArr;
    private StudentShow studShow;
    StudentController()
    {
        studArr = new StudentArray(DataSource.getSource());
        studShow = new StudentShow();
    }

    public void start()
    {
        menu: while (true)
        {
            studShow.printMenu();
            String answer = InputData.scanData();
            switch (answer)
            {
                case "1": studShow.showStudArr(studArr.getStudArr()); break;
                case "2": studShow.showStudArr(studArr.getSecondYear()); break;
                case "3": studShow.showStudArr(studArr.getForeignStuds()); break;
                case "4": break menu;
                default: System.out.println("Please try again.");
            }
        }
        System.out.println("Гуменчук Артур Олегович, ІП-71");
    }
}
