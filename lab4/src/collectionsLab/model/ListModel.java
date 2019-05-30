package collectionsLab.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListModel {
    private List<Integer> list;
    private List<Integer> list1;
    private List<Integer> list2;

    public ListModel(List<Integer> list) {
        this.list = new ArrayList<>(list);
        list1 = list.subList(0, getDividerPos());
        list2 = list.subList(getDividerPos() + 1, list.size());
    }
    public void sortLists() {
        Collections.sort(list1);
        Collections.reverse(list1);
        Collections.sort(list2);
        Collections.reverse(list2);
    }
    public void changeDividerPos(int newDividerPost) {
        list.remove(getDividerPos());
        list.add(newDividerPost, 0);
    }
    public List getList() {
        return list;
    }
    public List getList1() {
        return list1;
    }
    public List getList2() {
        return list2;
    }
    public int getDividerPos() {
        return list.indexOf(0);
    }
    public int getListSize() {
        return list.size();
    }
}
