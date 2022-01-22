package v2.entities;

public class Staff extends Weapon {
    private final static int DAMAGE = 25;
    private final static int AGILITY = 50;

    public Staff(){
        super(DAMAGE, AGILITY);
    }

    public String attackString(){
        return "com seu cajado, lançando uma bola de fogo";
    }

    @Override
    public String toString(){
        return "Cajado";
    }
}
