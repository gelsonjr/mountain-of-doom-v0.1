import javax.swing.*;

public class    Combat {

    public Combat(Player player, Enemy enemy, Dice die) {

        int combatOption;
        int diceRoll;
        boolean runAway = false;

        while (!player.isDead() && !enemy.isDead() && !runAway) {
            do {
                combatOption = combatMenu(player, enemy);
                if (combatOption == 1) { // ATTACK
                    // player turn
                    diceRoll = die.roll3();
                    enemy.damageReceived(player.attack(diceRoll));
                    if (!enemy.isDead()) {
                        // enemy turn
                        JOptionPane.showMessageDialog(null, "Enemy's turn: The enemy attacks you " +
                                "for " + enemy.attack() + " damage");
                        player.damageReceived(enemy.attack());
                    } else {
                        JOptionPane.showMessageDialog(null, enemy.getName() + " is dead.");
                    }
                    if (player.isDead()) {
                        JOptionPane.showMessageDialog(null, "You are dead");
                        player.addDeathCount();
                    }
                }
                else if (combatOption == 2) { // DEFEND
                    diceRoll = die.roll3();

                    if (diceRoll == 1) {
                        JOptionPane.showMessageDialog(null, "You roll a 1. You defend the enemy " +
                                "attack and receive no damage");
                    }
                    else if (diceRoll == 2) {
                        JOptionPane.showMessageDialog(null, "You roll a 2. You defend the enemy " +
                                "attack and counter-attack for " + (player.getAttackPower() / 2) +
                                " damage");
                        enemy.damageReceived(player.getAttackPower() / 2);
                    }
                    else if (diceRoll == 3) {
                        JOptionPane.showMessageDialog(null, "You roll a 3. Your defense fails and" +
                                " the monster attacks you for " + enemy.getAttackPower() + " damage");
                        player.damageReceived(enemy.getAttackPower());
                        if (player.getHealth() == 0) {
                            player.addDeathCount();
                        }
                    }
                }
                else if (combatOption == 3) { // RUN
                    diceRoll = die.roll3();

                    if (diceRoll == 1) {
                        JOptionPane.showMessageDialog(null, "You run away and manage to escape " +
                                "the battle");
                        runAway = true;
                    }
                    else if (diceRoll == 2) {
                        JOptionPane.showMessageDialog(null, "You manages to escape the battle, " +
                                "but the enemy inflicts on you a glancing blow and deals " +
                                (enemy.getAttackPower() / 2) + " damage");
                        player.damageReceived(enemy.getAttackPower() / 2);
                        if (player.isDead()) {
                            JOptionPane.showMessageDialog(null, "You are dead");
                            player.addDeathCount();
                        }
                        runAway = true;
                    }
                    else if (diceRoll == 3) {
                        JOptionPane.showMessageDialog(null, "You roll a 3. Your defense fails and" +
                                " the monster attacks you for " + enemy.getAttackPower() + " damage");
                        player.damageReceived(enemy.getAttackPower());
                        if (player.isDead()) {
                            JOptionPane.showMessageDialog(null, "You are dead");;
                            player.addDeathCount();
                        }
                    }
                }
                else if (combatOption == 4) { // QUIT
                    JOptionPane.showMessageDialog(null, "Good Bye!\n\n");
                    System.exit(0);
                }

            } while (combatOption != 4 && !player.isDead() && !enemy.isDead() && !runAway) ;
        }
    }

    public int combatMenu(Player player, Enemy enemy) {

        int menuInput;
        Integer[] menuButtons = {1, 2, 3, 4}; // showOptionDialog buttons

        menuInput = JOptionPane.showOptionDialog(null, player.status() + enemy.status() +
                        "Please select an option:\n\n" +
                        "1) Attack\n\n" +
                        "2) Defend\n\n" +
                        "3) Run Away\n\n" +
                        "4) Quit Game\n\n",
                "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                menuButtons, menuButtons[0]);

        // if "x" button is pressed the program will end
        if (menuInput == JOptionPane.CLOSED_OPTION){
            JOptionPane.showMessageDialog(null, "Thanks for playing!\n\n");
            System.exit(0);
        }

        return menuButtons[menuInput];
    }
}