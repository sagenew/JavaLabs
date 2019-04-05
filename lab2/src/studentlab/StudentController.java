package studentlab;

import studentlab.exceptions.OutOfRangeException;
import studentlab.exceptions.StudentSearchCriterionException;

public class StudentController {
    private StudentArray studArr;
    private StudentShow view;
    private InputData consoleReader;
    StudentController() {
        studArr = new StudentArray(DataSource.getSource());
        view = new StudentShow();
        consoleReader = new InputData();
    }

    public void start() {
        menu: while (true) {
            view.printMenu();

            int menuCount;

            try {
                menuCount = consoleReader.scanData();
            } catch (NumberFormatException e) {
                view.printInvalidInputErr();
                continue;
            }
                switch (menuCount) {
                    case 1: {
                        view.showStudArr(studArr.getStudArr());
                        break;
                    }
                    case 2: {
                        view.showStudArr(studArr.getSecondYear());
                        break;
                    }
                    case 3: {
                        view.showStudArr(studArr.getForeignStuds());
                        break;
                    }
                    case 4: {
                        criterionMenu : while(true) {
                            view.printCriterionMenu();
                            int criterionCount = consoleReader.scanData();

                            switch (criterionCount) {
                                case 1: {
                                    int course;
                                    view.choosingCriterion(1);

                                    try {
                                        course = consoleReader.scanData();
                                        StudentSearchCriterionException.checkCourse(course);
                                    } catch (NumberFormatException e) {
                                        view.printInvalidInputErr();
                                        break;
                                    } catch (OutOfRangeException e) {
                                        view.printInvalidCourse(e.getMessage(), e.getNum());
                                        break;
                                    }
                                    view.showStudArr(studArr.searchByCourse(course));
                                    break;
                                }
                                case 2: {
                                    int minGrade, maxGrade;
                                    view.choosingCriterion(2);

                                    try {
                                        minGrade = consoleReader.scanData();
                                        maxGrade = consoleReader.scanData();
                                        StudentSearchCriterionException.checkGrades(minGrade, maxGrade);

                                    } catch (NumberFormatException e) {
                                        view.printInvalidInputErr();
                                        break;
                                    } catch (OutOfRangeException e) {
                                        view.printInvalidGrade(e.getMessage(), e.getNum(), e.getNum2());
                                        break;
                                    }
                                    view.showStudArr(studArr.searchByGrades(minGrade, maxGrade));
                                    break;
                                }
                                case 3: {
                                    view.choosingCriterion(3);
                                    String country = consoleReader.scanLine();
                                    view.showStudArr(studArr.searchByCountry(country));
                                    break;
                                }
                                case 4: {
                                    break criterionMenu;
                                }
                                default: view.printInvalidInputErr();
                            }
                        }
                        break;
                    }
                    case 5: {
                        break menu;
                    }
                    default: view.printInvalidInputErr();
                }
        }
        System.out.println("Гуменчук Артур Олегович, ІП-71");
    }
}
