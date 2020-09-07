import javax.swing.*;
import java.util.Random;

public class Dice {
    private final Random randomGenerator;

    public Dice() {
        randomGenerator = new Random();
    }

    public int roll(ImageIcon[] icon) {
        JOptionPane.showMessageDialog(null, "Click \"Ok\" to roll the dice and move to next area.",
                null, JOptionPane.PLAIN_MESSAGE, icon[0]);
        return randomGenerator.nextInt(3) + 1; // 1-3
    }

    public int roll3() {
        return randomGenerator.nextInt(3) + 1; // 1-3
    }

    public int roll20() {
        return randomGenerator.nextInt(21); // 0-20
    }
}