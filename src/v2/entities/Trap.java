package v2.entities;

public class Trap {
    private Dice dice;

    public Trap(Dice dice){
        this.dice = dice;
    }

    public int getDamage(CombatCharacter character){
        int damage = dice.roll();
        character.takeDamage(damage);
        System.out.printf("%s tomou %d de dano pela armadilha, e agora possui %d pontos de vida.%n", character.getName(), damage, character.getCurrentHp());
        return damage;
    }
}
