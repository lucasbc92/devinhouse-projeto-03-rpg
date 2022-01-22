package v2.entities;

public class PlayableCharacter extends CombatCharacter {
    public enum Motivation {
        VENGEANCE("Vingança"),
        GLORY("Glória");

        private String name;
        
        private Motivation(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

    private final static int MAX_HP = 100;
    private final static int BASE_ATK = 20;
    private final static int BASE_DEF = 20;
    private final static int BASE_AGILITY = 50;
    private Motivation motivation;

    public PlayableCharacter(CombatClass combatClass, int chosenWeapon, String name, Gender gender) throws IndexOutOfBoundsException {
        super(MAX_HP, BASE_ATK, BASE_DEF, BASE_AGILITY, combatClass, chosenWeapon, name, gender);
    }

    public Motivation getMotivation(){
        return this.motivation;
    }

    public void setMotivation(Motivation motivation){
        this.motivation = motivation;
    }
}
