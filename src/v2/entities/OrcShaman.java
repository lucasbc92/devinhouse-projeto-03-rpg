package v2.entities;

public class OrcShaman extends Enemy {
    private final static int MAX_HP = 50;
    private final static int BASE_ATK = 10;
    private final static int BASE_DEF = 4;
    private final static CombatClass COMBAT_CLASS = new Mage();
    private final static int CHOSEN_WEAPON = 0;
    private final static Gender GENDER = Gender.MASCULINE;

    public OrcShaman() throws IndexOutOfBoundsException {
        super(MAX_HP, BASE_ATK, BASE_DEF, COMBAT_CLASS, CHOSEN_WEAPON, GENDER);
    }
}
