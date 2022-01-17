package v2.entities;

public class Bow extends Weapon {
    private final static int DAMAGE = 9;

    public Bow(){
        super(DAMAGE);
    }

    public String attackString(){
        return "com seu arco, a flecha atingiu";
    }

    @Override
    public String toString(){
        return "Arco e Flecha";
    }
}