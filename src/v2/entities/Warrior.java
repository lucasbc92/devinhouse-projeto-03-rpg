package v2.entities;

public class Warrior extends CombatClass {
    private final static int ATK = 10;
    private final static int DEF = 40;
    private final static Weapon[] WEAPONS = {new Sword(), new Axe(), new Club()};

    public Warrior(){
        super(ATK, DEF, WEAPONS);
    }

    
}
