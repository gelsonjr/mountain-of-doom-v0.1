import javax.swing.*;
import java.util.HashMap;

public class MountainOfDoom {

    public static void main(String[] args) {

        // map areas: Shrines (healing), Battle
        MapArea[] location = new MapArea[21];
        createLocations(location); // to populate location objects

        // treasures: Weapon, Armor, Trap
        Treasure[] treasure = new Treasure[21];
        createTreasures(treasure); // to populate treasure objects

        /* HashMap<key, value> to store enemies and their locations:
           String (key) = location name
           Enemy (value) = objects from Enemy class */
        HashMap<String, Enemy> enemy = new HashMap<>();
        createEnemies(enemy); // to populate enemy objects

        // dice object
        Dice die = new Dice();

        // custom icons for message windows
        ImageIcon[] icon = new ImageIcon[5];
        createIcons(icon);

        welcome();

        // creating player character: Name, atk power, current health, maximum health
        Player player = new Player(createName(), 50, 1000, 1000);

        displayIntro(player);

        boolean gameOver = false;
        int diceRoll;

        do {
            diceRoll = die.roll(icon);

            player.moveForward(diceRoll);

            JOptionPane.showMessageDialog(null,
                    "You roll a " + diceRoll + " and move to location " + player.getPosition());

            // location event
            location[player.getPosition()].event(player, location, treasure, enemy, die, icon);

            if (player.getDeathCount() == 3) {
                JOptionPane.showMessageDialog(null, "Game Over");
                gameOver = true;
            }
            if (player.isDead()) {
                player.ressurectAtShrine();
            }
            if (enemy.get("Mountain Summit").isDead()) { // Dragon
                JOptionPane.showMessageDialog(null, "Congratulations");
                gameOver = true;
            }

            JOptionPane.showMessageDialog(null, "You are done with your current location. Get " +
                    "ready for the next one.");
        } while (!gameOver);
    }

    // ---------------Methods to populate objects, and display dialog messages

    public static String createName() {

        String name;

        do {
            name = JOptionPane.showInputDialog("Please enter your name: ");

            if (name == null){
                JOptionPane.showMessageDialog(null, "Thanks for playing!\n\n");
                System.exit(0);
            }
        } while (name.isEmpty());

        return name;
    }

    public static void welcome() {
        JOptionPane.showMessageDialog(null, "Welcome to Mountain of Doom!");
    }

    public static void displayIntro(Player player) {
        JOptionPane.showMessageDialog(null, player.getName() + ", your village was recently " +
                "attacked by the elder dragon Tiamat.\nMany of your friends and family were " +
                "slaughtered in the event and now you feel compelled to avenge them");
        JOptionPane.showMessageDialog(null, "The objective of the game is reaching the top of the" +
                " mountain, where Tiamat sleeps.\nAlong the way, you might find treasures to help" +
                " on your journey, but you will likely face many enemies as well --as the path to" +
                " the mountain is treacherous.\nYou have 3 lives, if you die 3 times = game over");
    }

    public static void createLocations(MapArea[] location) {
        location[0] = new Shrine("Broward Village"); // starting town
        location[1] = new Battleground("Fields of Gold");
        location[2] = new Battleground("Forbidden Forrest");
        location[3] = new Shrine("Shrine of Devotion");
        location[4] = new TreasureLocation("Hidden Cave");
        location[5] = new Battleground("The Queen's Road");
        location[6] = new Battleground("The Crossroads");
        location[7] = new Shrine("Shrine of Praying");
        location[8] = new TreasureLocation("Lost Tomb of Kings");
        location[9] = new Battleground("Swamp of Lament");
        location[10] = new Battleground("Death Marsh");
        location[11] = new Shrine("Shrine of Blessings");
        location[12] = new TreasureLocation("Cache of Riches");
        location[13] = new Battleground("Tower Outskirts");
        location[14] = new Battleground("Sky Tower");
        location[15] = new Shrine("Shrine of Skies");
        location[16] = new TreasureLocation("Deep Mines");
        location[17] = new Battleground("Mountain of Doom");
        location[18] = new Battleground("Pass of Despair");
        location[19] = new Shrine("Shrine of Hope");
        location[20] = new Battleground("Mountain Summit"); // dragon encounter
    }

    public static void createTreasures(Treasure[] treasure) {
        treasure[0] = new Weapon("Katana of Power", 60);
        treasure[1] = new Weapon("Scimitar of Might", 70);
        treasure[2] = new Weapon("Muramasa", 75);
        treasure[3] = new Weapon("Sword Breaker", 80);
        treasure[4] = new Weapon("Masamune", 90);
        treasure[5] = new Weapon("Master Sword", 100);
        treasure[6] = new Weapon("Vorpal Sword", 150);
        treasure[7] = new Armor("Helm of Kings", 350);
        treasure[8] = new Armor("Bracers of Deflection", 200);
        treasure[9] = new Armor("Leggins of Might", 400);
        treasure[10] = new Armor("Pauldrons of Ages", 250);
        treasure[11] = new Armor("Gauntlets of Power", 275);
        treasure[12] = new Armor("Draconic Breastplate", 500);
        treasure[13] = new Armor("Full Plate Armor of Invulnerability", 1000);
        treasure[14] = new Trap("Poison Gas", 100);
        treasure[15] = new Trap("Spike Trap", 160);
        treasure[16] = new Trap("Explosion", 250);
        treasure[17] = new Trap("Fireball", 200);
        treasure[18] = new Trap("Lightning Bolt", 200);
        treasure[19] = new Trap("Petrify", 150);
        treasure[20] = new Trap("Curse", 170);
    }

    public static void createEnemies(HashMap<String, Enemy> enemy) {
        // HashMap enemy.put(String key, Enemy value)
        enemy.put("Fields of Gold", new Enemy("Rogue Soldier", 25, 200, 200));
        enemy.put("Forbidden Forrest", new Enemy("Dark Elf", 35, 230, 230));
        enemy.put("The Queen's Road", new Enemy("Bandit", 30, 270, 270));
        enemy.put("The Crossroads", new Enemy("Nightmare", 25, 300, 300));
        enemy.put("Swamp of Lament", new Enemy("Swamp Serpent", 35, 300, 300));
        enemy.put("Death Marsh", new Enemy("Medusa", 40, 320, 320));
        enemy.put("Tower Outskirts", new Enemy("Ancient Eagle", 35, 320, 320));
        enemy.put("Sky Tower", new Enemy("Tower Guardian", 35, 400, 400));
        enemy.put("Mountain of Doom", new Enemy("Ice Ogre", 40, 500, 500));
        enemy.put("Pass of Despair", new Enemy("Frost Succubus", 50, 700, 700));
        enemy.put("Mountain Summit", new Enemy("Tiamat, King of Dragons", 100, 999, 999));
    }

    public static void createIcons(ImageIcon[] icon) {
        // icons for some dialog boxes
        icon[0] = new ImageIcon("src/mountain_of_doom/dice.png");
        icon[1] = new ImageIcon("src/mountain_of_doom/chest.png");
        icon[2] = new ImageIcon("src/mountain_of_doom/sword.png");
        icon[3] = new ImageIcon("src/mountain_of_doom/armor.png");
        icon[4] = new ImageIcon("src/mountain_of_doom/trap.png");
    }
}