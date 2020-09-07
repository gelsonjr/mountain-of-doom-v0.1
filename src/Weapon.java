public class Weapon extends Treasure {

    public Weapon(String weaponName, int weaponAttackPower) {
        super(weaponName, weaponAttackPower);
        super.setType("weapon");
    }
}