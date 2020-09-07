import javax.swing.*;
import java.util.HashMap;

public class Shrine extends MapArea {

    public Shrine(String areaName) {
        super(areaName);
        super.setAreaEvent("healing");
    }

    @Override
    public void event(Player player, MapArea[] location, Treasure[] treasure,
                      HashMap<String, Enemy> enemy, Dice die, ImageIcon[] icon) {
        JOptionPane.showMessageDialog(null, "-- Healing --");
        JOptionPane.showMessageDialog(null, player.status() + getAreaName() + "\n\n");
        player.setHealth(player.getMaxHealth()); // Heals player to 100%
        JOptionPane.showMessageDialog(null, "The healing powers of the Shrine restore your " +
                "health to 100%");
    }

}