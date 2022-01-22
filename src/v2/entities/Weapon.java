package v2.entities;

public abstract class Weapon {
    private int damage;
    private int agility;

    public Weapon(int damage, int agility){
        this.damage = damage;
        this.agility = agility;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getAgility(){
        return this.agility;
    }

    public abstract String attackString();

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
