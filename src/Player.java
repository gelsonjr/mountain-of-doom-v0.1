import javax.swing.*;

public class Player extends Character{

    private int position;
    private int nextLocation;
    private int deathCount;

    public Player(String name, int attackPower, int health, int maxHealth) {
        super(name, attackPower, health, maxHealth);
        position = 0;
        nextLocation = 0;
        deathCount = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNextLocation() {
        return nextLocation;
    }

    public void setNextLocation(int nextLocation) {
        this.nextLocation = nextLocation;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public void addDeathCount() {
        this.deathCount += 1;
    }

    public void equipWeapon(int weapon) {
        setAttackPower(weapon);
    }

    public void equipArmor(int armor) {
        armor += getMaxHealth();
        setMaxHealth(armor);
    }

    public int attack(int diceRoll) {
        if (diceRoll == 1) {
            JOptionPane.showMessageDialog(null, "You rolled a 1. You attack for " +
                    getAttackPower() + " damage");
            return getAttackPower();
        }
        else if (diceRoll == 2) {
            JOptionPane.showMessageDialog(null, "You rolled a 2. You attack for " +
                    getAttackPower() * 2 + " damage [CRITICAL]");
            return getAttackPower() * 2;
        }
        else {
            JOptionPane.showMessageDialog(null, "You rolled a 3. The enemy blocks your attack and" +
                    " receives no damage");
            return 0;
        }
    }

    public void damageReceived(int damage) {
        setHealth(getHealth() - damage);
    }

    public void moveForward(int steps) {
        setNextLocation(getPosition() + steps);
        if (getNextLocation() > 20) {
            setNextLocation(20); // to avoid moving past final location (20)
        }
        setPosition(getNextLocation());
        setNextLocation(0);
    }

    public void ressurectAtShrine() {
        JOptionPane.showMessageDialog(null, "You are resurrected at the nearest Shrine");
        if (getPosition() < 3) {
            setPosition(0);
            JOptionPane.showMessageDialog(null, "You are back at location " + getPosition());
        }
        else if (getPosition() < 7) {
            setPosition(3);
            JOptionPane.showMessageDialog(null, "You are back at location " + getPosition());
        }
        else if (getPosition() < 11) {
            setPosition(7);
            JOptionPane.showMessageDialog(null, "You are back at location " + getPosition());
        }
        else if (getPosition() < 15) {
            setPosition(11);
            JOptionPane.showMessageDialog(null, "You are back at location " + getPosition());
        }
        else if (getPosition() < 19) {
            setPosition(15);
        }
        else {
            setPosition(19);
        }
        setHealth(getMaxHealth());
    }

    @Override
    public String status() {
        return  "Player " +
                "\nHP: " + getHealth() + "/" + getMaxHealth() +
                "\nAtk: " + getAttackPower() +
                "\nDeath Count: " + getDeathCount() +
                "\nLocation: " + getPosition() + "/20" +
                "\n--------------------------------\n\n";
    }
}