import javax.swing.*;
import java.util.HashMap;

public class TreasureLocation extends MapArea{

    public TreasureLocation(String areaName) {
        super(areaName);
        super.setAreaEvent("treasure");
    }

    @Override
    public void event(Player player, MapArea[] location, Treasure[] treasure,
                      HashMap<String, Enemy> enemy, Dice die, ImageIcon[] icon) {

        int dice = die.roll20(); // roll 0-20

        JOptionPane.showMessageDialog(null, "-- Treasure --");
        JOptionPane.showMessageDialog(null,
                "You found a treasure chest.\nClick \"OK\" to open it.",
                null, JOptionPane.PLAIN_MESSAGE, icon[1]);
        JOptionPane.showMessageDialog(null, player.status() + getAreaName() + "\n\n");

        switch (treasure[dice].getType()) {
            case "weapon":
                player.equipWeapon(treasure[dice].getModifier());
                JOptionPane.showMessageDialog(null, player.status() +
                                "You found a " + treasure[dice].getName() + " inside.\n" +
                                "You equip the weapon and your new attack power is increased",
                                null, JOptionPane.PLAIN_MESSAGE, icon[2]);
                break;
            case "armor":
                player.equipArmor(treasure[dice].getModifier());
                JOptionPane.showMessageDialog(null, player.status() +
                                "You found a " + treasure[dice].getName() + " inside.\n" +
                                "You equip the armor and your new maximum health is increased",
                                null, JOptionPane.PLAIN_MESSAGE, icon[3]);
                break;
            case "trap":
                player.damageReceived(treasure[dice].getModifier());
                JOptionPane.showMessageDialog(null, player.status() +
                                "There is a " + treasure[dice].getName() + " trap inside.\n" +
                                "You take " + treasure[dice].getModifier() + " damage.",
                                null, JOptionPane.PLAIN_MESSAGE, icon[4]);
                break;
        }
    }
}