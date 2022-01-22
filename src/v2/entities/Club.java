package v2.entities;

public class Club extends Weapon {
    private final static int DAMAGE = 13;
    private final static int AGILITY = 72;

    public Club(){
        super(DAMAGE, AGILITY);
    }

    public String attackString(){
        return "com sua clava";
    }

    @Override
    public String toString(){
        return "Clava";
    }
}
