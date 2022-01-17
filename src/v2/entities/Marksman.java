package v2.entities;

public class Marksman extends CombatClass {
    private final static int ATK = 14;
    private final static int DEF = 30;
    private final static Weapon[] WEAPONS = {new Bow(), new Crossbow()};

    public Marksman(){
        super(ATK, DEF, WEAPONS);
    }
}
