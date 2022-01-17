package v2.entities;

public abstract class CombatCharacter {
    public enum Gender{
        MASCULINE, FEMININE;
    }

    private int maxHp;
    private int currentHp;
    private int baseAtk;
    private int baseDef;
    private CombatClass combatClass;
    private Weapon weapon;
    private Gender gender;

    public CombatCharacter(int maxHp, int baseAtk, int baseDef, CombatClass combatClass, int chosenWeapon, Gender gender) throws IndexOutOfBoundsException{
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.combatClass = combatClass;
        this.weapon = combatClass.getWeapons()[chosenWeapon];
        this.gender = gender;
    }

    public int getMaxHp(){
        return this.maxHp;
    }

    public int getCurrentHp(){
        return this.currentHp;
    }

    public void takeDamage(int damage){ 
        this.currentHp -= damage;
    }

    public void refillHp(){
        this.currentHp = this.getMaxHp();
    }

    public int getBaseAtk(){
        return this.baseAtk;
    }

    public int getBaseDef(){
        return this.baseDef;
    }

    public void setBaseDef(int baseDef){
        this.baseDef = baseDef;
    }

    public int getTotalAtk(){
        return this.getBaseAtk() + this.getCombatClass().getAtk();
    }

    public int getTotalDef(){
        return this.getBaseDef() + this.getCombatClass().getDef();
    }

    public CombatClass getCombatClass(){
        return this.combatClass;
    }
    
    public Weapon getWeapon(){
        return this.weapon;
    }

    public Gender getGender(){
        return this.gender;
    }
}
