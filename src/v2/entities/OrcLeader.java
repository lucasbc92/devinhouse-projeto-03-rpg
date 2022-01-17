package v2.entities;

public class OrcLeader extends Enemy {
    private final static int MAX_HP = 80;
    private final static int BASE_ATK = 10;
    private final static int BASE_DEF = 10;
    private final static CombatClass COMBAT_CLASS = new Warrior();
    private final static int CHOSEN_WEAPON = 1;
    private final static Gender GENDER = Gender.MASCULINE;

    public OrcLeader() throws IndexOutOfBoundsException {
        super(MAX_HP, BASE_ATK, BASE_DEF, COMBAT_CLASS, CHOSEN_WEAPON, GENDER);
    }
}
