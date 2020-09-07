public class Armor extends Treasure{

    public Armor(String armorName, int armorHealthBonus) {
        super(armorName, armorHealthBonus);
        super.setType("armor");
    }
}