package v2.entities;

public class Axe extends Weapon {
    private final static int DAMAGE = 9;

    public Axe(){
        super(DAMAGE);
    }

    public String attackString(){
        return "com seu machado";
    }

    @Override
    public String toString(){
        return "Machado";
    }
}
