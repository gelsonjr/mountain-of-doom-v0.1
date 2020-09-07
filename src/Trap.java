public class Trap extends Treasure{

    public Trap(String trapName, int trapDamage) {
        super(trapName, trapDamage);
        super.setType("trap");
    }
}