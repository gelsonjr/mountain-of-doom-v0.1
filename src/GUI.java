/*
package mountain_of_doom;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static enum CardState {
        TITLE, INTRO, MAP1, STAGE1
    }
    CardState state;

    private JFrame frame;
    private CardLayout cardLayout;
    static JPanel cardContainer = new JPanel(new CardLayout()); // to hold all cards (game panels)
    private JPanel[] cardPanels = new JPanel[27];
    private int index = 3; // TEMPORARY

    public GUI() {
        initGUI();
    }

    private void initGUI() {
        frame = new JFrame("Mountain of Doom");

        cardContainer = new JPanel(cardLayout = new CardLayout());
        cardContainer.setPreferredSize(new Dimension(620, 620));
        cardContainer.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.LIGHT_GRAY));

        createCardPanels(index);
        cardContainer.add(cardPanels[index]);

        frame.add(cardContainer);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showGUI() {
        frame.setVisible(true);
    }

    public void createCardPanels(int index) {

        if (index == 0) {
            createGameOverPanel(cardPanels, index);
        } else if (index == 1) {
            createTitlePanel(cardPanels, index);
        } else if (index == 2) {
            createIntroPanel(cardPanels, index);
        } else if (index == 26) {
            createEndPanel(cardPanels, index);
        } else if (index % 2 == 0) {
            createMapPanel(cardPanels, index);
        } else {
            createBattlePanel(cardPanels, index);
        }
    }

    public void createGameOverPanel(JPanel[] panels, int index) {
        JLabel label = new JLabel("GAME OVER", SwingConstants.CENTER);
        JButton button = new JButton("NEXT");
        //button.addActionListener(event -> cardLayout.next(cardContainer));

        panels[index] = new JPanel();
        panels[index].setPreferredSize(new Dimension(600, 600));
        panels[index].setBackground(Color.BLACK);

        panels[index].add(label);
        panels[index].add(button);
    }

    public void createTitlePanel(JPanel[] panels, int index) {
        JLabel label = new JLabel("MOUNTAIN OF DOOM", SwingConstants.CENTER);
        JButton button = new JButton("NEXT");
        button.addActionListener(event -> cardLayout.next(cardContainer));

        panels[index] = new JPanel();
        panels[index].setPreferredSize(new Dimension(600, 600));
        panels[index].setBackground(Color.GREEN);

        panels[index].add(label);
        panels[index].add(button);
    }

    public void createIntroPanel(JPanel[] panels, int index) {
        JLabel label = new JLabel("INTRO", SwingConstants.CENTER);
        JButton button = new JButton("NEXT");
        button.addActionListener(event -> cardLayout.next(cardContainer));

        panels[index] = new JPanel();
        panels[index].setPreferredSize(new Dimension(600, 600));
        panels[index].setBackground(Color.BLUE);

        panels[index].add(label);
        panels[index].add(button);
    }

    public void createEndPanel(JPanel[] panels, int index) {
        JLabel label = new JLabel("THE END", SwingConstants.CENTER);
        JButton button = new JButton("QUIT");
        button.addActionListener(event -> System.exit(0));

        panels[index] = new JPanel();
        panels[index].setPreferredSize(new Dimension(600, 600));
        panels[index].setBackground(Color.BLACK);

        panels[index].add(label);
        panels[index].add(button);
    }

    public void createMapPanel(JPanel[] panels, int index) {
        JLabel label = new JLabel("MAP 1", SwingConstants.CENTER);
        JButton button = new JButton("NEXT");
        button.addActionListener(event -> cardLayout.next(cardContainer));

        panels[index] = new JPanel();
        panels[index].setPreferredSize(new Dimension(600, 600));
        panels[index].setBackground(new Color(212, 233, 252));

        panels[index].add(label);
        panels[index].add(button);
    }

    public void createBattlePanel(JPanel[] panels, int index) {
        panels[index] = new BattlePanel();
    }

*/
/*    private void gameLoop() {
        int cardNumber = 1;

        do {
            createCardPanels(cardNumber);
            // cardEvent
            // if dead > createCardPanels(0);
        } while ();
    }*//*


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gameGUI = new GUI();
            gameGUI.showGUI();
        });
    }
}*/
