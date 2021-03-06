package v2.entities;

import java.util.Scanner;

import v2.entities.PlayableCharacter.Motivation;
import v2.exceptions.InvalidGenderException;
import v2.exceptions.InvalidMotivationException;

public class Combat {
    public enum CombatWinner{
        PLAYER, ENEMY
    }
    private final static int DAMAGE_MODIFIER = 50;
    private RolePlayingGame game;
    private Enemy enemy;

    public Combat(RolePlayingGame game, Enemy enemy){
        this.game = game;
        this.enemy = enemy;
    }

    public RolePlayingGame getGame(){
        return this.game;
    }

    public Enemy getEnemy(){
        return this.enemy;
    }

    public CombatWinner fight(int playerInitialAgility) throws InvalidGenderException, InvalidMotivationException{
        Scanner in = new Scanner(System.in);
        PlayableCharacter player = this.getGame().getCharacter();
        Enemy enemy = this.getEnemy();
        Dice d20 = new Dice20();
        Coin coin = new Coin();
        DifficultyLevel difficultyLevel = this.getGame().getDifficultyLevel();
        int totalPlayerAgility = playerInitialAgility;
        int totalEnemyAgility = enemy.getTotalAgility();
        boolean isPlayerTurn = true;
        while(player.getCurrentHp() > 0 && enemy.getCurrentHp() > 0){
            System.out.printf("Agilidade de %s: %d%n", player.getName(), totalPlayerAgility);
            System.out.printf("Agilidade de %s: %d%n", enemy.getName(), totalEnemyAgility);
            if(totalEnemyAgility > totalPlayerAgility){
                isPlayerTurn = false;
            } else if(totalPlayerAgility > totalEnemyAgility) {
                isPlayerTurn = true;
            } else { //if agility is equal, flip a coin to know who will attack
                int headsOrTails = coin.roll();
                if(headsOrTails == coin.getMaxValue()){
                    isPlayerTurn = true;
                } else {
                    isPlayerTurn = false;
                }
            }
            if(isPlayerTurn){
                int option = 0;
                do {
                    try {
                        System.out.println("Atacar ou fugir?");
                        System.out.println("1 - Atacar");
                        System.out.println("2 - Fugir");
                        option = in.nextInt();
                        switch(option){
                            case 1: break;
                            case 2: {
                                System.out.println("Voc?? n??o estava preparado para a for??a do inimigo, e decide fugir para que possa tentar novamente em uma pr??xima vez.");
                                return CombatWinner.ENEMY;
                            }
                            default: {
                                System.out.println("Op????o inv??lida.");
                                option = 0;
                            }
                        } 
                    } catch (Exception e){
                        System.out.println("Op????o inv??lida.");
                        option = 0;
                    }                   
                } while (option == 0);
                this.attack(player, enemy, d20, difficultyLevel);
                totalEnemyAgility += enemy.getTotalAgility();
            } else {
                this.attack(enemy, player, d20, difficultyLevel);
                totalPlayerAgility += player.getTotalAgility();
            }
        }
        if(enemy.getCurrentHp() <= 0){
            System.out.println("O inimigo n??o ?? p??reo para o seu hero??smo, e jaz im??vel aos seus p??s.");
            return CombatWinner.PLAYER;
        } else {
            System.out.print("Voc?? n??o estava preparado para a for??a do inimigo. ");
            Motivation motivation = player.getMotivation();
            switch(motivation){
                case VENGEANCE: {
                    System.out.println("N??o foi poss??vel concluir sua vingan??a, e agora resta saber se algu??m se vingar?? por voc??.");
                    break;
                }
                case GLORY: {
                    switch(player.getGender()){
                        case MASCULINE: {
                            System.out.println("A gl??ria que buscavas n??o ser?? sua, e a cidade aguarda por seu pr??ximo her??i.");
                            break;
                        }
                        case FEMININE: {
                            System.out.println("A gl??ria que buscavas n??o ser?? sua, e a cidade aguarda por sua pr??xima her??ina.");
                            break;
                        }
                        default: throw new InvalidGenderException("G??nero do personagem inv??lido.");
                    }                    
                }
                default: throw new InvalidMotivationException("Motiva????o do personagem inv??lida.");
            }
            return CombatWinner.ENEMY;
        }
    }

    private void attack(CombatCharacter attacker, CombatCharacter defender, Dice dice, DifficultyLevel difficultyLevel){
        int diceRoll = dice.roll();
        if(diceRoll == 1){
            System.out.printf("%s atacou %s e errou o ataque! %s n??o sofreu dano.%n", attacker.getName(), attacker.getWeapon().attackString(), defender.getName());
        }
        else if(diceRoll == dice.getMaxValue()){
            this.dealCriticalDamage(attacker, defender, diceRoll, difficultyLevel);
            
        }
        else {
            this.dealNormalDamage(attacker, defender, diceRoll, difficultyLevel);
        }
    }

    private void dealCriticalDamage(CombatCharacter attacker, CombatCharacter defender, int diceRoll, DifficultyLevel difficultyLevel){
        int damage = this.dealDamage(attacker, defender, 0, diceRoll, difficultyLevel); //0 defense: true damage
        System.out.printf("%s atacou %s e acertou um ataque cr??tico! %s sofreu %d de dano e agora possui %d pontos de vida.%n", attacker.getName(), attacker.getWeapon().attackString(), defender.getName(), damage, defender.getCurrentHp());
    }

    private void dealNormalDamage(CombatCharacter attacker, CombatCharacter defender, int diceRoll, DifficultyLevel difficultyLevel){
        int damage = this.dealDamage(attacker, defender, defender.getTotalDef(), diceRoll, difficultyLevel); // considers defender's defense
        System.out.printf("%s atacou %s! %s sofreu %d de dano e agora possui %d pontos de vida.%n", attacker.getName(), attacker.getWeapon().attackString(), defender.getName(), damage, defender.getCurrentHp());
    }

    private int dealDamage(CombatCharacter attacker, CombatCharacter defender, int defense, int diceRoll, DifficultyLevel difficultyLevel){
        int damage = (int)Math.floor((attacker.getTotalAtk() + diceRoll) * DAMAGE_MODIFIER / (DAMAGE_MODIFIER + defense));
        if(attacker instanceof Enemy){
            if(difficultyLevel == DifficultyLevel.EASY){
                damage = (int)Math.round(damage * DifficultyLevel.EASY.getDamagePercentual());
            }
        } else {
            if(difficultyLevel == DifficultyLevel.HARD){
                damage = (int)Math.round(damage * DifficultyLevel.HARD.getDamagePercentual());
            }
        }
        defender.takeDamage(damage);
        return damage;
    }
}
