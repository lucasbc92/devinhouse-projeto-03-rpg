package v2.entities;

import java.util.Scanner;

public class Combat {
    public enum CombatWinner{
        PLAYER, ENEMY, NONE;
    }
    private final static int DAMAGE_MODIFIER = 50;
    private PlayableCharacter player;
    private Enemy enemy;

    public Combat(PlayableCharacter player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public PlayableCharacter getplayer(){
        return this.player;
    }

    public Enemy getEnemy(){
        return this.enemy;
    }

    public CombatWinner fight(){
        //Combatplayer[] players = {player, enemy};
        Dice20 d20 = new Dice20();
        boolean isPlayerTurn = true;
        Scanner in = new Scanner(System.in);
        while(player.getCurrentHp() > 0 && enemy.getCurrentHp() > 0){
            if(isPlayerTurn){
                int option = 0;
                do {
                    System.out.println("É sua vez! Atacar ou fugir?");
                    System.out.println("1 - Atacar");
                    System.out.println("2 - Fugir");
                    option = in.nextInt();
                    switch(option){
                        case 1: break;
                        case 2: return CombatWinner.NONE;
                        default: {
                            System.out.println("Opção inválida.");
                            option = 0;
                        }
                    } 
                } while (option == 0);
                int diceRoll = d20.roll();
                if(diceRoll == 1){
                    System.out.println("Você errou o ataque! Seu inimigo não sofreu dano.");
                }
                else if(diceRoll == 20){
                    int damage = this.takeCriticalDamage(player, enemy);
                    System.out.printf("Você acertou um ataque crítico! O inimigo sofreu %d de dano e agora possui %d pontos de vida.", damage, enemy.getCurrentHp());
                }
                else {
                    int damage = this.takeDamage(player, enemy);
                    System.out.printf("Você atacou! O inimigo sofreu %d de dano e agora possui %d pontos de vida.", damage, enemy.getCurrentHp());
                }
            } else {

            }
        }
        if(enemy.getCurrentHp() < 0){
            return CombatWinner.PLAYER;
        } else return CombatWinner.ENEMY;
    }

    public int takeCriticalDamage(CombatCharacter attacker, CombatCharacter defender){
        int damage = attacker.getTotalAtk();
        defender.takeDamage(damage);
        return damage;
    }

    public int takeDamage(CombatCharacter attacker, CombatCharacter defender){
        int damage = attacker.getTotalAtk() * DAMAGE_MODIFIER / (DAMAGE_MODIFIER + defender.getTotalDef());
        defender.takeDamage(damage);
        return damage;
    }
}
