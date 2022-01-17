package v2.entities;

public class Club extends Weapon {
    private final static int DAMAGE = 7;

    public Club(){
        super(DAMAGE);
    }

    public String attackString(){
        return "com sua clava";
    }

    @Override
    public String toString(){
        return "Clava";
    }
}
