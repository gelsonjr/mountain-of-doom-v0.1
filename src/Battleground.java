import javax.swing.*;
import java.util.HashMap;

public class Battleground extends MapArea {

    public Battleground(String areaName) {
        super(areaName);
        super.setAreaEvent("battle");
    }

    @Override
    public void event(Player player, MapArea[] location, Treasure[] treasure,
                      HashMap<String, Enemy> enemy, Dice die, ImageIcon[] icon) {

        int position = player.getPosition();

        JOptionPane.showMessageDialog(null, "-- Battle --");
        JOptionPane.showMessageDialog(null, player.status() + getAreaName() + "\n\n");
        Combat combat = new Combat(player, enemy.get(location[position].getAreaName()), die);
    }
}