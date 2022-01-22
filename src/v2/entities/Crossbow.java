package v2.entities;

public class Crossbow extends Weapon {
    private final static int DAMAGE = 9;
    private final static int AGILITY = 81;

    public Crossbow(){
        super(DAMAGE, AGILITY);
    }

    public String attackString(){
        return "com sua besta, o virote atingiu";
    }

    @Override
    public String toString(){
        return "Besta e Virote";
    }
}