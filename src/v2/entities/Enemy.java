package v2.entities;

public abstract class Enemy extends CombatCharacter{
    public Enemy(int maxHp, int baseAtk, int baseDef, CombatClass combatClass, int chosenWeapon, Gender gender) throws IndexOutOfBoundsException{
        super(maxHp, baseAtk, baseDef, combatClass, chosenWeapon, gender);
    }
}
