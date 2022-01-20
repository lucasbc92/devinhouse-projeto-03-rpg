package v2.entities;

public class Potion {
    private int value;

    public Potion(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void applyEffect(CombatCharacter character) {
        character.modifyCurrentHp(this.getValue());
    }
}
