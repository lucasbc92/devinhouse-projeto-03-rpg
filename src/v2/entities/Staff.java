package v2.entities;

public class Staff extends Weapon {
    private final static int DAMAGE = 9;

    public Staff(){
        super(DAMAGE);
    }

    public String attackString(){
        return "com seu cajado, lançando uma bola de fogo";
    }

    @Override
    public String toString(){
        return "Cajado";
    }
}
