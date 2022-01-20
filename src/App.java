import v2.entities.RolePlayingGame;
import v2.entities.GameFactory;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            RolePlayingGame game = GameFactory.createGame();
            game.play();
            System.out.println("FIM DO JOGO");
        } catch (NullPointerException e) {
            System.out.println("Erro ao criar jogo!");
            return;
        }        
    }
}
