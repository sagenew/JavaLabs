package collectionsLab.service;
import collectionsLab.view.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DataSource {
    List exampleList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(0);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        return list;
    }

    private Integer generateInt(int upperBound){
        Random random = new Random();
        return random.nextInt(upperBound);
    }
    List randomList(ListService service) {
        boolean Divided = false;
        int listSize = service.getListSize();
        List<Integer> list = new ArrayList<>();
        if(listSize == 1) {
            list.add(0,0);
            return list;
        }
        for (int i = 0; i < listSize; i++) {
            Integer newEl = generateInt(100);
            if (newEl == 0 && Divided) {
                listSize++;
                continue;
            } else if (newEl == 0){
                Divided = true;
            }
            list.add(newEl);
        }
        if (!Divided) {
            list.add(generateInt(list.size()),0);
            list.remove(generateInt(list.size())-1);
        }
        return list;
    }
    private static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    List createdList(ListService service) {
        boolean hasDivider = false;
        List<Integer> list = new ArrayList<>();
        while (true) {
            String scannedData = service.getConsoleReader().scanString();
            if (isNumeric(scannedData)) {
                int scannedInt = Integer.parseInt(scannedData);
                list.add(scannedInt);
                if(scannedInt == 0) hasDivider = true;
            } else if(!isNumeric(scannedData) && scannedData.equals("N")) {
                break ;
            } else {
                service.getView().printMsg(ListView.TRY_AGAIN_MESSAGE);
            }
        }
        if(!hasDivider) {
            while (true) {
                service.getView().printMsg(ListView.PRINT_DIVIDER_POS_MSG);
                String scannedDividerPos = service.getConsoleReader().scanString();
                if (!isNumeric(scannedDividerPos)) {
                    service.getView().printMsg(ListView.TRY_AGAIN_DVD_MESSAGE);
                    continue;
                }
                int scannedDividerPosInt = Integer.parseInt(scannedDividerPos);
                if (scannedDividerPosInt < 0 || scannedDividerPosInt > list.size()) {
                    service.getView().printMsg(ListView.TRY_AGAIN_DVD_MESSAGE);
                    continue;
                }
                list.add(scannedDividerPosInt, 0);
                break;
            }
        }
        return list;
    }
}
