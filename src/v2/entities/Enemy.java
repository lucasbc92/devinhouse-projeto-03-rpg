package v2.entities;

public abstract class Enemy extends CombatCharacter{
    public Enemy(int maxHp, int baseAtk, int baseDef, CombatClass combatClass, int chosenWeapon, String name, Gender gender) throws IndexOutOfBoundsException{
        super(maxHp, baseAtk, baseDef, combatClass, chosenWeapon, name, gender);
    }
}
