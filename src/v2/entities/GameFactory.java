package v2.entities;

import java.util.Scanner;

import v2.entities.CombatCharacter.Gender;

public class GameFactory {
    private GameFactory(){

    }

    public static RolePlayingGame createGame(){
        Scanner in = new Scanner(System.in);
        System.out.println("Seja bem vindo(a) à BATALHA FINAL!");
        DifficultyLevel difficultyLevel = null;
        do {
            try {
                System.out.println("Escolha o nível de dificuldade:");
                System.out.println("1 - Fácil");
                System.out.println("2 - Normal");
                System.out.println("3 - Difícil");
                int option = in.nextInt();
                switch(option){
                    case 1: {
                        difficultyLevel = DifficultyLevel.EASY;
                        break;
                    }
                    case 2: {
                        difficultyLevel = DifficultyLevel.NORMAL;
                        break;
                    }
                    case 3: {
                        difficultyLevel = DifficultyLevel.HARD;
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
            }
        } while (difficultyLevel == null);
        in.nextLine();
        System.out.print("Escolha o nome do seu personagem: ");
        String name = in.nextLine();
        Gender gender = null;
        do {
            try {
                System.out.println("Escolha o gênero do seu personagem:");
                System.out.println("1 - Masculino");
                System.out.println("2 - Feminino");
                int option = in.nextInt();
                switch(option){
                    case 1: {
                        gender = Gender.MASCULINE;
                        break;
                    }
                    case 2: {
                        gender = Gender.FEMININE;
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
            }
        } while(gender == null);
        CombatClass combatClass = null;
        do {
            try {
                switch(gender){
                    case MASCULINE: {
                        System.out.println("Escolha a classe de combate do seu herói:");
                        System.out.println("1 - Guerreiro");
                        System.out.println("2 - Atirador");
                        System.out.println("3 - Mago");
                        break;
                    }
                    case FEMININE: {
                        System.out.println("Escolha a classe de combate da sua heroína:");
                        System.out.println("1 - Guerreira");
                        System.out.println("2 - Atiradora");
                        System.out.println("3 - Maga");
                        break;
                    }
                }                
                int option = in.nextInt();
                switch(option){
                    case 1: {
                        combatClass = new Warrior();
                        break;
                    }
                    case 2: {
                        combatClass = new Marksman();
                        break;
                    }
                    case 3: {
                        combatClass = new Mage();
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
            }
        } while(combatClass == null);
        int chosenWeapon = -1;
        do {
            try {
                switch(gender){
                    case MASCULINE: {
                        System.out.println("Escolha a arma do seu herói:");
                        break;
                    }
                    case FEMININE: {
                        System.out.println("Escolha a arma da sua heroína:");
                        break;
                    }
                }
                Weapon[] allowedWeapons = combatClass.getWeapons();
                for(int i = 0; i < allowedWeapons.length; i++) {
                    System.out.printf("%d - %s%n", (i+1), allowedWeapons[i]);
                }           
                int option = in.nextInt();
                if(option > 0 && option <= allowedWeapons.length) {
                    chosenWeapon = option - 1; // índice do array da arma escolhida é option - 1
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
            }
        } while(chosenWeapon == -1);
        PlayableCharacter character = new PlayableCharacter(combatClass, chosenWeapon, name, gender);
        RolePlayingGame game = new RolePlayingGame(difficultyLevel, character);
        return game;
    }
}
