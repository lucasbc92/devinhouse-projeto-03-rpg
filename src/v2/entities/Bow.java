package v2.entities;

public class Bow extends Weapon {
    private final static int DAMAGE = 3;
    private final static int AGILITY = 115;

    public Bow(){
        super(DAMAGE, AGILITY);
    }

    public String attackString(){
        return "com seu arco, a flecha atingiu";
    }

    @Override
    public String toString(){
        return "Arco e Flecha";
    }
}