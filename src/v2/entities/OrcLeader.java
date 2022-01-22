package v2.entities;

public class OrcLeader extends Enemy {
    private final static int MAX_HP = 80;
    private final static int BASE_ATK = 17;
    private final static int BASE_DEF = 20;
    private final static int BASE_AGILITY = 90;
    private final static CombatClass COMBAT_CLASS = new Warrior();
    private final static int CHOSEN_WEAPON = 1;
    private final static String NAME = "Orque Líder";
    private final static Gender GENDER = Gender.MASCULINE;

    public OrcLeader() throws IndexOutOfBoundsException {
        super(MAX_HP, BASE_ATK, BASE_DEF, BASE_AGILITY, COMBAT_CLASS, CHOSEN_WEAPON, NAME, GENDER);
    }
}
