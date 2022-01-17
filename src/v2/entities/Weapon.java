package v2.entities;

public abstract class Weapon {
    private int damage;

    public Weapon(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }

    public abstract String attackString();

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
