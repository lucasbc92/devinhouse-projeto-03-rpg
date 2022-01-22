package v2.entities;

public class Book extends Weapon {
    private final static int DAMAGE = 12;
    private final static int AGILITY = 80;

    public Book(){
        super(DAMAGE, AGILITY);
    }

    public String attackString(){
        return "absorvendo energia do livro com uma mão e liberando com a outra";
    }

    @Override
    public String toString(){
        return "Livro";
    }
}

