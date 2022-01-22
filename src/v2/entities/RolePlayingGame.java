package v2.entities;

import java.util.Scanner;

import v2.entities.Combat.CombatWinner;
import v2.entities.PlayableCharacter.Motivation;
import v2.exceptions.InvalidGenderException;
import v2.exceptions.InvalidMotivationException;

public class RolePlayingGame {
    private final static int NEW_ARMOR = 5;
    private DifficultyLevel difficultyLevel;
    private PlayableCharacter character;

    public RolePlayingGame(DifficultyLevel difficultyLevel, PlayableCharacter character){
        this.difficultyLevel = difficultyLevel;
        this.character = character;
    }

    public DifficultyLevel getDifficultyLevel(){
        return this.difficultyLevel;
    }

    public PlayableCharacter getCharacter(){
        return this.character;
    }

    public void play(){
        Scanner in = new Scanner(System.in);
        System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");
        System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno. Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.");
        System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");
        Motivation motivation = null;
        do {
            try {
                System.out.println("Escolha sua motivação para invadir a caverna do inimigo e derrotá-lo:");
                Motivation[] motivations = Motivation.values();
                for(int i = 0; i < motivations.length; i++){
                    System.out.printf("%d - %s%n", (i+1), motivations[i].getName());
                }
                int option = in.nextInt();
                if(option > 0 && option <= motivations.length) {
                    motivation = motivations[option-1]; // índice do array da arma escolhida é option - 1
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
            }            
        } while (motivation == null);
        this.getCharacter().setMotivation(motivation);
        motivation = this.getCharacter().getMotivation();
        switch(motivation){
            case VENGEANCE: {
                System.out.println("Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes, mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram. Elas são o combustível que te fizeram chegar até aqui. E você sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo. O maldito líder finalmente pagará por tanto mal causado na vida de tantos (e principalmente na sua).");
                break;
            }
            case GLORY: {
                System.out.println("Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos, bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilanças. Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas, depois de destruir o vilão que tanto assombrou a paz de todos. Porém, você sabe que ainda falta o último ato dessa história. Você se concentra na missão. A glória o aguarda, mas não antes da última batalha.");
                break;
            }
        }
        System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado. Você avança pelo portal.");
        System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua frente, só é possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.");
        int option = 0;
        do {
            try {
                System.out.println("1 - Seguir em frente");
                System.out.println("2 - Desistir");
                option = in.nextInt();
                switch(option) {
                    case 1: break;
                    case 2: {
                       System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se volta para a noite lá fora e corre em direção à segurança.");
                       return;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                        option = 0;
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
                option = 0;
            }
        } while (option == 0);
        System.out.println("Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
        System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, e pondera sobre como passar pela porta.");
        do {
            try {
                System.out.println("1 - Andando cuidadosamente");
                System.out.println("2 - Correndo");
                System.out.println("3 - Saltando");
                option = in.nextInt();
                switch(option) {
                    case 1: {
                        System.out.println("Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
                        Trap arrow = new Trap(new Dice10());
                        arrow.getDamage(this.getCharacter()); //considering true damage based in roll dice. It passes through armor.
                        break;
                    }
                    case 2: {
                        System.out.println("Você respira fundo e desata a correr em direção à sala. Quando passa pela porta, sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão. Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
                        break;
                    }
                    case 3: {
                        System.out.println("Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
                option = 0;
            }
        } while(option == 0);
        System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, mas reconhece como sendo a língua antiga utilizada pelo inimigo. Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas, e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais, antes de conseguir enfrentar o líder.");
        System.out.println("Você se dirige para a porta à direita.");
        System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara com uma sala espaçosa, com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas. Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da região.");
        System.out.println("Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate. Ele avança em sua direção.");
        boolean shouldContinue = enterInCombat(this, new OrcWarrior(), this.getCharacter().getTotalAgility());
        if(!shouldContinue) {
            return;
        }
        System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");
        do {
            try {
                System.out.println("1 - Pegar armaduras novas");
                System.out.println("2 - Não pegar armaduras novas");
                option = in.nextInt();
                switch(option) {
                    case 1: {
                        System.out.println("Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente mais protegido para os desafios à sua frente.");
                        int characterBaseDef = this.getCharacter().getBaseDef();
                        this.getCharacter().setBaseDef(characterBaseDef + NEW_ARMOR);
                        break;
                    }
                    case 2: {
                        System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                        option = 0;
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
                option = 0;              
            }
        } while(option == 0);
        System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");
        System.out.println("Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas, e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, criando poções utilizadas pelos soldados para aterrorizar a região.");
        System.out.println("No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");
        shouldContinue = enterInCombat(this, new OrcShaman(), this.getCharacter().getTotalAgility());
        if(!shouldContinue) {
            return;
        }
        System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo. Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado, pega a garrafa e pondera se deve beber um gole.");
        Potion potion = new Potion(this.getCharacter().getMaxHp());
        do {
            try {
                System.out.println("1 - Beber poção");
                System.out.println("2 - Não beber poção");
                option = in.nextInt();
                switch(option) {
                    case 1: {
                        System.out.println("Você se sente revigorado para seguir adiante!");
                        this.getCharacter().drinkPotion(potion);
                        break;
                    }
                    case 2: {
                        System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                        option = 0;
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
                option = 0;              
            }
        } while(option == 0);
        System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave abre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.");
        System.out.println("De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.");
        System.out.println("Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.");
        System.out.println("Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.");
        do {
            try {
                System.out.println("1 - Iniciar ataque");
                System.out.println("2 - Esperar");
                option = in.nextInt();
                switch(option) {
                    case 1: {
                        shouldContinue = enterInCombat(this, new OrcLeader(), this.getCharacter().getTotalAgility());
                        break;
                    }
                    case 2: {
                        shouldContinue = enterInCombat(this, new OrcLeader(), 0); // player waited, so initial agility is 0
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                        option = 0;
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                in.next();
                option = 0;              
            }
        } while(option == 0);
        if(!shouldContinue) {
            return;
        }
        System.out.println("VOCÊ CONSEGUIU!");
        switch(motivation){
            case VENGEANCE: {
                System.out.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
                break;
            }
            case GLORY: {
                System.out.println("O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
                break;
            }
        }
        System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em direção à noite, retornando à cidade. Seu dever está cumprido.");
        return;
    }
    
    private boolean enterInCombat(RolePlayingGame game, Enemy enemy, int playerInitialAgility) {
        Combat combat = new Combat(game, enemy);
        try {
            CombatWinner winner = combat.fight(playerInitialAgility);
            if(winner == CombatWinner.ENEMY){
                return false;
            }
            return true;
        } catch (InvalidGenderException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (InvalidMotivationException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
