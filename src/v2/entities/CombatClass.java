package v2.entities;

public abstract class CombatClass {
    private int atk;
    private int def;
    private Weapon[] weapons;

    public CombatClass(int atk, int def, Weapon[] weapons){
        this.atk = atk;
        this.def = def;
        this.weapons = weapons;
    }

    public int getAtk(){
        return this.atk;
    }

    public int getDef(){
        return this.def;
    }

    public Weapon[] getWeapons(){
        return this.weapons;
    }


}
