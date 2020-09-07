public abstract class Treasure {

    private String name;
    private String type;
    private int modifier;

    public Treasure(String name, int modifier) {
        this.name = name;
        this.modifier = modifier;
        type = "type";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }
}