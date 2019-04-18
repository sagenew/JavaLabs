package studentlab.controller;

import studentlab.DataSource;
import studentlab.service.StudentService;
import studentlab.view.StudentShow;
import studentlab.model.StudentArray;
import studentlab.model.Student;
import studentlab.StudentArrJSONFIleOperator;
import java.io.IOException;

public class StudentController {
    private StudentArray studArr;
    private StudentShow view;
    private StudentService service;
    private StudentArrJSONFIleOperator jsonfileop;
    public StudentController() {
//        studArr = new StudentArray(DataSource.getSource());
        jsonfileop = new StudentArrJSONFIleOperator("StudArr.json");
        view = new StudentShow();
        service = new StudentService();
    }

    public void start() {
        studArr = new StudentArray(service.getTable(jsonfileop));
        menu: while (true) {
            view.printMenu();

            Student[] resArr;
            int menuCount = service.getMenuCount(6);
                switch (menuCount) {
                    case 1: {
                        view.showStudArr(studArr.getStudArr());
                        break;
                    }
                    case 2: {
                        resArr = studArr.getSecondYear();
                        view.showStudArr(resArr);
                        service.saveResults(jsonfileop, resArr);
                        break;
                    }
                    case 3: {
                        resArr = studArr.getForeignStuds();
                        view.showStudArr(resArr);
                        service.saveResults(jsonfileop, resArr);
                        break;
                    }
                    case 4: {
                        criterionMenu : while(true) {
                            view.printCriterionMenu();

                            int criterionCount = service.getMenuCount(4);
                            switch (criterionCount) {
                                case 1: {
                                    int course;
                                    view.choosingCriterion(1);
                                    course = service.getCourse();
                                    resArr = studArr.searchByCourse(course);
                                    view.showStudArr(resArr);
                                    service.saveResults(jsonfileop, resArr);
                                    break;
                                }
                                case 2: {

                                    view.choosingCriterion(2);
                                    int[] grades = service.getGrades();
                                    resArr = studArr.searchByGrades(grades[0], grades[1]);
                                    view.showStudArr(resArr);
                                    service.saveResults(jsonfileop, resArr);
                                    break;
                                }
                                case 3: {
                                    view.choosingCriterion(3);
                                    String country = service.getString();
                                    resArr = studArr.searchByCountry(country);
                                    view.showStudArr(resArr);
                                    service.saveResults(jsonfileop, resArr);
                                    break;
                                }
                                case 4: {
                                    break criterionMenu;
                                }
                            }
                        }
                        break;
                    }
                    case 5: {
                        Student newStudent = service.getStudent();
                        studArr.addStudent(newStudent);
                        view.showStudent(newStudent);
                        view.saveStudentRequest();
                        if(service.getAnswer())
                        {
                           service.writeTableIntoFile(jsonfileop,studArr.getStudArr());
                        }
                        break;
                    }
                    case 6: {
                        break menu;
                    }
                }
        }
        view.endOfSessionMessage();
    }

}
