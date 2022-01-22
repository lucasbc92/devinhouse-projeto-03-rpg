package v2.entities;

public class Marksman extends CombatClass {
    private final static int ATK = 15;
    private final static int DEF = 25;
    private final static Weapon[] WEAPONS = {new Bow(), new Crossbow()};

    public Marksman(){
        super(ATK, DEF, WEAPONS);
    }
}
