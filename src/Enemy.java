public class Enemy extends Character {

    public Enemy(String name, int attackPower, int health, int maxHealth) {
        super(name, attackPower, health, maxHealth);
    }

    public int attack() {
        return getAttackPower();
    }

    public void damageReceived(int damage) {
        damage = getHealth() - damage;
        setHealth(damage);
    }

    @Override
    public String status() {
        return  getName() +
                "\nHP: " + getHealth() + "/" + getMaxHealth() +
                "\nAtk: " + getAttackPower() +
                "\n--------------------------------\n\n";
    }
}