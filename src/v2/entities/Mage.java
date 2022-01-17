package v2.entities;

public class Mage extends CombatClass {
    private final static int ATK = 20;
    private final static int DEF = 15;
    private final static Weapon[] WEAPONS = {new Staff(), new Book()};

    public Mage(){
        super(ATK, DEF, WEAPONS);
    }
}

