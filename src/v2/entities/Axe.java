package v2.entities;

public class Axe extends Weapon {
    private final static int DAMAGE = 20;
    private final static int AGILITY = 55;

    public Axe(){
        super(DAMAGE, AGILITY);
    }

    public String attackString(){
        return "com seu machado";
    }

    @Override
    public String toString(){
        return "Machado";
    }
}
