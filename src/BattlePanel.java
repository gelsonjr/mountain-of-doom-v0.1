/*
package mountain_of_doom;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {

    // creating player character: Name, atk power, current health, maximum health
    Player player = new Player("Player", 50, 75, 100); // TEMP?
    Enemy enemy = new Enemy("Enemy", 20, 60, 100); // TEMP?
    Battle battle = new Battle();

    JProgressBar playerHealthBar, enemyHealthBar;

    public BattlePanel() {
        TopPanel topPanel = new TopPanel();
        BottomPanel bottomPanel = new BottomPanel();

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(600, 600));
        this.add(topPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public class TopPanel extends JPanel {
        //     WEST                  CENTER       SOUTH      EAST
        JPanel playerHealthBarPanel, centerPanel, infoPanel, enemyHealthBarPanel;

        // Player CardLayout panels
        CardLayout playerCardLayout;
        JPanel playerCardsPanel; // holds player cards
        JPanel playerPanel;
        JPanel playerCard1, playerCard2;
        //JProgressBar playerHealthBar;

        // Enemy CardLayout panels
        CardLayout enemyCardLayout;
        JPanel enemyPanel; // holds enemy cards
        JPanel enemyCard1, enemyCard2;
        //JProgressBar enemyHealthBar;

        public TopPanel() {

            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(600, 300));
            this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.LIGHT_GRAY));
            this.setBackground(new Color(199, 252, 200));

            createPlayerHealthBarPanel();
            createCenterPanel();
            createInfoPanel();
            createEnemyHealthBarPanel();

            this.add(playerHealthBarPanel, BorderLayout.WEST);
            this.add(centerPanel, BorderLayout.CENTER);
            this.add(infoPanel, BorderLayout.SOUTH);
            this.add(enemyHealthBarPanel, BorderLayout.EAST);
        }


        public void createPlayerHealthBarPanel() { // BorderLayout.WEST -> player health nar

            playerHealthBarPanel = new JPanel();
            playerHealthBarPanel.setOpaque(false);
            //playerHealthPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // TEMPORARY
            //playerHealthPanel.setBackground(Color.green); // TEMPORARY
            playerHealthBarPanel.setPreferredSize(new Dimension(36, 248));
            playerHealthBarPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 0, 0));

            playerHealthBar = new JProgressBar(SwingConstants.VERTICAL, 0, player.getMaxHealth());
            playerHealthBar.setValue(player.getHealth());
            playerHealthBar.setPreferredSize(new Dimension(16, 208));
            playerHealthBar.setBackground(Color.BLUE);
            playerHealthBar.setForeground(Color.YELLOW);
            playerHealthBar.setBorderPainted(false);
            playerHealthBarPanel.add(playerHealthBar);
        }

        public void createCenterPanel() { // BorderLayout.CENTER -> battle panels
            centerPanel = new JPanel(new BorderLayout());
            centerPanel.setOpaque(false);
            //centerPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // TEMPORARY
            //centerPanel.setBackground(Color.YELLOW);
            centerPanel.setPreferredSize(new Dimension(528, 248));

            createPlayerPanel();
            createEnemyPanel();

            centerPanel.add(playerPanel, BorderLayout.WEST);
            centerPanel.add(enemyPanel, BorderLayout.CENTER);

            //playerCardLayout.show(playerPanel, "player card 1");
        }

        public void createInfoPanel() { // BorderLayout.SOUTH -> messages & status info
            infoPanel = new JPanel();
            infoPanel.setOpaque(false);
            infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // TEMPORARY
            //infoPanel.setBackground(Color.CYAN);
            infoPanel.setPreferredSize(new Dimension(600, 47));
        }

        public void createEnemyHealthBarPanel() { // BorderLayout.EAST -> enemy health nar
            enemyHealthBarPanel = new JPanel();
            enemyHealthBarPanel.setOpaque(false);
            //enemyHealthPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // TEMPORARY
            //enemyHealthPanel.setBackground(Color.green);
            enemyHealthBarPanel.setPreferredSize(new Dimension(36, 248));
            enemyHealthBarPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 20));

            enemyHealthBar = new JProgressBar(SwingConstants.VERTICAL, 0, enemy.getMaxHealth());
            enemyHealthBar.setValue(enemy.getHealth());
            enemyHealthBar.setPreferredSize(new Dimension(16, 208));
            enemyHealthBar.setBackground(Color.BLUE);
            enemyHealthBar.setForeground(Color.RED);
            enemyHealthBar.setBorderPainted(false);
            enemyHealthBarPanel.add(enemyHealthBar);
        }

        public void createPlayerPanel() {
            playerPanel = new JPanel(playerCardLayout = new CardLayout());
            playerPanel.setOpaque(false);

            playerCard1 = new JPanel();
            playerCard1.setPreferredSize(new Dimension(264, 248));
            //playerCard1.setBackground(Color.cyan); // TEMPORARY
            playerCard1.setOpaque(false); // TEMPORARY

            playerCard2 = new JPanel();
            playerCard2.setPreferredSize(new Dimension(264, 248));
            playerCard2.setBackground(Color.magenta);

            playerPanel.add(playerCard1, "player card 1");
            playerPanel.add(playerCard2, "player card 2");
        }

        public void createEnemyPanel() {
            enemyPanel = new JPanel(enemyCardLayout = new CardLayout());
            enemyPanel.setOpaque(false);

            enemyCard1 = new JPanel();
            enemyCard1.setPreferredSize(new Dimension(264, 248));
            //enemyCard1.setBackground(Color.orange); // TEMPORARY
            enemyCard1.setOpaque(false); // TEMPORARY

            enemyCard2 = new JPanel();
            enemyCard2.setPreferredSize(new Dimension(264, 248));
            enemyCard2.setBackground(Color.darkGray);

            enemyPanel.add(enemyCard1, "enemy card 1");
            enemyPanel.add(enemyCard2, "enemy card 2");
        }
    }

    public class BottomPanel extends JPanel {

        JPanel actionsPanel, buttonsPanel, messagePanel, miniMapPanel;
        JButton attackButton, specialButton, healButton;

        public BottomPanel() {
            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(600, 300));
            this.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.LIGHT_GRAY));
            //this.setBackground(Color.YELLOW);

            createActionsPanel();
            createMiniMapPanel();

            this.add(actionsPanel, BorderLayout.CENTER);
            this.add(miniMapPanel, BorderLayout.EAST);
        }

        public void createActionsPanel() {
            actionsPanel = new JPanel();
            actionsPanel.setLayout(new BorderLayout());
            actionsPanel.setPreferredSize(new Dimension(300, 295));
            actionsPanel.setBackground(Color.DARK_GRAY);
            actionsPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.LIGHT_GRAY));

            createButtonsPanel();
            createMessagePanel();

            actionsPanel.add(buttonsPanel, BorderLayout.CENTER);
            actionsPanel.add(messagePanel, BorderLayout.SOUTH);
        }

        public void createMiniMapPanel() {
            miniMapPanel = new JPanel();
            miniMapPanel.setLayout(new BorderLayout());
            miniMapPanel.setPreferredSize(new Dimension(300, 295));
            miniMapPanel.setBackground(new Color(118, 229, 252));
            miniMapPanel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.LIGHT_GRAY));
        }

        public void createButtonsPanel() {
            buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
            buttonsPanel.setPreferredSize(new Dimension(295, 45));
            buttonsPanel.setBackground(Color.LIGHT_GRAY);

            attackButton = new JButton("Attack");
            attackButton.setPreferredSize(new Dimension(91, 45));
            attackButton.setMaximumSize(new Dimension(91, 45));
            //attackButton.addActionListener(event -> battle.test());
            attackButton.addActionListener(event -> {
                battle.attack(player, enemy);
                updateHealthBars();
            });
            //attackButton.setVisible(false);

            specialButton = new JButton("Special");
            specialButton.setPreferredSize(new Dimension(91, 45));
            specialButton.setMaximumSize(new Dimension(91, 45));

            healButton = new JButton("Heal");
            healButton.setPreferredSize(new Dimension(91, 45));
            healButton.setMaximumSize(new Dimension(91, 45));

            buttonsPanel.add(attackButton);
            buttonsPanel.add(Box.createHorizontalGlue()); // To add maximum spacing between buttons
            buttonsPanel.add(specialButton);
            buttonsPanel.add(Box.createHorizontalGlue());
            buttonsPanel.add(healButton);
        }

        public void createMessagePanel() {
            messagePanel = new JPanel();
            messagePanel.setLayout(new BorderLayout());
            messagePanel.setPreferredSize(new Dimension(295, 250));
            messagePanel.setBackground(Color.WHITE);
            messagePanel.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, Color.LIGHT_GRAY));
        }
    }

    public void updateHealthBars() {
        playerHealthBar.setValue(player.getHealth());
        enemyHealthBar.setValue(enemy.getHealth());
    }
}*/
