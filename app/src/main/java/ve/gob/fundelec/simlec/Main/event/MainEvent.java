package ve.gob.fundelec.simlec.Main.event;

import java.util.List;

import ve.gob.fundelec.simlec.Main.adapter.ItemMenu;

/**
 * Created by fundelec on 10/07/17.
 */

public class MainEvent {
    public final static int onBackPress = 0;
    public final static int onButtonMenu = 1;
    public final static int onSearch = 2;
    public final static int onClickPresinto = 3;
    public final static int onClickSobrante = 4;

    private int eventType;

    private List<ItemMenu> list;


    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public List<ItemMenu> getList() {
        return list;
    }

    public void setList(List<ItemMenu> list) {
        this.list = list;
    }
}
