package v2.entities;

public class OrcWarrior extends Enemy {
    private final static int MAX_HP = 50;
    private final static int BASE_ATK = 5;
    private final static int BASE_DEF = 5;
    private final static CombatClass COMBAT_CLASS = new Warrior();
    private final static int CHOSEN_WEAPON = 0;
    private final static Gender GENDER = Gender.MASCULINE;

    public OrcWarrior() throws IndexOutOfBoundsException {
        super(MAX_HP, BASE_ATK, BASE_DEF, COMBAT_CLASS, CHOSEN_WEAPON, GENDER);
    }
}
