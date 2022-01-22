package v2.entities;

public class Sword extends Weapon {
    private final static int DAMAGE = 5;
    private final static int AGILITY = 97;

    public Sword(){
        super(DAMAGE, AGILITY);
    }

     public String attackString(){
        return "com sua espada";
    }

    @Override
    public String toString(){
        return "Espada";
    }
}
