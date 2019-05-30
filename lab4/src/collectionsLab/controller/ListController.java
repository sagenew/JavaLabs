package collectionsLab.controller;

import collectionsLab.model.ListModel;
import collectionsLab.service.ListService;

public class ListController {
    private ListModel model;
    private ListService service;
    public ListController(){
        service = new ListService();
    }

    public void start()
    {
        initMenu: while (true) {
            switch (service.initMenu()) {
                case 1: {
                    model = new ListModel(service.getExampleList());
                    break;
                }
                case 2: {
                    model = new ListModel(service.getRandomList());
                    break;
                }
                case 3: {
                    model = new ListModel(service.getCreatedList());
                    break;
                }
                case 4: {
                    service.getEndOfWorkMessage();
                    break initMenu;
                }
            }
            service.processList(model);
            processMenu : while (true) {
                switch (service.processMenu()) {
                    case 1: {
                        service.changeDividerPosition(model);
                        service.processList(model);
                        break;
                    }
                    case 2: break processMenu;
                }
            }
        }
    }
}
