package v2.entities;

public class Sword extends Weapon {
    private final static int DAMAGE = 5;

    public Sword(){
        super(DAMAGE);
    }

     public String attackString(){
        return "com sua espada";
    }

    @Override
    public String toString(){
        return "Espada";
    }
}
