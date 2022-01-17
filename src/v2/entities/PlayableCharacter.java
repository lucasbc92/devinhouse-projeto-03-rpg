package v2.entities;

public class PlayableCharacter extends CombatCharacter {
    public enum Motivation {
        VENGEANCE, GLORY
    }

    private final static int MAX_HP = 100;
    private final static int BASE_ATK = 10;
    private final static int BASE_DEF = 10;
    private Motivation motivation;

    public PlayableCharacter(CombatClass combatClass, int chosenWeapon, Gender gender) throws IndexOutOfBoundsException {
        super(MAX_HP, BASE_ATK, BASE_DEF, combatClass, chosenWeapon, gender);
    }

    public Motivation getMotivation(){
        return this.motivation;
    }

    public void setMotivation(Motivation motivation){
        this.motivation = motivation;
    }
}
