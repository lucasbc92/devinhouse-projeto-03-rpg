package v2.entities;

public class Book extends Weapon {
    private final static int DAMAGE = 9;

    public Book(){
        super(DAMAGE);
    }

    public String attackString(){
        return "absorvendo energia do livro com uma mão e liberando com a outra";
    }

    @Override
    public String toString(){
        return "Livro";
    }
}

