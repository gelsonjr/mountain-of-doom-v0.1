import javax.swing.*;
import java.util.HashMap;

public abstract class MapArea {

    private String areaName;
    private String areaEvent;

    public MapArea(String areaName) {
        this.areaName = areaName;
        areaEvent = "event";
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaEvent() {
        return areaEvent;
    }

    public void setAreaEvent(String areaEvent) {
        this.areaEvent = areaEvent;
    }

    public abstract void event(Player player, MapArea[] location, Treasure[] treasure,
                               HashMap<String, Enemy> enemy, Dice die, ImageIcon[] icon);
}