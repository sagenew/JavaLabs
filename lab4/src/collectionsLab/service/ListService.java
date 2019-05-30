package collectionsLab.service;

import collectionsLab.exceptions.ListException;
import collectionsLab.exceptions.OutOfRangeException;
import collectionsLab.model.ListModel;
import collectionsLab.view.ListView;
import java.util.List;

public class ListService {
    private ListView view;
    private InputData consoleReader;
    private DataSource data;
    public ListService() {
        view = new ListView();
        consoleReader = new InputData();
        data = new DataSource();
    }
    InputData getConsoleReader(){
        return consoleReader;
    }
    ListView getView() {
        return view;
    }
    public List getExampleList(){
        return data.exampleList();
    }
    public List getRandomList(){
        return data.randomList(this);
    }
    public List getCreatedList(){
        view.printMsg(ListView.PRINT_LIST_CREATION_MSG);
        return data.createdList(this);
    }
    public int initMenu() {
        try {
            view.printInitMenu();
            int menuCount = consoleReader.scanData();
            ListException.checkMenuCount(menuCount,4);
            return menuCount;
        } catch (NumberFormatException e) {
            view.printMsg(ListView.INVALID_INPUT_MSG);
            view.printMsg(ListView.PRINT_LINE);
            return 0;
        } catch (OutOfRangeException e) {
            view.printWrongValueEntered(e.getMessage(),e.getNum(), 1,e.getNum2());
            view.printMsg(ListView.PRINT_LINE);
            return 0;
        }
    }
    int getListSize() {
        while (true) {
            try {
                view.printListSizeRequest();
                int listSize = consoleReader.scanData();
                ListException.checkListSize(listSize);
                return listSize;
            } catch (NumberFormatException e) {
                view.printMsg(ListView.INVALID_INPUT_MSG);
                view.printMsg(ListView.PRINT_LINE);
            } catch (OutOfRangeException e) {
                view.printWrongValueEntered(e.getMessage(), e.getNum(), 1, 100);
                view.printMsg(ListView.PRINT_LINE);
            }
        }
    }
    public int processMenu() {
        try {
            view.printProcessMenu();
            int menuCount = consoleReader.scanData();
            ListException.checkMenuCount(menuCount,5);
            return menuCount;
        } catch (NumberFormatException e) {
            view.printMsg(ListView.INVALID_INPUT_MSG);
            view.printMsg(ListView.PRINT_LINE);
            return 0;
        } catch (OutOfRangeException e) {
            view.printWrongValueEntered(e.getMessage(),e.getNum(), 1,e.getNum2());
            view.printMsg(ListView.PRINT_LINE);
            return 0;
        }
    }
    public void processList(ListModel model) {
        view.printMsg(ListView.PRINT_LIST_MSG);
        view.printListInfo(model.getDividerPos(),model.getListSize());
        view.printList(model.getList());
        view.printMsg(ListView.PRINT_LINE);
        view.printMsg(ListView.PRINT_DIVIDED_MSG);
        view.printList(model.getList1());
        view.printList(model.getList2());
        view.printMsg(ListView.PRINT_LINE);
        model.sortLists();
        view.printMsg(ListView.LIST_SORTED_MSG);
        view.printList(model.getList1());
        view.printList(model.getList2());
        view.printMsg(ListView.PRINT_LINE);
    }
    public void changeDividerPosition(ListModel model) {
        while (true) {
            try {
                view.printMsg(ListView.PRINT_NEW_DIVIDER_POS_MSG);
                int newPos = consoleReader.scanData();
                ListException.checkDividerPosition(newPos, model.getListSize());
                model.changeDividerPos(newPos);
                view.printMsg(ListView.PRINT_LINE);
                break;
            } catch (NumberFormatException e) {
                view.printMsg(ListView.INVALID_INPUT_MSG);
                view.printMsg(ListView.PRINT_LINE);
            } catch (OutOfRangeException e) {
                view.printWrongValueEntered(e.getMessage(), e.getNum(), 0, e.getNum2());
                view.printMsg(ListView.PRINT_LINE);
            }
        }
    }
    public void getEndOfWorkMessage() {
        view.printMsg(ListView.END_OF_WORK);
    }
}
